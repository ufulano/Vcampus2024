package Entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String uNumber;
    private BigDecimal aProperty;
    private String aPayPwd;

    public AccountEntity() {
    }

    public AccountEntity(String uNumber, BigDecimal aProperty, String aPayPwd) {
        this.uNumber = uNumber;
        this.aProperty = aProperty;
        this.aPayPwd = aPayPwd;
    }

    public String getuNumber() {
        return this.uNumber;
    }

    public void setuNumber(String uNumber) {
        this.uNumber = uNumber;
    }

    public BigDecimal getaProperty() {
        return this.aProperty;
    }

    public void setaProperty(BigDecimal aProperty) {
        this.aProperty = aProperty;
    }

    public String getaPayPwd() {
        return this.aPayPwd;
    }

    public void setaPayPwd(String aPayPwd) {
        this.aPayPwd = aPayPwd;
    }

    @Override
    public String toString() {
        return "{" +
                " uNumber='" + getuNumber() + "'" +
                ", aProperty='" + getaProperty() + "'" +
                ", aPayPwd='" + getaPayPwd() + "'" +
                "}";
    }
}
