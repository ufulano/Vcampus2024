package Entity;

public class ShoppingcartEntity {
    // 列名映射为Java类成员变量，数据类型根据SQL表定义
    private String uNumber; // 数据类型为varchar(15)，非空，主键
    private String pProductID; // 数据类型为int(10) unsigned zerofill，非空，主键
    private int sQuantity; // 数据类型为int
    private int pPrice; // 数据类型为int
    private int sTotalprice; // 数据类型为int

    public ShoppingcartEntity() {
    }

    public ShoppingcartEntity(String uNumber, String pProductID, int sQuantity, int pPrice, int sTotalprice) {
        this.uNumber = uNumber;
        this.pProductID = pProductID;
        this.sQuantity = sQuantity;
        this.pPrice = pPrice;
        this.sTotalprice = sTotalprice;
    }

    public String getUNumber() {
        return this.uNumber;
    }

    public String getpProductID() {
        return this.pProductID;
    }

    public int getsQuantity() {
        return this.sQuantity;
    }

    public int getpPrice() {
        return this.pPrice;
    }

    public int getsTotalprice() {
        return this.sTotalprice;
    }

    public void setsQuantity(int sQuantity) {
        this.sQuantity = sQuantity;
    }
}
