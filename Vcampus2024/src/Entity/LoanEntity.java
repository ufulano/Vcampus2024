package Entity;

import java.util.Date;

import java.io.Serializable;

public class LoanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    // 列名映射为Java类成员变量，数据类型根据SQL表定义
    private int lLoadID; // 数据类型为int，自增，主键
    private int lCopyID; // 数据类型为int，默认值为1
    private String uNumber; // 数据类型为varchar(15)
    private int bBookID; // 数据类型为int unsigned
    private Date lLoanDate; // 数据类型为date
    private Date lReturnDate; // 数据类型为date
    private Date lDueDate; // 数据类型为date

    public LoanEntity() {
    }

    public LoanEntity(int lLoadID, int lCopyID, String uNumber, int bBookID, Date lLoanDate, Date lReturnDate,
            Date lDueDate) {
        this.lLoadID = lLoadID;
        this.lCopyID = lCopyID;
        this.uNumber = uNumber;
        this.bBookID = bBookID;
        this.lLoanDate = lLoanDate;
        this.lReturnDate = lReturnDate;
        this.lDueDate = lDueDate;
    }

    public int getlLoadID() {
        return this.lLoadID;
    }

    public void setlLoadID(int lLoadID) {
        this.lLoadID = lLoadID;
    }

    public int getlCopyID() {
        return this.lCopyID;
    }

    public void setlCopyID(int lCopyID) {
        this.lCopyID = lCopyID;
    }

    public String getuNumber() {
        return this.uNumber;
    }

    public void setuNumber(String uNumber) {
        this.uNumber = uNumber;
    }

    public int getbBookID() {
        return this.bBookID;
    }

    public void setbBookID(int bBookID) {
        this.bBookID = bBookID;
    }

    public Date getlLoanDate() {
        return this.lLoanDate;
    }

    public void setlLoanDate(Date lLoanDate) {
        this.lLoanDate = lLoanDate;
    }

    public Date getlReturnDate() {
        return this.lReturnDate;
    }

    public void setlReturnDate(Date lReturnDate) {
        this.lReturnDate = lReturnDate;
    }

    public Date getlDueDate() {
        return this.lDueDate;
    }

    public void setlDueDate(Date lDueDate) {
        this.lDueDate = lDueDate;
    }

    @Override
    public String toString() {
        return "LoanEntity{" +
                "lLoadID=" + lLoadID +
                ", lCopyID=" + lCopyID +
                ", uNumber='" + uNumber + '\'' +
                ", bBookID=" + bBookID +
                ", lLoanDate=" + lLoanDate +
                ", lReturnDate=" + lReturnDate +
                ", lDueDate=" + lDueDate +
                '}';
    }
}