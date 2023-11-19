public class AppleAdapter implements PaymentAdapter, PaymentStrategy { //adapter client
    public void processPayment(double amount) {
        System.out.println("Processing apple payment. Amount: " + amount);
    }
}