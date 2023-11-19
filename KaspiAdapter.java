public class KaspiAdapter implements PaymentAdapter { //adapter adapter
    private KaspiPayment kaspiPayment;

    public KaspiAdapter(KaspiPayment kaspiPayment) {
        this.kaspiPayment = kaspiPayment;
    }

    @Override
    public void processPayment(double amount) {
        double convertedAmount = convertToAppleFormat(amount);
        kaspiPayment.processPayment(convertedAmount);
    }
    private double convertToAppleFormat(double amount) {

        return amount;
    }
}
