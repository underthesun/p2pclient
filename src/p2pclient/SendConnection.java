/*
 * SendConnection了发送消息类，dataSocket为传输的UDP套接字
 * sendMessage方法发送消息至相应目的地址和端口
 */
package p2pclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ws
 */
public class SendConnection {

    private DatagramSocket dataSocket;

    public SendConnection(DatagramSocket dataSocket) {
        this.dataSocket = dataSocket;
    }

    public void sendMessage(String ip, int port, String message) {
        try {
            byte[] bytes = message.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(ip), port);
            dataSocket.send(packet);
        } catch (IOException ex) {
            Logger.getLogger(SendConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
