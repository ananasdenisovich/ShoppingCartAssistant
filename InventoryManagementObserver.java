public class InventoryManagementObserver implements OrderObserver { //concrete subscriber
    @Override
    public void update(OrderStatus status) {
        if (status == OrderStatus.PLACED) {
            System.out.println("Inventory updated: Order placed, finding items from stock.");
        }
    }
}