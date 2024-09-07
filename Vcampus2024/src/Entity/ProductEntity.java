package Entity;

import java.math.BigDecimal;
import java.io.Serializable;

public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    // 列名映射为Java类成员变量，数据类型根据SQL表定义
    private int pProductID; // 数据类型为int(10) unsigned zerofill，非空，自增，主键
    private String pName; // 数据类型为varchar(255)
    private BigDecimal pPrice; // 数据类型为decimal(10,2)，表示价格，使用BigDecimal以保持精度
    private int pInventory; // 数据类型为int
    private String pImg_url; // 数据类型为varchar(200)
    private float pScore; // 数据类型为float，非空，默认值为0
    private String pLabel; // 数据类型为varchar(500)
    private String pIntro; // 数据类型为text
    private String pAuthorIntro; // 数据类型为text
    private String pAutor; // 数据类型为varchar(50)

    public ProductEntity() {
    }

    public ProductEntity(int pProductID, String pName, BigDecimal pPrice, int pInventory, String pImg_url, float pScore,
            String pLabel, String pIntro, String pAuthorIntro) {
        this.pProductID = pProductID;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pInventory = pInventory;
        this.pImg_url = pImg_url;
        this.pScore = pScore;
        this.pLabel = pLabel;
        this.pIntro = pIntro;
        this.pAuthorIntro = pAuthorIntro;
    }

    public int getpProductID() {
        return this.pProductID;
    }

    public void setpProductID(int pProductID) {
        this.pProductID = pProductID;
    }

    public String getpName() {
        return this.pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public BigDecimal getpPrice() {
        return this.pPrice;
    }

    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    public int getpInventory() {
        return this.pInventory;
    }

    public void setpInventory(int pInventory) {
        this.pInventory = pInventory;
    }

    public String getpImg_url() {
        return this.pImg_url;
    }

    public void setpImg_url(String pImg_url) {
        this.pImg_url = pImg_url;
    }

    public float getpScore() {
        return this.pScore;
    }

    public void setpScore(float pScore) {
        this.pScore = pScore;
    }

    public String getpLabel() {
        return this.pLabel;
    }

    public void setpLabel(String pLabel) {
        this.pLabel = pLabel;
    }

    public String getpIntro() {
        return this.pIntro;
    }

    public void setpIntro(String pIntro) {
        this.pIntro = pIntro;
    }

    public String getpAuthorIntro() {
        return this.pAuthorIntro;
    }

    public void setpAuthorIntro(String pAuthorIntro) {
        this.pAuthorIntro = pAuthorIntro;
    }

    public String getpAutor() {
        return this.pAutor;
    }

    public void setpAutor(String pAutor) {
        this.pAutor = pAutor;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "pProductID=" + pProductID +
                ", pName='" + pName + '\'' +
                ", pPrice=" + pPrice +
                ", pInventory=" + pInventory +
                ", pImg_url='" + pImg_url + '\'' +
                ", pScore=" + pScore +
                ", pLabel='" + pLabel + '\'' +
                ", pIntro='" + pIntro + '\'' +
                ", pAuthorIntro='" + pAuthorIntro + '\'' +
                ", pAutor='" + pAutor + '\'' +
                '}';
    }
}
