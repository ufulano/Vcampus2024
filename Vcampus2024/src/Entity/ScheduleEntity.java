package Entity;

import java.io.Serializable;

import java.util.List;
import java.util.Arrays;

public class ScheduleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<String> availableClassrooms = Arrays.asList("A101", "A102", "A103", "A104", "A105", "A106", "A107",
            "A108", "A109", "B101", "B102", "B103", "B104", "B105", "B106", "B107", "B108", "B109", "C101", "C102",
            "C103", "C104", "C105", "C106", "C107", "C108", "C109", "D101", "D102", "D103", "D104", "D105", "D106",
            "D107", "D108", "D109");

    private int sID; // 0bSID: int unsigned
    private String cCourseID; // A-Z sCourseID: varchar(10)
    private int sDayofWeek; // 0-6 sDayofWeek: int
    private TimePeriod sTimePeriod;
    private String sClassroom; // A-Z sClassroom: varchar(10)
    private String uNumber; // A-Z uNumber: varchar(10)

    public enum sDayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public enum TimePeriod {
        PERIOD_1_2("1-2",0),
        PERIOD_3_4("3-4",1),
        PERIOD_5_6("5-6",2),
        PERIOD_7_8("7-8",3),
        DEFAULT("",-1);

        private String displayName;
        private int Value;
        
        TimePeriod(String displayName,int Value) {
            this.displayName = displayName;
        }

        TimePeriod ValueOf(String value) {
            if(value.equals("1-2"))return PERIOD_1_2;
            if(value.equals("3-4"))return PERIOD_3_4;
            if(value.equals("5-6"))return PERIOD_5_6;
            if(value.equals("7-8"))return PERIOD_7_8;
            return DEFAULT;
        }
        TimePeriod ValueOf(int value) {
            if(value==0)return PERIOD_1_2;
            if(value==1)return PERIOD_3_4;
            if(value==2)return PERIOD_5_6;
            if(value==3)return PERIOD_7_8;
            return DEFAULT;
        }        

        public String getDisplayName() {
            return displayName;
        }

        public int getValue() {
            return Value;
        }        
    }

    public ScheduleEntity() {
    }

    public List<String> copyAvailableClassrooms() {
        return List.copyOf(this.availableClassrooms);
    }

    public ScheduleEntity(int sID, String cCourseID, int sDayofWeek, TimePeriod sTimePeriod, String sClassroom) {
        this.sID = sID;
        this.cCourseID = cCourseID;
        this.sDayofWeek = sDayofWeek;
        this.sTimePeriod = sTimePeriod;
        this.sClassroom = sClassroom;
    }

    public int getsID() {
        return this.sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getcCourseID() {
        return this.cCourseID;
    }

    public void setcCourseID(String cCourseID) {
        this.cCourseID = cCourseID;
    }

    public int getsDayofWeek() {
        return this.sDayofWeek;
    }

    public void setsDayofWeek(int sDayofWeek) {
        this.sDayofWeek = sDayofWeek;
    }

    public TimePeriod getsTimePeriod() {
        return this.sTimePeriod;
    }

    public void setsTimePeriod(TimePeriod sTimePeriod) {
        this.sTimePeriod = sTimePeriod;
    }

    public String getsClassroom() {
        return this.sClassroom;
    }

    public void setsClassroom(String sClassroom) {
        this.sClassroom = sClassroom;
    }

    public String getuNumber() {
        return this.uNumber;
    }

    public void setuNumber(String uNumber) {
        this.uNumber = uNumber;
    }
    public String dispalyWeek() {
        switch (sDayofWeek) {
            case 0:
                return "周一";
            case 1:
                return "周二";
            case 2:
                return "周三";
            case 3:
                return "周四";
            case 4:
                return "周五";
            case 5:
                return "周六";
            case 6:
                return "周日";
            default:
                return "无效的日期"; // 处理无效的日期值
        }
    }
    

    @Override
    public String toString() {
        return "ScheduleEntity{" +
                "sID=" + sID +
                ", cCourseID='" + cCourseID + '\'' +
                ", sDayofWeek=" + sDayofWeek +
                ", sTimePeriod=" + sTimePeriod +
                ", sClassroom='" + sClassroom + '\'' +
                ", uNumber='" + uNumber + '\'' +
                '}';
    }
}