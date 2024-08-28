package Entity;

import java.time.LocalDate;
import java.time.Period;

public class UserEntity {
    private String uID;//一卡通（唯一ID）
    private String uPwd;//登陆密码
    private String uName;//姓名
    private String uNumber;//学号
    private int uAge;//年龄
    private String uGender; // enum('男', '女') 需要根据实际枚举值来定义
    private String uRole; // enum('管理员', ...) 需要根据实际枚举值来定义
    private int uProperty;
    private String uPayPwd;//支付密码
    private int uGrade;//年级
    private int uMajor;//专业
    private java.time.LocalDate uBirthday;//出生日期
    private String uBirthplace;//出生地

    public enum Gender {
        MALE, FEMALE
    }

    public enum Role {
        Manager, Student, Teacher // 假设的枚举值，具体值需要根据实际情况定义
    }

    public UserEntity() {
    }

    public UserEntity(String uID, String uPwd, String uName, String uNumber,
            int uAge, String uGender, String uRole,
            int uProperty, String uPayPwd, int uGrade, int uMajor,
            java.time.LocalDate uBirthday, String uBirthplace) {
        this.uID = uID;
        this.uPwd = uPwd;
        this.uName = uName;
        this.uNumber = uNumber;
        this.uAge = uAge;
        this.uGender = uGender;
        this.uRole = uRole;
        this.uPayPwd = uPayPwd;
        this.uProperty = uProperty;
        this.uGrade = uGrade;
        this.uMajor = uMajor;
        this.uBirthplace = uBirthplace;
        this.uBirthday = uBirthday;
    }

    public String getuID() {
        return this.uID;
    }

    public String setuPwd(String uPwd) {
        return this.uPwd = uPwd;
    }

    public String getuName() {
        return this.uName;
    }

    public String setuName(String uName) {
        return this.uName = uName;
    }

    public String getuNumber() {
        return this.uNumber;
    }

    public int getuAge() {
        return this.uAge;
    }

    public String getuGender() {
        return this.uGender;
    }

    public String getuRole() {
        return this.uRole;
    }

    public int getuProperty() {
        return this.uProperty;
    }

    public String getuPayPwd() {
        return this.uPayPwd;
    }

    public int getuGrade() {
        return this.uGrade;
    }

    public int getuMajor() {
        return this.uMajor;
    }

    public java.time.LocalDate getuBirthday() {
        return this.uBirthday;
    }

    public String getuBirthplace() {
        return this.uBirthplace;
    }

    public void setuAge() {
        this.uAge = Period.between(this.uBirthday, LocalDate.now()).getYears();
    }
}