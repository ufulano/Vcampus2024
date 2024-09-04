package tech.connection;

import java.net.Socket;

import tech.client.main.UserSession;

import java.io.*;

public class SocketClientWorker {

	private static SocketClientWorker instance;
    private Socket clientSocket;
    private Message message;
    private String IP;
    private int port;

    // 私有构造函数，防止外部实例化
    private SocketClientWorker() {
        IP = "192.168.68.210";// 192.168.101.210
        port = 8323;
    }
    
    //获取该单例类
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
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true; // 连接已存在或创建成功
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