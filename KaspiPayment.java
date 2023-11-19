public class KaspiPayment implements PaymentStrategy { //concrete strategy and adaptee
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Kaspi payment. Amount: " + amount);

    }
}