package Library_Management;

import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BookDataBaseAccess bd=new BookDataBaseAccess();
        MemberDataBaseAccess mb=new MemberDataBaseAccess();
        IssueDataBaseAccess idb=new IssueDataBaseAccess();
        int choice;


        do {
            System.out.println("\n===== Library Management Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Add Member");
            System.out.println("6. View Members");
            System.out.println("7. Update Member");
            System.out.println("8. Delete Member");
            System.out.println("9. Issue Book");
            System.out.println("10. Return Book");
            System.out.println("11. View Issued Books");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
             choice=sc.nextInt();

            switch (choice){
                case 1:
                    bd.addBook();
                    break;
                case 2:
                    for (Book b : bd.viewBooks()) {
                        System.out.println(b);
                    }
                    break;
                case 3:
                    bd.updateBook();
                    break;
                case 4:
                    bd.deleteBook();
                    break;
                case 5:
                    mb.addMember();
                    break;
                case 6:
                    for (Member m: mb.viewMembers()){
                        System.out.println(m);
                    }
                    break;
                case 7:
                    mb.updateMember();
                    break;
                case 8:
                    mb.deleteMember();
                    break;
                case 9:
                    idb.issueBook();
                    break;
                case 10:
                    idb.returnBook();
                    break;
                case 11:
                   for (BookIssueRecord i:idb.viewIssuedBooks()){
                       System.out.println(i);
                   }
                    break;
                case 12:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("You entered wrong choice");
            }

        }while (choice!=12);
        sc.close();
    }
}
