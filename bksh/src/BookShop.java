import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookShop {
    private static BookShop instance;
    private List<Book> books;

    private BookShop() {
        books = new ArrayList<>();
}



    public static BookShop getInstance() {
        if (instance == null) {
            instance = new BookShop();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}
