public class DiscountDecorator implements PaymentStrategy {
    private PaymentStrategy component;
    private double discount;

    public DiscountDecorator(PaymentStrategy component, double discount) {
        this.component = component;
        this.discount = discount;
    }
    @Override
    public void processPayment(double amount) {
        double discountedAmount = amount * (1 - discount / 100);
        System.out.println("Applying discount of " + discount + "%. Final price: " + discountedAmount);
        component.processPayment(discountedAmount);
    }
}
