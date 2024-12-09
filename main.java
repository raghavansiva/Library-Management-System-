import java.util.*;
import java.util.HashMap;

public class main {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        register r = new register();
        borrow b = new borrow();
        b.addBook("1001", "Design of Computer Networks");
        b.addBook("1002", "Object Oriented Analysis and Design");
        b.addBook("1003", "Theory of Computation");
        b.addBook("1004", "Mobile Networks");
        b.addBook("1005", "Quality Management");
        b.addBook("1006", "Data Structures using c");
        b.addBook("1007", "Java Programming");
        int n = 0;
        System.out.printf(
                "\n==================================================================================================================================\n");
        System.out.printf(
                "|                                                   LIBRARY MANAGEMENT SYSTEM                                                    |");
        System.out.printf(
                "\n==================================================================================================================================\n");
        r.login();
        while (n == 0) {
            System.out.println("1 -> View Details\n2 -> Borrow Book\n3 -> Return Book\n4 -> Logout\n");
            int x = sc.nextInt();
            switch (x) {
                case 1:
                    r.display();
                    break;
                case 2:
                    b.take();
                    break;
                case 3:
                    b.returnBook();
                    break;
                case 4:
                    n++;
                    r.logout();
                    break;
                default:
                    break;
            }
        }
    }
}

class register {
    Scanner sc = new Scanner(System.in);
    String name;
    int rollNo;
    String department;

    public void login() {
        System.out.printf("\n=========================================================\n");
        System.out.printf("|                       LOGIN                           |");
        System.out.printf("\n=========================================================\n");
        System.out.println("Enter Details");
        System.out.print("Name        : ");
        name = sc.nextLine();
        System.out.printf("Roll No.    : ");
        rollNo = sc.nextInt();
        System.out.printf("Department  : ");
        sc.nextLine();
        department = sc.nextLine();
        System.out.println("\nRegisteration successfull\n");
    }

    public void logout() {
        System.out.printf("\n=========================================================\n");
        System.out.printf("|                      LOGOUT                           |");
        System.out.printf("\n=========================================================\n");
        System.out.println("Enter Roll Number to logout");
        int roll = sc.nextInt();
        while (roll == rollNo) {
            if (roll == rollNo) {
                System.out.println("Logged out");
                roll++;
            } else {
                System.out.println("Entered roll no didnt login");
            }
        }
    }

    public void display() {
        System.out.printf("\n=========================================================\n");
        System.out.printf("|                  STUDENT DETAIL                       |");
        System.out.printf("\n=========================================================\n");
        System.out.println("Name        : " + name);
        System.out.println("Roll no.    : " + rollNo);
        System.out.println("Department  : " + department);
        System.out.println();
    }
}

class borrow {
    Scanner sc = new Scanner(System.in);
    HashMap<String, String> hM = new HashMap<String, String>();
    HashMap<String, String> hM2 = new HashMap<String, String>();
    String bookId;
    String bookName;
    String Author;
    int count = 0;

    public void take() {
        System.out.printf("\n=========================================================\n");
        System.out.printf("|                   BORROW BOOK                         |");
        System.out.printf("\n=========================================================\n");

        if (count < 3) {
            System.out.println("BOOD ID   BOOK NAME");
            hM.forEach((key, value) -> {
                System.out.println(" " + key + "     " + value);
            });
            System.out.printf("\n Enter Book ID : ");
            bookId = sc.nextLine();
            if (hM.containsKey(bookId)) {
                System.out.println("\nSuccessfully borrowed");
                System.out.println("ID : " + bookId);
                System.out.println("NAME : " + hM.get(bookId));
                hM2.put(bookId, hM.get(bookId));
                hM.remove(bookId);
                System.out.println();
                count++;
            } else {
                System.out.println("Currently not available");
                System.out.println("1 -> New book");
                System.out.println("2 -> Exit\n");
                int n = sc.nextInt();
                switch (n) {
                    case 1:
                        take();
                        break;
                    case 2:
                        System.out.println("Exited...\n");
                        break;
                    default:
                        break;
                }
            }
        } else {
            System.out.printf("\nBook limit exceeded \n return existing book to borrow book\n");
            System.out.println("1 -> Return book");
            System.out.println("2 -> Exit\n");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    returnBook();
                    break;
                case 2:
                    System.out.println("Exited...\n");
                    break;
                default:
                    break;
            }
        }
    }

    public void returnBook() {
        System.out.printf("\n=========================================================\n");
        System.out.printf("|                    RETURN BOOK                        |");
        System.out.printf("\n=========================================================\n");
        if (count == 0) {
            System.out.println("No books to be returned");
        } else {
            System.out.println("\nBooks to be returned");
            System.out.println("BOOD ID   BOOK NAME");
            hM2.forEach((key, value) -> {
                System.out.println(" " + key + "     " + value);
            });
            System.out.println("Enter bookId");
            bookId = sc.nextLine();
            hM.put(bookId, hM2.get(bookId));
            System.out.println("\nReturned successfully");
            count--;
        }
        System.out.println("1 -> Borrow book");
        System.out.println("2 -> Return book");
        System.out.println("3 -> Exit\n");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                take();
                break;
            case 2:
                returnBook();
                break;
            case 3:
                System.out.println("Exited...\n");
                break;
            default:
                break;
        }

    }

    public void addBook(String bookId, String bookName) {
        hM.put(bookId, bookName);
    }
}
