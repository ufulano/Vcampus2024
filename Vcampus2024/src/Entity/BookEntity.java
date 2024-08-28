package Entity;

public class BookEntity {
    private int bBookId; // 0bBookID: int unsigned
    private String bBookName; // A-Z bBookName: varchar(255)
    private String bAuthor; // A-Z bAuthor: varchar(255)
    private String bPublisher; // A-Z bPublisher: varchar(255)
    private String bISBN; // A-Z bISBN: varchar(20)
    private int bTotal; // 0-9 bTotal: int，默认值为0
    private int bAvailable; // 0-9 bAvailable: int，默认值为0
    private String img_url; // A-z img_url: varchar(200)

    public BookEntity() {
    }

    public BookEntity(int bBookId, String bBookName, String bAuthor, String bPublisher, String bISBN, int bTotal,
            int bAvailable, String img_url) {
        this.bBookId = bBookId;
        this.bBookName = bBookName;
        this.bAuthor = bAuthor;
        this.bPublisher = bPublisher;
        this.bISBN = bISBN;
        this.bTotal = bTotal;
        this.bAvailable = bAvailable;
        this.img_url = img_url;
    }

    public int getbBookId() {
        return this.bBookId;
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

    public String getImg_url() {
        return this.img_url;
    }

    public void setbBookId(int bBookId) {
        this.bBookId = bBookId;
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

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
