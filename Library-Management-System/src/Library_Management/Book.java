package Library_Management;

public class Book {

   private int id;
   private String title;
   private String author;
   private boolean isIssued;
   private  int prise;

   public void setId(int id1){
       this.id=id1;
   }
    public void setTitle(String  title1){
        this.title=title1;
    }
    public void setAuthor(String  author1){
        this.author=author1;
    }
    public void setIssued(boolean  isIssued1){
        this.isIssued=isIssued1;
    }
    public void setPrise(int prise1){
        this.prise=prise1;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean getIsIssued() {
        return isIssued;
    }
    public int getPrise() {
        return prise;
    }

    @Override
    public String toString() {
        return "Book id: "+getId()+
                ", Book Title: "+getTitle()+
                ", Book Author: "+getAuthor()+
                ", Issued: "+getIsIssued()+
                ", Price: "+getPrise();
    }
}
