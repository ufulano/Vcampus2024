package Entity;

import java.math.BigDecimal;
import java.io.Serializable;

public class EnrollmentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    // 列名映射为Java类成员变量，数据类型根据SQL表定义
    private int eID;
    private String cCourseID; // 数据类型为int
    private String uName; // 数据类型为varchar(10)
    private String uNumber; // 数据类型为varchar(15)，非空，主键之一
    private BigDecimal eScore; // 数据类型为decimal(4,2)，默认值为0.00
    private BigDecimal eCredits; // 数据类型为decimal(4,2)，默认值为0.00

    public EnrollmentEntity() {
    }

    public EnrollmentEntity(int eID, String cCourseID, String uName, String uNumber, BigDecimal eScore,
            BigDecimal eCredits) {
        this.eID = eID;
        this.cCourseID = cCourseID;
        this.uName = uName;
        this.uNumber = uNumber;
        this.eScore = eScore;
        this.eCredits = eCredits;
    }

    public int geteID() {
        return this.eID;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    public String getcCourseID() {
        return this.cCourseID;
    }

    public void setcCourseID(String cCourseID) {
        this.cCourseID = cCourseID;
    }

    public String getuName() {
        return this.uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuNumber() {
        return this.uNumber;
    }

    public void setuNumber(String uNumber) {
        this.uNumber = uNumber;
    }

    public BigDecimal geteScore() {
        return this.eScore;
    }

    public void seteScore(BigDecimal eScore) {
        this.eScore = eScore;
    }

    public BigDecimal geteCredits() {
        return this.eCredits;
    }

    public void seteCredits(BigDecimal eCredits) {
        this.eCredits = eCredits;
    }

    @Override
    public String toString() {
        return "EnrollmentEntity{" +
                " cCourseID='" + getcCourseID() + "'" +
                ", uName='" + getuName() + "'" +
                ", uNumber='" + getuNumber() + "'" +
                ", eScore='" + geteScore() + "'" +
                ", eCredits='" + geteCredits() + "'" +
                "}";
    }

}
