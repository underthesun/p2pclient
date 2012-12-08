/*
 * Connection为一个UDP连接类，创建UDP套接字，用于发送和接收消息，以及注册更新
 */
package p2pclient;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ws
 */
public class Connection {

    private int client_port;
    private DatagramSocket dataSocket;
    private P2PClient client;
    private ReceiveConnection recv;
    private SendConnection send;
/*
     Connection方法根据参数，创建UDP套接字，并启动了一个接收消息线程ReceiveConnection
     */
    public Connection(P2PClient client, int client_port) {
        this.client = client;
        this.client_port = client_port;
        while (true) {
            try {
                dataSocket = new DatagramSocket(client_port);
                break;
            } catch (SocketException ex) {
                Logger.getLogger(P2PClient.class.getName()).log(Level.SEVERE, null, ex);
                client_port++;
            }
        }
        this.recv = new ReceiveConnection(dataSocket, this);
        Thread t = new Thread(this.recv);
        t.start();
        this.send = new SendConnection(dataSocket);
    }
/*
     KeepConnection方法调用Timer.schedule方法，完成定时注册更新任务
     */
    public void keepConnection() {
        Timer t = new Timer();
        ConnectionTask task = new ConnectionTask(dataSocket, this.client.username);
        t.schedule(task, 0, 15000);//每隔15秒注册一次
    }
/*
     parseCommand方法调用client的parseCommand方法解析收到的消息
     */
    public void parseCommand(String ip, int port, String data) {
        client.parseCommand(ip, port, data);
    }
/*
     sendMessage方法调用sendConnection方法发送消息
     */
    public void sendMessage(String ip, int port, String data) {
        this.send.sendMessage(ip, port, data);
    }
}
