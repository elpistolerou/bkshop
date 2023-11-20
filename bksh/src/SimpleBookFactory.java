public class SimpleBookFactory implements BookFactory {
    @Override
    public Book createBook(String title, String author, double price) {
        return new SimpleBook(title, author, price);
}
}
