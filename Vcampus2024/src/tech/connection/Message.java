package tech.connection;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Entity.*;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private String data[];
    private UserEntity userentity;
    private List<UserEntity> userlist = new ArrayList<>();
    private List<ShoppingcartEntity> shoppingcartlist = new ArrayList<>();
    private List<OrderEntity> orderlist = new ArrayList<>();    
    private List<ProductEntity> productlist = new ArrayList<>();
    private List<BookEntity> booklist = new ArrayList<>();


    private BookEntity bookentity;
    private CourseEntity courseentity;
    private EnrollmentEntity enrollment;
    private OrderEntity orderentity;
    private ProductEntity productentity;
    private ShoppingcartEntity shoppingcartentity;

    // private String Filepath;
    private MessageType Type;

    public enum MessageType {
        ERROR, USER, STU, COURSE, LIBRARY, SHOP;
    }

    public Message() {
        Type = MessageType.ERROR;
        data = null;
    }

    public Message(MessageType t) {
        Type = t;
        data = null;        
    }

    public Message(MessageType t, String... d) {
        Type = t;
        data = d;
    }

    public void setdata(String... d) {
        data = d;
    }

    public String[] getdata() {
        return data;
    }

    public void setuserentity(UserEntity u) {
        userentity = u;
    }

    public UserEntity getuserentity() {
        return userentity;
    }
    public void setorderentity(OrderEntity o) {
        orderentity = o;
    }

    public OrderEntity getorderentity() {
        return orderentity;
    }
    public void setuserlist(List<UserEntity> u) {
        userlist = u;
    }

    public List<UserEntity> getuserlisty() {
        return userlist;
    }

    public void setproductlist(List<ProductEntity> u) {
        productlist = u;
    }

    public List<ProductEntity> getproductlist() {
        return productlist;
    }    

    public void setorderlist(List<OrderEntity> o) {
        orderlist = o;
    }

    public List<OrderEntity> getorderlist() {
        return orderlist;
    }       

    public MessageType gettype() {
        return Type;
    }

    public void settype(MessageType t) {
        Type = t;
    }

    public String toString() {
        if (Type == MessageType.ERROR)
            return "ERROR";
        if(data == null)return "";
        String str = "";
        for (int i = 0; i < data.length; i++) {
            str += "data[" + i + "]: " + data[i] + "\n";
        }
        return str;
    }

    public void setbookentity(BookEntity b) {
        bookentity = b;
    }
    public BookEntity getbookentity() {
        return bookentity;
    }
    public List<BookEntity> getbooklist() {
        return booklist;
    }

    public ProductEntity getproductentity() {
        return productentity;
    }

    public void setproductentity(ProductEntity p) {
        productentity = p;
    }
    public void setshoppingcartentity(ShoppingcartEntity s) {
        shoppingcartentity = s;
    }
    public ShoppingcartEntity getshoppingcartentity() {
        return shoppingcartentity;
    }    
    public void setshoppingcartlist(List<ShoppingcartEntity> s) {
        shoppingcartlist = s;
    }
    public List<ShoppingcartEntity> getshoppingcartlist() {
        return shoppingcartlist;
    }

}
