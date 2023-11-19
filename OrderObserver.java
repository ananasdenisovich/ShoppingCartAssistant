public interface OrderObserver { //subscriber
    void update(OrderStatus status);
}