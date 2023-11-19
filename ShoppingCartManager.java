import java.util.ArrayList;
import java.util.List;

public class ShoppingCartManager implements OrderSubject {
    private static ShoppingCartManager instance;

    private List<OrderObserver> observers = new ArrayList<>();
    private List<Product> cart = new ArrayList<>();
    private ShoppingCartManager() {
    }

    public static ShoppingCartManager getInstance() { //singleton
        if (instance == null) {
            instance = new ShoppingCartManager();
        }
        return instance;
    }

    public void addToCart(Product product) {
        cart.add(product);
        System.out.println("Added " + product.getName() + " to the cart. Price: " + product.getPrice());
    }

    public void checkout(PaymentStrategy paymentStrategy) {
        double totalAmount = calculateTotalAmount();
        double discountedAmount = applyDiscount(totalAmount);

        System.out.println("Total amount before discount: " + totalAmount);
        System.out.println("Total amount after discount: " + discountedAmount);

        paymentStrategy.processPayment(discountedAmount);
        notifyObservers(OrderStatus.PLACED);
    }

    private double calculateTotalAmount() {
        return cart.stream().mapToDouble(Product::getPrice).sum();
    }

    private double applyDiscount(double originalPrice) {
        return originalPrice * (1 - getOverallDiscount() / 100);
    }

    private double getOverallDiscount() {
        return 10.0;
    }

    @Override
    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(OrderStatus status) {
        for (OrderObserver observer : observers) {
            observer.update(status);
        }
    }
}
