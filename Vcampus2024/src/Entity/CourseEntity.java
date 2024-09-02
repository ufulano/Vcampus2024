package Entity;

import java.io.Serializable;

public class CourseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    // 列名映射为Java类成员变量，数据类型根据SQL表定义
    private String cCourseID; // 数据类型为int，非空，自增，主键
    private int cYear; // 数据类型为int，默认值为24
    private String cCourseName; // 数据类型为varchar(10)，非空
    private int cCredits; // 数据类型为int，默认值为2
    private int uMajor; // 数据类型为int
    private int cGrade; // 数据类型为int，默认值为1
    private int cCapacity; // 数据类型为int，默认值为10
    private int cAvailable; // 数据类型为int，默认值为10
    private Boolean cEnd; // 数据类型为tinyint(1)，通常在Java中映射为boolean，表示是否结束
    private String uName; // 数据类型为varchar(10)
    private String uNumber; // 数据类型为varchar(15)，有索引

    public CourseEntity() {
    }

    public CourseEntity(String cCourseID, int cYear, String cCourseName, int cCredits, int uMajor, int cGrade,
            int cCapacity,
            int cAvailable, Boolean cEnd, String uName, String uNumber) {
        this.cCourseID = cCourseID;
        this.cYear = cYear;
        this.cCourseName = cCourseName;
        this.cCredits = cCredits;
        this.uMajor = uMajor;
        this.cGrade = cGrade;
        this.cCapacity = cCapacity;
        this.cAvailable = cAvailable;
        this.cEnd = cEnd;
        this.uName = uName;
        this.uNumber = uNumber;
    }

    public String getcCourseID() {
        return this.cCourseID;
    }

    public void setcCourseID(String cCourseID) {
        this.cCourseID = cCourseID;
    }

    public int getcYear() {
        return this.cYear;
    }

    public void setcYear(int cYear) {
        this.cYear = cYear;
    }

    public String getcCourseName() {
        return this.cCourseName;
    }

    public void setcCourseName(String cCourseName) {
        this.cCourseName = cCourseName;
    }

    public int getcCredits() {
        return this.cCredits;
    }

    public void setcCredits(int cCredits) {
        this.cCredits = cCredits;
    }

    public int getuMajor() {
        return this.uMajor;
    }

    public void setuMajor(int uMajor) {
        this.uMajor = uMajor;
    }

    public int getcGrade() {
        return this.cGrade;
    }

    public void setcGrade(int cGrade) {
        this.cGrade = cGrade;
    }

    public int getcCapacity() {
        return this.cCapacity;
    }

    public void setcCapacity(int cCapacity) {
        this.cCapacity = cCapacity;
    }

    public int getcAvailable() {
        return this.cAvailable;
    }

    public void setcAvailable(int cAvailable) {
        this.cAvailable = cAvailable;
    }

    public Boolean getcEnd() {
        return this.cEnd;
    }

    public void setcEnd(Boolean cEnd) {
        this.cEnd = cEnd;
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

    @Override
    public String toString() {
        return "CourseEntity{" +
                "cCourseID='" + cCourseID + '\'' +
                ", cYear=" + cYear +
                ", cCourseName='" + cCourseName + '\'' +
                ", cCredits=" + cCredits +
                ", uMajor='" + uMajor + '\'' +
                ", cGrade=" + cGrade +
                ", cCapacity=" + cCapacity +
                ", cAvailable=" + cAvailable +
                ", cEnd=" + cEnd +
                ", uName='" + uName + '\'' +
                ", uNumber='" + uNumber + '\'' +
                '}';
    }
}
