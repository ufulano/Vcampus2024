package tech.connection;


import java.io.IOException;
import java.io.Serializable;

public class Message implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String Uid;
    private String Password;
    private String serverIp;
    private int serverPort;

   public Message(String uid, String password, String serverip, int serverport) //throws IOException
    {
        Uid=uid;
        Password=password;
        serverIp=serverip;
        serverPort=serverport;
    }

    void setuid(String uid)
    {
        Uid=uid;
    }

    void setpassword(String password)
    {
        Password=password;
    }

    void setserverip(String serverip)
    {
        serverIp=serverip;
    }

    void setserverport(int serverport)
    {
        serverPort=serverport;
    }
    public String toString()
     {
        return "message{uid='" + Uid + "', password='" + Password + "', serverip='" + serverIp + "', serverport=" + serverPort + "}";

    }
}
