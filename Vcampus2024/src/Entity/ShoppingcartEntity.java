package Entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ShoppingcartEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    // 列名映射为Java类成员变量，数据类型根据SQL表定义
    private String uNumber; // 数据类型为varchar(15)，非空，主键
    private String pProductID; // 数据类型为int(10) unsigned zerofill，非空，主键
    private int sQuantity; // 数据类型为int
    private BigDecimal pPrice; // 数据类型为BigDecimal
    private BigDecimal sTotalprice; // 数据类型为BigDecimal

    public ShoppingcartEntity() {
    }

    public ShoppingcartEntity(String uNumber, String pProductID, int sQuantity, BigDecimal pPrice,
            BigDecimal sTotalprice) {
        this.uNumber = uNumber;
        this.pProductID = pProductID;
        this.sQuantity = sQuantity;
        this.pPrice = pPrice;
        this.sTotalprice = sTotalprice;
    }

    public String getUNumber() {
        return this.uNumber;
    }

    public void setUNumber(String uNumber) {
        this.uNumber = uNumber;
    }

    public String getpProductID() {
        return this.pProductID;
    }

    public void setpProductID(String pProductID) {
        this.pProductID = pProductID;
    }

    public int getsQuantity() {
        return this.sQuantity;
    }

    public void setsQuantity(int sQuantity) {
        this.sQuantity = sQuantity;
    }

    public BigDecimal getpPrice() {
        return this.pPrice;
    }

    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    public BigDecimal getsTotalprice() {
        return this.sTotalprice;
    }

    public void setsTotalprice(BigDecimal sTotalprice) {
        this.sTotalprice = sTotalprice;
    }

    @Override
    public String toString() {
        return "ShoppingcartEntity{" +
                "uNumber='" + uNumber + '\'' +
                ", pProductID='" + pProductID + '\'' +
                ", sQuantity=" + sQuantity +
                ", pPrice=" + pPrice +
                ", sTotalprice=" + sTotalprice +
                '}';
    }
}
