package Entity;

import java.io.Serializable;

public class ScheduleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private int sID; // 0bSID: int unsigned
    private String cCourseID; // A-Z sCourseID: varchar(10)
    private int sDayofWeek; // 0-6 sDayofWeek: int
    private int sTimePeriod;
    private String sClassroom; // A-Z sClassroom: varchar(10)

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

    @Override
    public String toString() {
        return "ScheduleEntity{" +
                "sID=" + sID +
                ", cCourseID='" + cCourseID + '\'' +
                ", sDayofWeek=" + sDayofWeek +
                ", sTimePeriod=" + sTimePeriod +
                ", sClassroom='" + sClassroom + '\'' +
                '}';
    }
}