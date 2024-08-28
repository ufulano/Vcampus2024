package Entity;

public class CourseEntity {
    // 列名映射为Java类成员变量，数据类型根据SQL表定义
    private int cCourseID; // 数据类型为int，非空，自增，主键
    private String cCourseName; // 数据类型为varchar(10)，非空
    private int cCredits; // 数据类型为int，默认值为2
    private int cProfession; // 数据类型为int
    private int cGrade; // 数据类型为int，默认值为1
    private int cCapacity; // 数据类型为int，默认值为10
    private int cAvailable; // 数据类型为int，默认值为10
    private Boolean cEnd; // 数据类型为tinyint(1)，通常在Java中映射为boolean，表示是否结束
    private String uName; // 数据类型为varchar(10)
    private String uNumber; // 数据类型为varchar(15)，有索引

    public CourseEntity() {
    }

    public CourseEntity(int cCourseID, String cCourseName, int cCredits, int cProfession, int cGrade, int cCapacity,
            int cAvailable, Boolean cEnd, String uName, String uNumber) {
        this.cCourseID = cCourseID;
        this.cCourseName = cCourseName;
        this.cCredits = cCredits;
        this.cProfession = cProfession;
        this.cGrade = cGrade;
        this.cCapacity = cCapacity;
        this.cAvailable = cAvailable;
        this.cEnd = cEnd;
        this.uName = uName;
        this.uNumber = uNumber;
    }

    public int getcCourseID() {
        return this.cCourseID;
    }

    public String getcCourseName() {
        return this.cCourseName;
    }

    public int getcCredits() {
        return this.cCredits;
    }

    public int getcProfession() {
        return this.cProfession;
    }

    public int getcGrade() {
        return this.cGrade;
    }

    public int getcCapacity() {
        return this.cCapacity;
    }

    public int getcAvailable() {
        return this.cAvailable;
    }

    public Boolean getcEnd() {
        return this.cEnd;
    }

    public String getuName() {
        return this.uName;
    }

    public String getuNumber() {
        return this.uNumber;
    }

    public void setcEnd(Boolean cEnd) {
        this.cEnd = cEnd;
    }

}
