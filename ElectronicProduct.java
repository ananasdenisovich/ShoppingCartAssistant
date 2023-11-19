public class ElectronicProduct implements Product {  //factory concrete product
    private String name;
    private double price;
    public ElectronicProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}