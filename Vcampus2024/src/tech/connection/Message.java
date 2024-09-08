package tech.connection;

import java.io.Serializable;
// import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Entity.*;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private String data[];
    private UserEntity userentity;
    private BookEntity bookentity;
    private LoanEntity loanentity;
    private CourseEntity courseentity;
    private EnrollmentEntity enrollmententity;
    private OrderEntity orderentity;
    private ProductEntity productentity;
    private ShoppingcartEntity shoppingcartentity;
    private AccountEntity accountentity;
    private TransactionRecordEntity transactionentity;
    private ScheduleEntity scheduleentity;

    private List<EnrollmentEntity> enrollmentlist;
    private List<ScheduleEntity> schedulelist = new ArrayList<>();
    private List<UserEntity> userlist = new ArrayList<>();
    private List<CourseEntity> courselist = new ArrayList<>();
    private List<ShoppingcartEntity> shoppingcartlist = new ArrayList<>();
    private List<OrderEntity> orderlist = new ArrayList<>();
    private List<ProductEntity> productlist = new ArrayList<>();
    private List<BookEntity> booklist = new ArrayList<>();
    private List<LoanEntity> loanlist = new ArrayList<>();

    private List<TransactionRecordEntity> transactionlist = new ArrayList<>();

    // private String Filepath;
    private MessageType Type;

    public enum MessageType {
        ERROR, USER, STU, COURSE, LIBRARY, SHOP, BANK;
    }

    public Message() {
        Type = MessageType.ERROR;
        data = null;
    }

    public Message(MessageType t) {
        Type = t;
        data = null;
    }

    public Message(MessageType t, String... d) {
        Type = t;
        data = d;
    }

    public void setdata(String... d) {
        data = d;
    }

    public String[] getdata() {
        return data;
    }

    public void setuserentity(UserEntity u) {
        userentity = u;
    }

    public UserEntity getuserentity() {
        return userentity;
    }

    public void setorderentity(OrderEntity o) {
        orderentity = o;
    }

    public OrderEntity getorderentity() {
        return orderentity;
    }

    public void setuserlist(List<UserEntity> u) {
        userlist = u;
    }

    public List<UserEntity> getuserlist() {
        return userlist;
    }

    public void setproductlist(List<ProductEntity> u) {
        productlist = u;
    }

    public List<ProductEntity> getproductlist() {
        return productlist;
    }

    public void setorderlist(List<OrderEntity> o) {
        orderlist = o;
    }

    public List<OrderEntity> getorderlist() {
        return orderlist;
    }

    public MessageType gettype() {
        return Type;
    }

    public void settype(MessageType t) {
        Type = t;
    }

    public String toString() {
        if (Type == MessageType.ERROR)
            return "ERROR";
        if (data == null)
            return "";
        String str = "\n" + Type + "\n";
        for (int i = 0; i < data.length; i++) {
            str += "data[" + i + "]: " + data[i] + "\n";
        }
        return str;
    }

    public void setbookentity(BookEntity b) {
        bookentity = b;
    }

    public BookEntity getbookentity() {
        return bookentity;
    }

    public List<CourseEntity> getcourselist() {
        return courselist;
    }

    public void setcourselist(List<CourseEntity> c) {
        courselist = c;
    }

    public List<BookEntity> getbooklist() {
        return booklist;
    }

    public void setbooklist(List<BookEntity> b) {
        booklist = b;
    }

    public void setloanentity(LoanEntity b) {
        loanentity = b;
    }

    public LoanEntity getloanentity() {
        return loanentity;
    }

    public List<LoanEntity> getloanlist() {
        return loanlist;
    }

    public void setloanlist(List<LoanEntity> b) {
        loanlist = b;
    }

    public ProductEntity getproductentity() {
        return productentity;
    }

    public void setproductentity(ProductEntity p) {
        productentity = p;
    }

    public void setshoppingcartentity(ShoppingcartEntity s) {
        shoppingcartentity = s;
    }

    public ShoppingcartEntity getshoppingcartentity() {
        return shoppingcartentity;
    }

    public void setshoppingcartlist(List<ShoppingcartEntity> s) {
        shoppingcartlist = s;
    }

    public List<ShoppingcartEntity> getshoppingcartlist() {
        return shoppingcartlist;
    }

    public CourseEntity getcourseentity() {
        return courseentity;
    }

    public void setcourseentity(CourseEntity courseentity) {
        this.courseentity = courseentity;
    }

    public AccountEntity getaccountentity() {
        return accountentity;
    }

    public void setaccountentity(AccountEntity accountentity) {
        this.accountentity = accountentity;
    }

    public TransactionRecordEntity gettransactionentity() {
        return transactionentity;
    }

    public void settransactionentity(TransactionRecordEntity transactionentity) {
        this.transactionentity = transactionentity;
    }

    public List<TransactionRecordEntity> gettransactionlist() {
        return transactionlist;
    }

    public void settransactionlist(List<TransactionRecordEntity> transactionlist) {
        this.transactionlist = transactionlist;
    }

    public EnrollmentEntity getenrollmententity() {
        return enrollmententity;
    }

    public void setenrollmententity(EnrollmentEntity enrollment) {
        this.enrollmententity = enrollment;
    }

    public ScheduleEntity getscheduleentity() {
        return scheduleentity;
    }

    public void setscheduleentity(ScheduleEntity scheduleentity) {
        this.scheduleentity = scheduleentity;
    }

    public List<ScheduleEntity> getschedulelist() {
        return schedulelist;
    }

    public void setschedulelist(List<ScheduleEntity> schedulelist) {
        this.schedulelist = schedulelist;
    }

    public List<EnrollmentEntity> getenrollmentlist() {
        return enrollmentlist;
    }

    public void setenrollmentlist(List<EnrollmentEntity> e) {
        this.enrollmentlist = e;
    }    

}
