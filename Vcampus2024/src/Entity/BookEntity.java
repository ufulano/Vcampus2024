package Entity;

import java.io.Serializable;

public class BookEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private int bBookID; // 0bBookID: int unsigned
    private String bBookName; // A-Z bBookName: varchar(255)
    private String bAuthor; // A-Z bAuthor: varchar(255)
    private String bPublisher; // A-Z bPublisher: varchar(255)
    private String bISBN; // A-Z bISBN: varchar(20)
    private int bTotal; // 0-9 bTotal: int，默认值为0
    private int bAvailable; // 0-9 bAvailable: int，默认值为0
    private String bImg_url; // A-z bImg_url: varchar(200)

    public BookEntity() {
    }

    public BookEntity(int bBookID, String bBookName, String bAuthor, String bPublisher, String bISBN, int bTotal,
            int bAvailable, String bImg_url) {
        this.bBookID = bBookID;
        this.bBookName = bBookName;
        this.bAuthor = bAuthor;
        this.bPublisher = bPublisher;
        this.bISBN = bISBN;
        this.bTotal = bTotal;
        this.bAvailable = bAvailable;
        this.bImg_url = bImg_url;
    }

    public int getbBookID() {
        return this.bBookID;
    }

    public String getbBookName() {
        return this.bBookName;
    }

    public String getbAuthor() {
        return this.bAuthor;
    }

    public String getbPublisher() {
        return this.bPublisher;
    }

    public String getbISBN() {
        return this.bISBN;
    }

    public int getbTotal() {
        return this.bTotal;
    }

    public int getbAvailable() {
        return this.bAvailable;
    }

    public String getbImg_url() {
        return this.bImg_url;
    }

    public void setbBookID(int bBookID) {
        this.bBookID = bBookID;
    }

    public void setbBookName(String bBookName) {
        this.bBookName = bBookName;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public void setbPublisher(String bPublisher) {
        this.bPublisher = bPublisher;
    }

    public void setbISBN(String bISBN) {
        this.bISBN = bISBN;
    }

    public void setbTotal(int bTotal) {
        this.bTotal = bTotal;
    }

    public void setbAvailable(int bAvailable) {
        this.bAvailable = bAvailable;
    }

    public void setbImg_url(String bImg_url) {
        this.bImg_url = bImg_url;
    }

    @Override
    public String toString() {
        return "BookEntity{" + "bBookID=" + bBookID + ", bBookName='" + bBookName + '\'' + ", bAuthor='" + bAuthor
                + '\'' + ", bPublisher='" + bPublisher + '\'' + ", bISBN='" + bISBN + '\'' + ", bTotal=" + bTotal
                + ", bAvailable=" + bAvailable + ", bImg_url='" + bImg_url + '\'' + '}';
    }
}
