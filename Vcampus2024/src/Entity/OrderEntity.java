package Entity;

public class OrderEntity {
    // 列名映射为Java类成员变量，数据类型根据SQL表定义
    private int oOrderID; // 数据类型为int，非空，自增，主键
    private String uNumber; // 数据类型为varchar(15)，非空
    private int pProductID; // 数据类型为int(10) unsigned zerofill，非空
    private int oTotalAmount; // 数据类型为int，非空
    private int pPrice; // 数据类型为int，非空
    private int oPayment; // 数据类型为int，非空，默认值

    public OrderEntity() {
    }

    public OrderEntity(int oOrderID, String uNumber, int pProductID, int oTotalAmount, int pPrice, int oPayment) {
        this.oOrderID = oOrderID;
        this.uNumber = uNumber;
        this.pProductID = pProductID;
        this.oTotalAmount = oTotalAmount;
        this.pPrice = pPrice;
        this.oPayment = oPayment;
    }

    public int getoOrderID() {
        return this.oOrderID;
    }

    public String getUNumber() {
        return this.uNumber;
    }

    public int getpProductID() {
        return this.pProductID;
    }

    public int getoTotalAmount() {
        return this.oTotalAmount;
    }

    public int getpPrice() {
        return this.pPrice;
    }

    public int getoPayment() {
        return this.oPayment;
    }

}
