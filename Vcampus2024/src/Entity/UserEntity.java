package Entity;

import java.time.LocalDate;
import java.time.Period;
import java.io.Serializable;
import java.sql.Date;

public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public enum uGender {
        MALE, FEMALE
    }

    public enum uRole {
        Manager, Student, Teacher
    }

    private String uID;
    private String uPwd;
    private String uName;
    private String uNumber;
    private int uAge;
    private String uGender; // enum('男', '女') 需要根据实际枚举值来定义
    private String uRole; // enum('管理员', ...) 需要根据实际枚举值来定义
    private int uGrade;
    private int uMajor;
    private Date uBirthday;
    private String uBirthplace;

    public UserEntity() {
    }

    public UserEntity(String uID, String uPwd, String uName, String uNumber,
            String uGender, String uRole,
            int uMajor, int uGrade, Date uBirthday, String uBirthplace) {
        this.uID = uID;
        this.uPwd = uPwd;
        this.uName = uName;
        this.uNumber = uNumber;
        this.uGender = uGender;
        this.uRole = uRole;
        this.uGrade = uGrade;
        this.uMajor = uMajor;
        this.uBirthplace = uBirthplace;
        this.uBirthday = uBirthday;
        updateAge();
        
    }

    public void updateAge() {
        LocalDate birthDate = this.uBirthday.toLocalDate();
        setuAge(Period.between(birthDate, LocalDate.now()).getYears());
    }

    public String getuID() {
        return this.uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getuPwd() {
        return this.uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
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

    public int getuAge() {
        return this.uAge;
    }

    public void setuAge(int uAge) {
        this.uAge = uAge;
    }

    public String getuGender() {
        return this.uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender;
    }

    public String getuRole() {
        return this.uRole;
    }

    public void setuRole(String uRole) {
        this.uRole = uRole;
    }

    public int getuGrade() {
        return this.uGrade;
    }

    public void setuGrade(int uGrade) {
        this.uGrade = uGrade;
    }

    public int getuMajor() {
        return this.uMajor;
    }

    public void setuMajor(int uMajor) {
        this.uMajor = uMajor;
    }

    public Date getuBirthday() {
        return this.uBirthday;
    }

    public void setuBirthday(Date uBirthday) {
        this.uBirthday = uBirthday;
    }

    public String getuBirthplace() {
        return this.uBirthplace;
    }

    public void setuBirthplace(String uBirthplace) {
        this.uBirthplace = uBirthplace;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uID='" + uID + '\'' +
                ", uPwd='" + uPwd + '\'' +
                ", uName='" + uName + '\'' +
                ", uNumber='" + uNumber + '\'' +
                ", uAge=" + uAge +
                ", uGender='" + uGender + '\'' +
                ", uRole='" + uRole + '\'' +
                ", uGrade=" + uGrade +
                ", uMajor=" + uMajor +
                ", uBirthday=" + uBirthday +
                ", uBirthplace='" + uBirthplace + '\'' +
                '}';
    }
}