package tech.connection;

import java.net.Socket;
import java.io.*;

public class SocketClientWorker {

    // 通信socket
    private Socket clientSocket;
    // 发送的消息内容
    private Message message;

    public SocketClientWorker(String host, int port, Message message) {
        try {
            this.clientSocket = new Socket(host, port);
            this.message = message;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public SocketClientWorker(Message message) {
        try {
            this.clientSocket = new Socket("192.168.101.210", 8323);
            this.message = message;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void SendMessage() {
        {
            try {
            	System.out.println("Sending...");
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                out.writeObject(this.message);
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}