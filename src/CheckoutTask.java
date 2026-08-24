import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CheckoutTask implements Runnable {

    private InventoryStore store;
    private MockPaymentService paymentService;

    public CheckoutTask(InventoryStore store, MockPaymentService paymentService) {
        this.store = store;
        this.paymentService = paymentService;
    }

    private String getTimestamp() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println("[" + getTimestamp() + "] [" + threadName + "] [CHECKOUT] User attempting to purchase...");

        if (store.getItemsInStock() > 0) {

            paymentService.processPayment();

            store.deductItem();

        } else {
            System.out.println("[" + getTimestamp() + "] [" + threadName + "] [CHECKOUT] Purchase failed. Item out of stock.");
        }
    }
}
