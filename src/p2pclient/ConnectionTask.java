/*
 * ConnectionTask继承TimerTask类，完成定时注册更新功能
 */
package p2pclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ws
 */
public class ConnectionTask extends TimerTask {
    
    private DatagramSocket socket;
    private String username;
    
    public ConnectionTask(DatagramSocket socket, String username) {
        this.socket = socket;
        this.username = username;
    }
/*
     SendToServer方法发送注册信息至服务器
     */    
    public void sendToServer(String result) {
        try {
            byte[] dataByte;
            dataByte = result.getBytes();
            DatagramPacket packet = new DatagramPacket(dataByte, dataByte.length, InetAddress.getByName(P2PClient.server_ip), P2PClient.server_port);
            socket.send(packet);
        } catch (UnknownHostException ex) {
            Logger.getLogger(P2PClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(P2PClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        String result = "connect:" + username;
        sendToServer(result);
    }
}
