package tech.client.library;

import Entity.BookEntity;
import Entity.LoanEntity; // 导入tech.connection包中的所有类
import java.util.ArrayList; // 导入ArrayList类
import java.util.List;
import tech.connection.*; // 导入List接口


public class Library 
{
    List<BookEntity> Bookarray=new ArrayList<>();

    public List<BookEntity> displaylibrary()
    {
        Bookarray.clear();
        Message message=new Message(Message.MessageType.SHOP);
        message.setdata("DISPLAY");
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        Bookarray.addAll(message.getbooklist());
        return  Bookarray;
    }

    public List<BookEntity> searchbook(String searchname)
    {
        Bookarray.clear();
        Message message=new Message(Message.MessageType.LIBRARY);
        String[] data={"SEARCH",searchname};
        message.setdata(data);
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        Bookarray.addAll(message.getbooklist());
        return  Bookarray;

    }

    public String[] borrowbook(int index,String data)//data为借阅时长
    {
        Message message=new Message(Message.MessageType.LIBRARY);
        message.setdata("BORROW",data);
        message.setbookentity(Bookarray.get(index));
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        System.out.println(message);
        return message.getdata();
    }
    public String[] borrowbook(BookEntity bookentity,String data)
    {
        Message message=new Message(Message.MessageType.LIBRARY);
        message.setdata("BORROW",data);
        message.setbookentity(bookentity);
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        System.out.println(message);
        return message.getdata();
    }
    public String[] returnbook(int index)
    {
        Message message=new Message(Message.MessageType.LIBRARY);
        message.setdata("RETURN");
        message.setbookentity(Bookarray.get(index));
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        System.out.println(message);
        Bookarray.remove(index);
        return message.getdata();
    }
    public String[] returnbook(BookEntity bookentity)
    {
        Message message=new Message(Message.MessageType.LIBRARY);
        message.setdata("RETURN");
        message.setbookentity(bookentity);
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        System.out.println(message);
        Bookarray.remove(bookentity);
        return message.getdata();
    }
    public List<LoanEntity> borrowedbook()//查看已借书本
    {
        Bookarray.clear();    
        Message message=new Message(Message.MessageType.LIBRARY);
        message.setdata("SEARCHBORROWED");
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        return  message.getloanlist();
    }

}
