public class ProductFactory {  //factory concrete creator
    public static Product createProduct(String type, String name, double price) {
        switch (type.toLowerCase()) {
            case "electronic":
                return new ElectronicProduct(name, price);
            case "clothing":
                return new ClothingProduct(name, price);
            default:
                throw new IllegalArgumentException("Invalid product type: " + type);
        }
    }
}