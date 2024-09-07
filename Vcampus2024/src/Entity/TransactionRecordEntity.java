package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class TransactionRecordEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private int tID;
    private String uNumber;
    private BigDecimal tTransactionAmount;
    private String tType; // enum('DEPOSIT','COMSUMPTION')
    private Date tDate;

    public TransactionRecordEntity() {
    }

    public TransactionRecordEntity(String uNumber, BigDecimal tTransactionAmount, String tType) {
        this.uNumber = uNumber;
        this.tTransactionAmount = tTransactionAmount;
        this.tType = tType;
    }

    public int gettID() {
        return this.tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public String getuNumber() {
        return this.uNumber;
    }

    public void setuNumber(String uNumber) {
        this.uNumber = uNumber;
    }

    public BigDecimal gettTransactionAmount() {
        return this.tTransactionAmount;
    }

    public void settTransactionAmount(BigDecimal tTransactionAmount) {
        this.tTransactionAmount = tTransactionAmount;
    }

    public String gettType() {
        return this.tType;
    }

    public void settType(String tType) {
        this.tType = tType;
    }

    public Date gettDate() {
        return this.tDate;
    }

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }

    @Override
    public String toString() {
        return "{" +
                " tID='" + gettID() + "'" +
                ", uNumber='" + getuNumber() + "'" +
                ", tTransactionAmount='" + gettTransactionAmount() + "'" +
                ", tType='" + gettType() + "'" +
                ", tDate='" + gettDate() + "'" +
                "}";
    }
}
