public interface PaymentStrategy {  //strategy intrfc and adapter target
    void processPayment(double amount);
}