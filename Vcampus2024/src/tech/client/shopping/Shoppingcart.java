package tech.client.shopping;

import Entity.OrderEntity;
import Entity.ProductEntity;
import Entity.ShoppingcartEntity; // 导入tech.connection包中的所有类
import java.util.ArrayList; // 导入ArrayList类
import java.util.List;
import tech.connection.*; // 导入List接口


public class Shoppingcart
{
    List<ShoppingcartEntity> shoppingcart=new ArrayList<>();//储存购物车中商品信息
    List<ProductEntity> productarray=new ArrayList<>();


    public List<ProductEntity> dispalyshop()
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
    
    public List<ProductEntity> search(String searchname)
    {
        productarray.clear();
        Message message=new Message(Message.MessageType.SHOP);
        String[] data = {"SEARCH", searchname};
        message.setdata(data);
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        productarray.addAll(message.getproductlist());
        return  productarray;
    }

    public String[] addcart(ProductEntity product,int quantity)
    {
        Message message=new Message(Message.MessageType.SHOP);
        message.setdata("ADDCART",String.valueOf(quantity));
        message.setproductentity(product);
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        return message.getdata();
    }

    public List<ShoppingcartEntity> getcart()
    {
        shoppingcart.clear();
        Message message=new Message(Message.MessageType.SHOP);
        message.setdata("GETCART");
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        shoppingcart.addAll(message.getshoppingcartlist());
        return shoppingcart;
    }

    public String[] removecart(int index)//通过传入商品列表的下标来进行删除商品的操作
    {
        Message message=new Message(Message.MessageType.SHOP);
        message.setdata("DELETEFROMCART");
        message.setshoppingcartentity(shoppingcart.get(index));
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        shoppingcart.remove(index);
        return message.getdata();
     
    }
    public String[] removecart(ShoppingcartEntity shoppingcartentity)//通过传入商品实例来进行删除商品的操作
    {
        Message message=new Message(Message.MessageType.SHOP);
        message.setdata("DELETEFROMCART");
        message.setshoppingcartentity(shoppingcartentity);
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        shoppingcart.remove(shoppingcartentity);
        return message.getdata();
    }

    public String[] checkbalance()//查看余额
    {
        Message message=new Message(Message.MessageType.SHOP);
        message.setdata("CHECKBALANCE");
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        System.out.println(message);
        return message.getdata();
    }


    public void submitcart()//提交订单
    {
        Message message=new Message(Message.MessageType.SHOP);
        message.setdata("SUBMITCART");
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
    }

    public List<OrderEntity> checkorder()//查看订单
    {
        Message message=new Message(Message.MessageType.SHOP);
        message.setdata("CHECKORDER");
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        return message.getorderlist();
    }
    public String[] payment()//支付
    {
        Message message=new Message(Message.MessageType.SHOP);
        message.setdata("PAY");
        System.out.println(message);
        SocketClientWorker connection=new SocketClientWorker(message);
        connection.SendMessage();
        message=connection.ReceiveMessage();
        System.out.println(message);
        shoppingcart.clear();
        return message.getdata();
    }
}