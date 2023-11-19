public class EmailNotificationObserver implements OrderObserver { //concrete subscriber
    @Override
    public void update(OrderStatus status) {
        System.out.println("Email notification: Order status is now " + status);
    }
}


