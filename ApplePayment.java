public class ApplePayment implements PaymentStrategy, Discounts{ //concrete strategy and adapter client
    private PaymentAdapter paymentAdapter;

    public ApplePayment(PaymentAdapter paymentAdapter) {
        this.paymentAdapter = paymentAdapter;
    }

    @Override
    public void processPayment(double amount) {
        paymentAdapter.processPayment(amount);
    }
    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice;
    }
}
