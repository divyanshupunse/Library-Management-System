package Library_Management;

public class BookIssueRecord {
    private int issueId;
    private int bookId;
    private int memberId;
    private String issueDate;
    private String returnDate;


    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getIssueId() {
        return issueId;
    }
    public int getBookId(){
        return bookId;
    }
    public int getMemberId() {
        return memberId;
    }

    public String getIssueDate() {
        return issueDate;
    }
    public String getReturnDate(){
        return returnDate;
    }

    @Override
    public String toString(){
        return "Issue Id: "+issueId+
                ", Book Id: "+bookId+
                ", Member Id: "+memberId+
                ", Issue Date: "+issueDate+
                ", Return Date: "+returnDate;
    }
}
