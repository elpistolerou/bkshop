public class DiscountedBookDecorator implements Book  {
    private Book book;
    private double discount;

    public DiscountedBookDecorator(Book book, double discount) {
        this.book = book;
        this.discount = discount;
    }

    @Override
    public String getTitle() {
        return book.getTitle();
    }

    @Override
    public String getAuthor() {
        return book.getAuthor();
    }

    @Override
    public double getPrice() {
        return book.getPrice() - (book.getPrice() * discount);
    }
}
