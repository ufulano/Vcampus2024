package tech.connection;

import java.net.Socket;
import java.io.*;

public class SocketClientWorker {

    private static SocketClientWorker instance;
    private static Socket clientSocket;
    private static ObjectOutputStream out;
    private static ObjectInputStream in;
    private Message message;
    private String IP;
    private int port;

    // 私有构造函数，防止外部实例化
    private SocketClientWorker() {
        IP = "127.0.0.1";// 192.168.68.210
        port = 8323;
    }

    // 获取该单例类
    public static synchronized SocketClientWorker getInstance() {
        if (instance == null) {
            instance = new SocketClientWorker();
        }
        return instance;
    }

    public void SetMessage(Message m) {
        message = m;
    }

    public void initialize(String ip, int p) {
        this.IP = ip;
        this.port = p;
    }

    public boolean Connect() {

        if (clientSocket == null || clientSocket.isClosed()) {
            try {
                clientSocket = new Socket(IP, port);
                out = new ObjectOutputStream(clientSocket.getOutputStream());
                in = new ObjectInputStream(clientSocket.getInputStream());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true; // 连接已存在或创建成功

    }

    public boolean SendMessage() {

        try {
            System.out.println("Sending..");
            System.out.println(message);
            out.writeObject(message);
            out.flush();            
            // out.close();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Message ReceiveMessage() {
        Message receivedMessage = new Message();
        try {
            while (true) {
                try {
                    receivedMessage = (Message) in.readObject();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return receivedMessage;
    }
}