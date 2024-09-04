package tech.client.library;

import Entity.BookEntity; // 导入tech.connection包中的所有类
import Entity.LoanEntity;
import java.util.ArrayList; // 导入ArrayList类
import java.util.List;
import tech.connection.*; // 导入List接口

public class Mlibrary 
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

    public String[] addbook(int bBookId, String bBookName, String bAuthor, String bPublisher, String bISBN, int bTotal, int bAvailable, String img_url)
    {
        Message message=new Message(Message.MessageType.LIBRARY);
        message.setdata("ADDBOOK");
        BookEntity bookentity=new BookEntity(bBookId, bBookName, bAuthor, bPublisher, bISBN, bTotal, bAvailable, img_url);
        message.setbookentity(bookentity);
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        return message.getdata();
    }
    public String[] addbook(BookEntity bookentity)
    {
        Message message=new Message(Message.MessageType.LIBRARY);
        message.setdata("ADDBOOK");
        message.setbookentity(bookentity);
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        return message.getdata();
    }
    public String[] removebook(int index)
    {
        Message message=new Message(Message.MessageType.LIBRARY);
        message.setdata("REMOVEBOOK");
        message.setbookentity(Bookarray.get(index));
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        return message.getdata();
    }
    public String[] removebook(BookEntity bookentity)
    {
        Message message=new Message(Message.MessageType.LIBRARY);
        message.setdata("REMOVEBOOK");
        message.setbookentity(bookentity);
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        return message.getdata();
    }
    public String[] changebook(BookEntity bookentity)
    {
        Message message=new Message(Message.MessageType.LIBRARY);
        message.setdata("CHANGEBOOK");
        message.setbookentity(bookentity);
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        return message.getdata();
    }

    public List<LoanEntity> checkuserborrowed(String Uid)//查看用户借阅书本
    {
        Bookarray.clear();
        Message message=new Message(Message.MessageType.LIBRARY);
        String[] data={"USERBORROWED",Uid};
        message.setdata(data);
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        return  message.getloanlist();
    }

    //下面的是帮助用户借书还书，暂时先放着，想做的话可以做
    // public String[] helpuserborrowbook(int index,String uid)
    // {
    //     Message message=new Message(Message.MessageType.LIBRARY);
    //     message.setdata("BORROWUSERBOOK",uid);
    //     message.setbookentity(Bookarray.get(index));
    //     System.out.println(message);
    //     SocketClientWorker connection=new SocketClientWorker(message);
    //     connection.SendMessage();
    //     message=connection.ReceiveMessage();
    //     System.out.println(message);
    //     Bookarray.remove(index);
    //     return message.getdata();
    // }
    // public String[] helpuserborrowbook(BookEntity bookentity,String uid)
    // {
    //     Message message=new Message(Message.MessageType.LIBRARY);
    //     message.setdata("BORROWUSERBOOK",uid);
    //     message.setbookentity(bookentity);
    //     System.out.println(message);
    //     SocketClientWorker connection=new SocketClientWorker(message);
    //     connection.SendMessage();
    //     message=connection.ReceiveMessage();
    //     System.out.println(message);
    //     Bookarray.remove(bookentity);
    //     return message.getdata();
    // }
    // public String[] helpuserreturnbook(int index,String uid)
    // {
    //     Message message=new Message(Message.MessageType.LIBRARY);
    //     message.setdata("RETURNUSERBOOK",uid);
    //     message.setbookentity(Bookarray.get(index));
    //     System.out.println(message);
    //     SocketClientWorker connection=new SocketClientWorker(message);
    //     connection.SendMessage();
    //     message=connection.ReceiveMessage();
    //     System.out.println(message);
    //     Bookarray.remove(index);
    //     return message.getdata();
    // }
    // public String[] helpuserreturnbook(BookEntity bookentity,String uid)
    // {
    //     Message message=new Message(Message.MessageType.LIBRARY);
    //     message.setdata("RETURNUSERBOOK",uid);
    //     message.setbookentity(bookentity);
    //     System.out.println(message);
    //     SocketClientWorker connection=new SocketClientWorker(message);
    //     connection.SendMessage();
    //     message=connection.ReceiveMessage();
    //     System.out.println(message);
    //     Bookarray.remove(bookentity);
    //     return message.getdata();
    // }
}
