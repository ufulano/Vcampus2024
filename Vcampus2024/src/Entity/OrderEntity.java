package Entity;

import java.io.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    // 列名映射为Java类成员变量，数据类型根据SQL表定义
    private int oOrderID; // 数据类型为int，非空，自增，主键
    private String uNumber; // 数据类型为varchar(15)，非空
    private BigDecimal oPayment;
    private Date oDate; // 数据类型为datetime，非空

    private byte[] oShoppingCart;
    private List<ShoppingcartEntity> ShoppingCart;

    public OrderEntity() {
    }

    public OrderEntity(String uNumber, BigDecimal oPayment, List<ShoppingcartEntity> ShoppingCart) {
        this.uNumber = uNumber;
        this.oPayment = oPayment;
        this.ShoppingCart = ShoppingCart;
        Object2Byte();
    }

    public OrderEntity(int oOrderID, String uNumber,
            BigDecimal oPayment, Date oDate, List<ShoppingcartEntity> ShoppingCart) {
        this.oOrderID = oOrderID;
        this.uNumber = uNumber;
        this.oPayment = oPayment;
        this.oDate = oDate;
        this.ShoppingCart = ShoppingCart;
        Object2Byte();
    }

    public int getoOrderID() {
        return this.oOrderID;
    }

    public void setoOrderID(int oOrderID) {
        this.oOrderID = oOrderID;
    }

    public String getuNumber() {
        return this.uNumber;
    }

    public void setuNumber(String uNumber) {
        this.uNumber = uNumber;
    }

    public BigDecimal getoPayment() {
        return this.oPayment;
    }

    public void setoPayment(BigDecimal oPayment) {
        this.oPayment = oPayment;
    }

    public Date getoDate() {
        return this.oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    public void setShoppingCart(List<ShoppingcartEntity> ShoppingCart) {
        this.ShoppingCart = ShoppingCart;
        Object2Byte();
    }

    public List<ShoppingcartEntity> getShoppingCart() {
        return this.ShoppingCart;
    }

    public byte[] getoShoppingCart() {

        return this.oShoppingCart;
    }

    public void setoShoppingCart(byte[] b) {
        oShoppingCart = b;
        Byte2Object(b);
    }

    public void Byte2Object(byte[] b) {
        try (ObjectInputStream out = new ObjectInputStream(new ByteArrayInputStream(b))) {
            ShoppingcartEntity[] obj = (ShoppingcartEntity[]) out.readObject();
            List<ShoppingcartEntity> listObject = Arrays.asList(obj);
            this.ShoppingCart = listObject;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void Object2Byte() {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(out)) {
            objectOutputStream.writeObject(this.ShoppingCart);
            objectOutputStream.flush();
            this.oShoppingCart = out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String str = "";
        str += "\n[";
        if (oShoppingCart != null) {

            for (int i = 0; i < ShoppingCart.size(); i++)
                str += ShoppingCart.get(i).getpProductID() + " ";

        }
        str += " ]";
        return "OrderEntity{" +
                "oOrderID=" + oOrderID +
                ", uNumber='" + uNumber + '\'' +
                ", oPayment=" + oPayment +
                ", oDate=" + oDate +
                ", ShoppingCart=" + str +
                '}';
    }
}
