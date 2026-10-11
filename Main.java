
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice = 0;

        while (choice != 7) {
            System.out.println("\n================================");
            System.out.println("    LIBRARY MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = readPositiveId(sc);

                    if (id == -1) {
                        System.out.println("Invalid Book ID!");
                        break;
                    }

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine().trim();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine().trim();

                    System.out.print("Enter Quantity: ");
                    int quantity;

                    try {
                        quantity = Integer.parseInt(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity!");
                        break;
                    }

                    if (title.isEmpty() || author.isEmpty()) {
                        System.out.println("Title and author cannot be empty.");
                        break;
                    }

                    library.addBook(id, title, author, quantity);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID or Title: ");
                    String search = sc.nextLine().trim();
                    library.searchBook(search);
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    id = readPositiveId(sc);

                    if (id == -1) {
                        System.out.println("Invalid Book ID!");
                        break;
                    }

                    System.out.print("Enter Student Name: ");
                    String issueStudent = sc.nextLine().trim();

                    if (issueStudent.isEmpty()) {
                        System.out.println("Student name cannot be empty.");
                        break;
                    }

                    library.issueBook(id, issueStudent);
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    id = readPositiveId(sc);

                    if (id == -1) {
                        System.out.println("Invalid Book ID!");
                        break;
                    }

                    System.out.print("Enter Student Name: ");
                    String returnStudent = sc.nextLine().trim();

                    if (returnStudent.isEmpty()) {
                        System.out.println("Student name cannot be empty.");
                        break;
                    }

                    library.returnBook(id, returnStudent);
                    break;

                case 6:
                    System.out.print("Enter Book ID to delete: ");
                    id = readPositiveId(sc);

                    if (id == -1) {
                        System.out.println("Invalid Book ID!");
                        break;
                    }

                    library.deleteBook(id);
                    break;

                case 7:
                    System.out.println("Thank you for using the Library Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1 to 7.");
            }
        }

        sc.close();
    }

    // Read a positive book ID
    private static int readPositiveId(Scanner sc) {
        try {
            int id = Integer.parseInt(sc.nextLine().trim());
            return id > 0 ? id : -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}

    

