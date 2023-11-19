public class ClothingProduct implements Product { //factory concrete product
    private String name;
    private double price;
    public ClothingProduct(String name, double price) {
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