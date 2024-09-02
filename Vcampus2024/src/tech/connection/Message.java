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
    List<ShoppingcartEntity> shoppingcart = new ArrayList<>();
    List<ProductEntity> productEntity = new ArrayList<>();
    List<BookEntity> Bookentiy = new ArrayList<>();

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

    public void setuserlist(List<UserEntity> u) {
        userlist = u;
    }

    public List<UserEntity> getuserlisty() {
        return userlist;
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

    public void copybookentity(BookEntity booke) {
        bookentity = booke;
    }

    public List<BookEntity> getBookEntity() {
        return Bookentiy;
    }

    public void copyproduct(ProductEntity producte) {
        productentity = producte;
    }

    public void copyshoppingcart(List<ShoppingcartEntity> shoppingc) {
        shoppingcart.addAll(shoppingc);
    }

    public List<ProductEntity> getProductEntity() {
        return productEntity;
    }

}