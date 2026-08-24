public class InventoryStore {
    private int itemsInStock;

    public InventoryStore(int initialStock) {
        this.itemsInStock = initialStock;
    }

    public int getItemsInStock() {
        return itemsInStock;
    }

    // MANDATORY CHALLENGE: Race Condition Fix & Inventory Check
    // To demonstrate the Race Condition, temporarily remove the "synchronized" keyword.
    // To fix it and ensure inventory never drops below zero, keep "synchronized".
    public synchronized void deductItem() {
        // Ensure inventory never drops below zero
        if (itemsInStock > 0) {
            try {
                // Simulating a slight delay to easily trigger race conditions
                // when the "synchronized" keyword is removed.
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            itemsInStock = itemsInStock - 1;
            System.out.println("[" + Thread.currentThread().getName() + "] Successfully purchased an item. Remaining stock: " + itemsInStock);
        } else {
            System.out.println("[" + Thread.currentThread().getName() + "] Failed to purchase. Item is OUT OF STOCK.");
        }
    }
}
