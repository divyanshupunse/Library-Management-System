package Library_Management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import  java.util.Scanner;

public class BookDataBaseAccess {
    Scanner sc=new Scanner(System.in);

    public void addBook(){
        System.out.println("Enter Book Title: ");
        String title=sc.nextLine();
        System.out.println("Enter Book Author name: ");
        String author=sc.nextLine();
        boolean isIssued=false;
        System.out.println("Enter price of book: ");
        int price=sc.nextInt();

        try (Connection connection=DBConnection.getConnection();
            PreparedStatement pps=connection.prepareStatement("insert into books(title,author,isIssued,price) values (?,?,?,?)")){

            pps.setString(1,title);
            pps.setString(2,author);
            pps.setBoolean(3,isIssued);
            pps.setInt(4,price);

            int isAdd= pps.executeUpdate();
            if (isAdd>0){
                System.out.println("Book Added successfully");
            }


        }catch (SQLException e){
            System.out.println("error in adding book: "+e.getMessage());
        }
    }
    public  List<Book> viewBooks(){
        List<Book> list=new ArrayList<>();
        try (Connection co=DBConnection.getConnection();
             Statement statement=co.createStatement();
             ResultSet re=statement.executeQuery("select * from books")){

            while (re.next()){
                Book book1=new Book();
                book1.setId(re.getInt("id"));
                book1.setTitle(re.getString("title"));
                book1.setAuthor(re.getString("author"));
                book1.setIssued(re.getBoolean("isIssued"));
                book1.setPrise(re.getInt("price"));
                list.add(book1);

            }
        } catch (SQLException e) {
            System.out.println("error in view book: "+e.getMessage());
        }
        return list;
    }
    public void updateBook(){
        System.out.println("Enter Book Id: ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter updated price: ");
        int price1=sc.nextInt();

        try (Connection connection=DBConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("update books set price=? where id=?")){
            ps.setInt(1,price1);
            ps.setInt(2,id);

            int rowUpdate=ps.executeUpdate();
            if (rowUpdate>0){
                System.out.println("Book updated successfully");
            }else {
                System.out.println("Book not found with Id: "+id);
            }

        }catch (SQLException e){
            System.out.println("Error in update book: "+e.getMessage());
        }
    }
    public void deleteBook() {
        System.out.println("Enter id to delete book");
        int id = sc.nextInt();
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from books where id=?")){
            ps.setInt(1, id);

            int rowDelete = ps.executeUpdate();
            if (rowDelete > 0) {
                System.out.println("Book deleted successfully");
            } else {
                System.out.println("Book not found with id: " + id);
            }

        } catch (SQLException e) {
            System.out.println("error in delete book: " + e.getMessage());
        }
    }
}
