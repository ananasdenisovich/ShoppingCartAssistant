public interface OrderSubject {
    void addObserver(OrderObserver observer);

    void removeObserver(OrderObserver observer);

    void notifyObservers(OrderStatus status);
}
