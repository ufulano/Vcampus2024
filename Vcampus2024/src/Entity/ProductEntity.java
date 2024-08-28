package Entity;

import java.math.BigDecimal;

public class ProductEntity {
    // 列名映射为Java类成员变量，数据类型根据SQL表定义
    private int opProductID; // 数据类型为int(10) unsigned zerofill，非空，自增，主键
    private String pName; // 数据类型为varchar(255)
    private BigDecimal pPrice; // 数据类型为decimal(10,2)，表示价格，使用BigDecimal以保持精度
    private int pInventory; // 数据类型为int
    private String img_url; // 数据类型为varchar(200)
    private float pScore; // 数据类型为float，非空，默认值为0
    private String pLabel; // 数据类型为varchar(500)
    private String plntro; // 数据类型为text
    private String pAuthorIntro; // 数据类型为text

    public ProductEntity() {
    }

    public ProductEntity(int opProductID, String pName, BigDecimal pPrice, int pInventory, String img_url, float pScore,
            String pLabel, String plntro, String pAuthorIntro) {
        this.opProductID = opProductID;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pInventory = pInventory;
        this.img_url = img_url;
        this.pScore = pScore;
        this.pLabel = pLabel;
        this.plntro = plntro;
        this.pAuthorIntro = pAuthorIntro;
    }

    public int getOpProductID() {
        return this.opProductID;
    }

    public String getpName() {
        return this.pName;
    }

    public BigDecimal getpPrice() {
        return this.pPrice;
    }

    public int getpInventory() {
        return this.pInventory;
    }

    public String getImg_url() {
        return this.img_url;
    }

    public float getpScore() {
        return this.pScore;
    }

    public String getpLabel() {
        return this.pLabel;
    }

    public String getPlntro() {
        return this.plntro;
    }

    public String getpAuthorIntro() {
        return this.pAuthorIntro;
    }

    public void setpInventory(int pInventory) {
        this.pInventory = pInventory;
    }

}
