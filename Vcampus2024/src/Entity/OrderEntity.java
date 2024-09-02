package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    // 列名映射为Java类成员变量，数据类型根据SQL表定义
    private int oOrderID; // 数据类型为int，非空，自增，主键
    private String uNumber; // 数据类型为varchar(15)，非空
    private int pProductID; // 数据类型为int(10) unsigned zerofill，非空
    private int oTotalAmount; // 数据类型为int，非空
    private BigDecimal pPrice; // 数据类型为int，非空
    private int oPayment; // 数据类型为int，非空，默认值
    private Date oDate; // 数据类型为datetime，非空

    public OrderEntity() {
    }

    public OrderEntity(int oOrderID, String uNumber, int pProductID, int oTotalAmount, BigDecimal pPrice,
            int oPayment, Date oDate) {
        this.oOrderID = oOrderID;
        this.uNumber = uNumber;
        this.pProductID = pProductID;
        this.oTotalAmount = oTotalAmount;
        this.pPrice = pPrice;
        this.oPayment = oPayment;
        this.oDate = oDate;
    }

    public int getoOrderID() {
        return this.oOrderID;
    }

    public void setoOrderID(int oOrderID) {
        this.oOrderID = oOrderID;
    }

    public String getUNumber() {
        return this.uNumber;
    }

    public void setUNumber(String uNumber) {
        this.uNumber = uNumber;
    }

    public int getpProductID() {
        return this.pProductID;
    }

    public void setpProductID(int pProductID) {
        this.pProductID = pProductID;
    }

    public int getoTotalAmount() {
        return this.oTotalAmount;
    }

    public void setoTotalAmount(int oTotalAmount) {
        this.oTotalAmount = oTotalAmount;
    }

    public BigDecimal getpPrice() {
        return this.pPrice;
    }

    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    public int getoPayment() {
        return this.oPayment;
    }

    public void setoPayment(int oPayment) {
        this.oPayment = oPayment;
    }

    public Date getoDate() {
        return this.oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "oOrderID=" + oOrderID +
                ", uNumber='" + uNumber + '\'' +
                ", pProductID=" + pProductID +
                ", oTotalAmount=" + oTotalAmount +
                ", pPrice=" + pPrice +
                ", oPayment=" + oPayment +
                ", oDate=" + oDate +
                '}';
    }
}
