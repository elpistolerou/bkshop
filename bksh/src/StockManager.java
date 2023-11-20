import java.util.ArrayList;
import java.util.List;

public class StockManager {
    private List<StockObserver> observers = new ArrayList<>();

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }
    public void notifyObservers(Book book) {
        for (StockObserver observer : observers) {
            observer.update(book);
        }
    }
}
