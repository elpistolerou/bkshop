public class SimpleBook implements Book{
    private String title;
    private String author;
    private double price;

    public SimpleBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
}
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
