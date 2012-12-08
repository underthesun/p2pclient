/*
 * ReceiveConnection线程接收消息，并传递至客户端解析
 */
package p2pclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ws
 */
public class ReceiveConnection implements Runnable {

    private DatagramSocket dataSocket;
    private int bytelen = 1024;
    private byte[] buf = new byte[bytelen];//接受UDP端口数据
    private DatagramPacket dataReceived;
    private Connection c;

    public ReceiveConnection(DatagramSocket dataSocket,  Connection c) {
        this.dataSocket = dataSocket;
        dataReceived = new DatagramPacket(buf, bytelen);
        this.c=c;
    }

    @Override
    public void run() {
        while (true) {
            try {
                dataSocket.receive(dataReceived);
                String ip = dataReceived.getAddress().getHostAddress();
                int port = dataReceived.getPort();
                String data = new String(buf, 0, dataReceived.getLength());
//                String data = new String(dataReceived.getData(), "utf-8");
                c.parseCommand(ip,port,data);
            } catch (IOException ex) {
                Logger.getLogger(P2PClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
