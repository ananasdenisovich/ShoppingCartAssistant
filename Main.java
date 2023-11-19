import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCartManager shoppingCartManager = ShoppingCartManager.getInstance();

        OrderObserver emailObserver = new EmailNotificationObserver();
        OrderObserver inventoryObserver = new InventoryManagementObserver();

        shoppingCartManager.addObserver(emailObserver);
        shoppingCartManager.addObserver(inventoryObserver);
        System.out.println("We have 10% discount on everything!");
        while (true) {
            System.out.println("\n1. Add Product to Cart");
            System.out.println("2. Checkout");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProductToCart(scanner, shoppingCartManager);
                    break;
                case 2:
                    checkout(shoppingCartManager, scanner);
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addProductToCart(Scanner scanner, ShoppingCartManager shoppingCartManager) {
        System.out.print("Enter product type (electronic/clothing): ");
        String type = scanner.nextLine().toLowerCase();  // Convert to lowercase

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        Product product = ProductFactory.createProduct(type, name, price);
        shoppingCartManager.addToCart(product);
    }

    private static void checkout(ShoppingCartManager shoppingCartManager, Scanner scanner) {
        System.out.println("Select payment method:");
        System.out.println("1. Apple");
        System.out.println("2. Kaspi");
        System.out.print("Enter your choice: ");

        int paymentChoice = scanner.nextInt();
        scanner.nextLine();

        PaymentAdapter paymentAdapter;

        switch (paymentChoice) {
            case 1:
                paymentAdapter = new AppleAdapter();
                break;
            case 2:

                paymentAdapter = new KaspiAdapter(new KaspiPayment());
                break;
            default:
                System.out.println("Invalid payment method choice. Exiting checkout.");
                return;
        }

        ApplePayment applePayment = new ApplePayment(paymentAdapter);
        PaymentStrategy paymentStrategyWithDiscount = new DiscountDecorator(applePayment, 10.0);

        shoppingCartManager.checkout(paymentStrategyWithDiscount);
    }
}
