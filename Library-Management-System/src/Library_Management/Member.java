package Library_Management;

public class Member {
    private  int mId;
    private String mName;
    private String mEmail;
    private long phoneNo;

    public void setmId(int id){
        this.mId=id;
    }
    public void setmName(String name){
        this.mName=name;
    }
    public void setmEmail(String email){
        this.mEmail=email;
    }
    public void setPhoneNo(long phoneNo1){
        this.phoneNo=phoneNo1;
    }

    public int getmId(){
        return mId;
    }
    public String getmName(){
        return mName;
    }
    public String getmEmail(){
        return mEmail;
    }
    public long getPhoneNo(){
        return phoneNo;
    }
    @Override
    public String toString(){
        return "Member Id: "+mId+
                ", Member Name: "+mName+
                ", Member email: "+mEmail+
                ", Member Phone No: "+phoneNo;
    }
}
