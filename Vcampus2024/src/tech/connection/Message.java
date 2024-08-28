package tech.connection;

import java.io.Serializable;
import Entity.*;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private String Uid;
    private String Passwaord;
    private String serverIp;
    private int serverPort;
    private String Response;
    private UserEntity userentity;
    // private BookEntity bookentity;
    // private CourseEntity courseentity;
    // private Enrollment enrollment;
    // private OrderEntity orderentity;
    // private ProductEntity productentity;
    // private ShoppingcartEntity shoppingcartentity;

    // private String Filepath;
    private MessageType Type;
    public void setuserentity(UserEntity u) {
        userentity = u;
    }
    public UserEntity getuserentity() {
        return userentity;
    }    
    public enum MessageType {
        LOGIN, LOGOUT, ENROLL, ERROR;
    }

    public MessageType gettype() {
        return Type;
    }

    public Message() {
        Uid = "";
        Passwaord = "";
        serverIp = "";
        serverPort = 0;
        Type = MessageType.ERROR;
    }

    public Message(MessageType t) {
        Uid = "";
        Passwaord = "";
        serverIp = "";
        serverPort = 0;
        Type = t;
    }

    public Message(String uid, String passwaord, String serverip, int serverport, MessageType type) {
        Uid = uid;
        Passwaord = passwaord;
        serverIp = serverip;
        serverPort = serverport;
        Type = type;
    }
    public void settype(MessageType t) {
        Type = t;
    }
    public void setuid(String uid) {
        Uid = uid;
    }

    public String getuid() {
        return Uid;
    }

    public String getpassword() {
        return Passwaord;
    }

    public void setpassword(String passwaord) {
        Passwaord = passwaord;
    }

    public void setserverip(String serverip) {
        serverIp = serverip;
    }

    public void setserverport(int serverport) {
        serverPort = serverport;
    }

    public void setresponse(String response) {
        Response = response;
    }

    public String getresponse() {
        return Response;
    }

    public String toString() {
        if (Type == MessageType.ERROR)
            return "ERROR";
        return "message{uid='" + Uid + "', password='" + Passwaord + "', serverip='" + serverIp + "', serverport='"
                + serverPort + "}";

    }

}