/*
 * 聊天客户端应用程序
 * 1.其中client_port字段为聊天端口号；server_ip为服务器IP；server_port为服务器端口号；可根据需要更改成相应值
 * 2.消息采用UDP方式传输，程序启动会首先进行用户注册，并判断是否已经存在同名用户
 * 3.各方法功能解释见方法注释
 */
package p2pclient;

import beans.User;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import views.ClientFrame;

/**
 *
 * @author ws
 */
public class P2PClient {

    public String username;
    public static int client_port = 4445;
    public static String server_ip = "192.168.1.106";
    public static int server_port = 4444;
    public DatagramPacket dataReceived;
    private ClientFrame cf;
    private Connection c;
    public Boolean login = false;
    public Boolean reply = false;

    public P2PClient(ClientFrame cf) {
        this.cf = cf;
        c = new Connection(this, client_port);
    }
/*
     register方法完成用户注册功能：通过JOptionPane组件，提示输入用户名，将消息传递至服务器进行注册
     */
    public void register() {
        this.username = JOptionPane.showInputDialog(cf, "Please input your username");
        String data = "register:" + this.username;
        while (!this.login) {
            if (!this.reply) {
                this.c.sendMessage(server_ip, server_port, data);
            } else {
                this.username = JOptionPane.showInputDialog(cf, username + " is already used, please choose another");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(P2PClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.cf.username = this.username;
    }
/*
     parseCommand方法对收到的消息进行解析，判断消息类型，并根据消息类型进行相应操作
     */
    public void parseCommand(String ip, int port, String data) {
        int firstIndex = data.indexOf(":");
        System.out.println(data);
        String command = data.substring(0, firstIndex);
        if (command.equals("register")) {
            String register_result = data.substring(firstIndex + 1);
            System.out.println(register_result);
            this.reply = true;
            if (register_result.trim().equals("ok")) {
                this.login = true;
                System.out.println("login");
                this.c.keepConnection();
            }

        } else if (command.equals("list")) {
            this.reply = true;
            this.login = true;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(P2PClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            DefaultListModel model = new DefaultListModel();
            String list = data.substring(firstIndex + 1);
            String[] users = list.split(";");
            for (String temp : users) {
                String[] components = temp.split(" ");
                String username = components[0];
                try {
                    username = new String(username.getBytes(), "utf-8");
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(P2PClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                String temp_ip = components[1];
                int temp_port = Integer.parseInt(components[2]);
                User user = new User(username, temp_ip, temp_port);
                System.out.println(username);
                model.addElement(user);
            }
            this.cf.model_list1 = model;
            if (this.cf.jList1 != null) {
                this.cf.jList1.setModel(model);
            }
        } else if (command.equals("chat")) {
            String message = data.substring(firstIndex + 1);
            try {
                message = new String(message.getBytes(), "utf-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(P2PClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            appendText(message);
        }
    }
/*
     appendText方法将收到的信息显示至聊天显示区域
     */
    public void appendText(String data) {
        String message = this.cf.jEditorPane1.getText();
        message = message + data + "\n";
        this.cf.jEditorPane1.setText(message);
    }
/*
     SendMessage方法发送消息至相应用户
     */
    public void sendMessage(Object[] elements, String message) {
        for (Object element : elements) {
            User user = (User) element;
            String data = "chat:" + this.username + ":" + message;
            this.c.sendMessage(user.getIp(), user.getPort(), data);
        }
    }
}
