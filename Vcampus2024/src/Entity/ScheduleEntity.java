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
    private int sTimePeriod;
    private String sClassroom; // A-Z sClassroom: varchar(10)
    private String uNumber; // A-Z uNumber: varchar(10)

    public enum sDayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public enum sTimePeriod {
        PERIOD_1_2("1-2节"),
        PERIOD_3_4("3-4节"),
        PERIOD_5_6("5-6节"),
        PERIOD_7_8("7-8节");

        private final String displayName;

        sTimePeriod(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public ScheduleEntity() {
    }

    public List<String> copyAvailableClassrooms() {
        return List.copyOf(this.availableClassrooms);
    }

    public ScheduleEntity(int sID, String cCourseID, int sDayofWeek, int sTimePeriod, String sClassroom) {
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

    public int getsTimePeriod() {
        return this.sTimePeriod;
    }

    public void setsTimePeriod(int sTimePeriod) {
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