
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<String> issueRecords = new ArrayList<>();

    // Check whether a book ID already exists
    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                return book;
            }
        }
        return null;
    }

    // Add a new book
    public void addBook(int id, String title, String author, int quantity) {
        if (id <= 0 || quantity < 0) {
            System.out.println("ID must be positive and quantity cannot be negative.");
            return;
        }

        if (findBookById(id) != null) {
            System.out.println("Book ID already exists!");
            return;
        }

        Book book = new Book(id, title, author, quantity);
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        System.out.println("\n----- ALL BOOKS -----");
        for (Book book : books) {
            book.displayBook();
        }
    }

    // Search by ID or title
    public void searchBook(String search) {
        boolean found = false;

        for (Book book : books) {
            if (String.valueOf(book.getBookId()).equals(search)
                    || book.getTitle().equalsIgnoreCase(search)) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found!");
        }
    }

    // Issue a book to a student
    public void issueBook(int id, String studentName) {
        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (book.getQuantity() <= 0) {
            System.out.println("Book is currently unavailable.");
            return;
        }

        book.setQuantity(book.getQuantity() - 1);
        issueRecords.add(id + "|" + studentName);

        System.out.println("Book issued successfully to " + studentName + "!");
    }

    // Return a book using its ID
    public void returnBook(int id, String studentName) {
        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        String record = id + "|" + studentName;

        if (!issueRecords.remove(record)) {
            System.out.println("No matching issue record found for this student.");
            return;
        }

        book.setQuantity(book.getQuantity() + 1);
        System.out.println("Book returned successfully!");
    }

    // Delete a book
    public void deleteBook(int id) {
        Book book = findBookById(id);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        for (String record : issueRecords) {
            if (record.startsWith(id + "|")) {
                System.out.println("Cannot delete: this book is currently issued.");
                return;
            }
        }

        books.remove(book);
        System.out.println("Book deleted successfully!");
    }
}

    

