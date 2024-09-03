package tech.connection;

import java.net.Socket;
import java.io.*;

public class SocketClientWorker {

    private Socket clientSocket;
    private Message message;
    private String IP;
    private int port;

    public SocketClientWorker() {
        IP = "127.0.0.1";// 192.168.101.210
        port = 8323;
    }
    public SocketClientWorker(Message m) {
        IP = "192.168.68.210";// 192.168.101.210
        port = 8323;
        message = m;
    }
    public SocketClientWorker(String ip, int p) {
        IP = ip;
        port = p;
    }

    public SocketClientWorker(String ip, int p, Message m) {
        IP = ip;
        port = p;
        message = m;
    }

    public void SetMessage(Message m) {
        message = m;
    }

    public boolean Connect() {
        try {
            this.clientSocket = new Socket(IP, port);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean SendMessage() {

        try {
            System.out.println("Sending..");
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.writeObject(this.message);
            out.flush();
            return true;
            // out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Message ReceiveMessage() {
        Message receivedMessage = new Message();
        try {
            InputStream inputStream = clientSocket.getInputStream();
            while (true) {
                try {
                    ObjectInputStream in = new ObjectInputStream(inputStream);
                    receivedMessage = (Message) in.readObject();
                    break;
                } catch (Exception e) {
                    System.out.println("断开连接");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return receivedMessage;
    }
}