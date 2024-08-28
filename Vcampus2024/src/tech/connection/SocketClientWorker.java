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
            this.clientSocket = new Socket("192.168.101.210", 8323);// 192.168.101.210
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
                // out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public Message ReceiveMessage() {
        Message receivedMessage = new Message("", "", "", 0, Message.MessageType.ERROR);
        try {
            InputStream inputStream = clientSocket.getInputStream();
            while (true) {
                try {
                    ObjectInputStream in = new ObjectInputStream(inputStream);
                    receivedMessage = (Message) in.readObject();
                    System.out.println("收到的对象: " + receivedMessage);
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
