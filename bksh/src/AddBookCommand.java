import java.util.Scanner;

public class AddBookCommand implements Command {
    private BookFactory bookFactory;
    private StockManager stockManager;

    public AddBookCommand(BookFactory bookFactory, StockManager stockManager) {
        this.bookFactory = bookFactory;
        this.stockManager = stockManager;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        Book book = bookFactory.createBook(title, author, price);
        BookShop.getInstance().addBook(book);
        stockManager.notifyObservers(book);
        System.out.println("Book added successfully!");
    }
}
