import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// ... (previous code)

public class BookShopApp {
    public static void main(String[] args) {
        BookShop bookShop = BookShop.getInstance();
        StockManager stockManager = new StockManager();
        BookFactory bookFactory = new SimpleBookFactory();

        // Observer Pattern: Attach observer to the notifier
        stockManager.addObserver(book -> System.out.println("New book added to stock: " + book.getTitle()));

        // Menu loop
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nMenu:");
            System.out.println("1. View all books");
            System.out.println("2. Add a book");
            System.out.println("3. Remove a book");
            System.out.println("4. Sort books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllBooks();
                    break;
                case 2:
                    addBook(bookFactory, stockManager);
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    sortBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);
    }

    private static void viewAllBooks() {
        List<Book> books = BookShop.getInstance().getBooks();
        System.out.println("\nAll Books:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " - $" + book.getPrice());
        }
    }

    private static void addBook(BookFactory bookFactory, StockManager stockManager) {
        Command addBookCommand = new AddBookCommand(bookFactory, stockManager);
        addBookCommand.execute();
    }

    private static void removeBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the book to remove: ");
        String titleToRemove = scanner.nextLine();

        List<Book> books = BookShop.getInstance().getBooks();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(titleToRemove)) {
                books.remove(book);
                System.out.println("Book removed successfully!");
                return;
            }
        }

        System.out.println("Book not found!");
    }

    private static void sortBooks() {
        List<Book> books = BookShop.getInstance().getBooks();
        System.out.println("\nSorting books by title...");
        Collections.sort(books, (book1, book2) -> book1.getTitle().compareToIgnoreCase(book2.getTitle()));
        viewAllBooks();
    }
}
