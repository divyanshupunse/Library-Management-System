package Library_Management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberDataBaseAccess {
    Scanner sc=new Scanner(System.in);

    public void addMember(){
        System.out.println("Enter Name: ");
        String mName=sc.nextLine();
        System.out.println("Enter email: ");
        String email=sc.nextLine();
        System.out.println("Enter Phone No: ");
        long phoneNo=sc.nextLong();

        try (Connection connection=DBConnection.getConnection();
             PreparedStatement pps=connection.prepareStatement("insert into members(mName,email,phoneNo) values (?,?,?)")){
             pps.setString(1,mName);
             pps.setString(2,email);
             pps.setLong(3,phoneNo);

             int isAdd=pps.executeUpdate();
             if (isAdd>0){
                 System.out.println("Member added successfully");
             }

        }catch (SQLException e){
            System.out.println("error in adding member: "+e.getMessage());
        }
    }

    public List<Member> viewMembers(){
        List<Member> list=new ArrayList<>();
        try (Connection cs=DBConnection.getConnection();
            Statement st= cs.createStatement();
            ResultSet rs= st.executeQuery("select * from members")){

            while (rs.next()){
                Member member=new Member();

                member.setmId(rs.getInt("mId"));
                member.setmName(rs.getString("mName"));
                member.setmEmail(rs.getString("email"));
                member.setPhoneNo(rs.getLong("phoneNo"));
                list.add(member);
            }

        }catch (SQLException e){
            System.out.println("error in viewing members: "+e.getMessage());
        }
        return list;
    }
    public void updateMember(){
        System.out.println("Enter Member id to update: ");
        int mId= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new email: ");
        String email=sc.nextLine();
        System.out.println("Enter Phone No: ");
        long phoneNo=sc.nextLong();

        try (Connection connection=DBConnection.getConnection();
             PreparedStatement pps=connection.prepareStatement("update members set email=?,phoneNo=? where mid=?")){
            pps.setString(1,email);
            pps.setLong(2,phoneNo);
            pps.setInt(3,mId);

            int isUpdate=pps.executeUpdate();
            if (isUpdate>0){
                System.out.println("Member updated successfully");
            }else System.out.println("Member not found");

        }catch (SQLException e){
            System.out.println("error in update :"+e.getMessage());
        }
    }
    public void deleteMember(){
        System.out.println("Enter Member id to delete: ");
        int mId= sc.nextInt();


        try (Connection connection=DBConnection.getConnection();
             PreparedStatement pps=connection.prepareStatement("delete from members where mid=?")){
            pps.setInt(1,mId);

            int isDelete=pps.executeUpdate();
            if (isDelete>0){
                System.out.println("Member deleted successfully");
            }else System.out.println("Member not found");

        }catch (SQLException e){
            System.out.println("error in delete :"+e.getMessage());
        }
    }

}
