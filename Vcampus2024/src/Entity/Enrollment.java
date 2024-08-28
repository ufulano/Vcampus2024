package Entity;

import java.math.BigDecimal;

public class Enrollment {
    // 列名映射为Java类成员变量，数据类型根据SQL表定义
    private int cCourseID; // 数据类型为int
    private String uName; // 数据类型为varchar(10)
    private String uNumber; // 数据类型为varchar(15)，非空，主键之一
    private BigDecimal eScore; // 数据类型为decimal(4,2)，默认值为0.00
    private BigDecimal eCredits; // 数据类型为decimal(4,2)，默认值为0.00

    public Enrollment() {
    }

    public Enrollment(int cCourseID, String uName, String uNumber, BigDecimal eScore, BigDecimal eCredits) {
        this.cCourseID = cCourseID;
        this.uName = uName;
        this.uNumber = uNumber;
        this.eScore = eScore;
        this.eCredits = eCredits;
    }

    public int getcCourseID() {
        return this.cCourseID;
    }

    public String getuName() {
        return this.uName;
    }

    public String getuNumber() {
        return this.uNumber;
    }

    public BigDecimal geteScore() {
        return this.eScore;
    }

    public BigDecimal geteCredits() {
        return this.eCredits;
    }

}
