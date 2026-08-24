import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {


        InventoryStore store = new InventoryStore(5);
        MockPaymentService paymentService = new MockPaymentService();


        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("--- E-commerce Checkout System Started ---");
        System.out.println("Total Items in Stock: " + store.getItemsInStock() + "\n");

        int totalRequests = 12;
        for (int i = 1; i <= totalRequests; i++) {
            executor.submit(new CheckoutTask(store, paymentService));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n--- All requests processed ---");
        System.out.println("Final Items in Stock: " + store.getItemsInStock());
    }
}
