package tech.client.shopping;

import Entity.ProductEntity; // 导入tech.connection包中的所有类
import java.util.ArrayList;
import java.util.List; // 导入ArrayList类
import tech.connection.*;

public class Mshoppingcart 
{
    List<ProductEntity> productarray=new ArrayList<>();

    public List<ProductEntity> dispalyshop()//显示商店中的商品List<ProductEntity> 返回商品列表
    {
        productarray.clear();
        Message message=new Message(Message.MessageType.SHOP);
        message.setdata("DISPLAY");
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        productarray.addAll(message.getproductlist());
        return  productarray;
    }

    public String[] addproduct(ProductEntity productentity)
    {
        Message message=new Message(Message.MessageType.SHOP);
        message.setdata("ADDPRODUCT");
        message.setproductentity(productentity);
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        System.out.println(message);
        return message.getdata();
    }

    public String[] removeproduct(int index)//通过传入商品列表的下标来进行删除商品的操作
    {
        Message message=new Message(Message.MessageType.SHOP);
        message.setdata("REMOVEPRODUCT");
        message.setproductentity(productarray.get(index));
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        System.out.println(message);
        productarray.remove(index);
        return message.getdata();
    }
   
    public String[] removeproduct(ProductEntity productentity)//通过传入商品实例来进行删除商品的操作
    {
        Message message=new Message(Message.MessageType.SHOP);
        message.setdata("REMOVEPRODUCT");
        message.setproductentity(productentity);
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        System.out.println(message);
        productarray.remove(productentity);
       return message.getdata();
    }

    public String[] changeproduct(ProductEntity productentity)
    {
        Message message=new Message(Message.MessageType.SHOP);
        message.setdata("CHANGEPRODUCT");
        message.setproductentity(productentity);
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        return message.getdata();
    }

    public List<ProductEntity> searchproduct(String searchname)//搜索商品 List<ProductEntity> 返回符合搜索条件的商品列表
    {
        productarray.clear();
        Message message=new Message(Message.MessageType.SHOP);
        String[] data={"SEARCH",searchname};
        message.setdata(data);
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        productarray.addAll(message.getproductlist());
        return  productarray;
    }
}
