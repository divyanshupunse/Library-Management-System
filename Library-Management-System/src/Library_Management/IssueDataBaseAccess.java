package Library_Management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IssueDataBaseAccess {
    Scanner sc=new Scanner(System.in);

    public void issueBook(){
        System.out.println("Enter book id: ");
        int bookId=sc.nextInt();
        System.out.println("Enter member id: ");
        int memberId=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter issue date (yyyy-mm-dd)");
        String issueDate=sc.nextLine();
        System.out.println("Enter Return date (yyyy-mm-dd)");
        String returnDate=sc.nextLine();

        try (Connection connection=DBConnection.getConnection();
            PreparedStatement pps=connection.prepareStatement("insert into issued_book (bookId,memberId,issueDate,returnDate) values (?,?,?,?)")){
            pps.setInt(1,bookId);
            pps.setInt(2,memberId);
            pps.setString(3,issueDate);
            pps.setString(4,returnDate);
            int isIssued=pps.executeUpdate();
            if (isIssued>0){
                System.out.println("book issued successfully");
            }else System.out.println("failed to issue book");

        }catch (SQLException e){
            System.out.println("error in Issue Book: "+e.getMessage());
        }
    }
    public void returnBook(){
        System.out.println("Enter issue id to return: ");
        int id=sc.nextInt();
        try (Connection connection=DBConnection.getConnection();
             PreparedStatement pps=connection.prepareStatement("delete from issued_book where issueId = ?")){
            pps.setInt(1, id);
            int isReturn=pps.executeUpdate();
            if (isReturn>0){
                System.out.println("book Returned successfully");
            }else System.out.println("failed to Return book");

        }catch (SQLException e){
            System.out.println("error in Issue Book: "+e.getMessage());
        }
    }
    public List<BookIssueRecord> viewIssuedBooks(){
        List<BookIssueRecord> list=new ArrayList<>();
        try (Connection cs=DBConnection.getConnection();
             Statement st= cs.createStatement();
             ResultSet rs= st.executeQuery("select * from issued_book")){

            while (rs.next()){
                BookIssueRecord br=new BookIssueRecord();

                br.setIssueId(rs.getInt("issueId"));
                br.setBookId(rs.getInt("bookId"));
                br.setMemberId(rs.getInt("memberId"));
                br.setIssueDate(rs.getString("issueDate"));
                br.setReturnDate(rs.getString("returnDate"));
                list.add(br);
            }

        }catch (SQLException e){
            System.out.println("error in viewing Issue Book: "+e.getMessage());
        }
        return list;
    }

}
