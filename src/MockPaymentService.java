public class MockPaymentService {

    // MANDATORY CHALLENGE: Thread Exhaustion
    // This method deliberately sleeps (simulating blocking I/O) to hold up server threads.
    public void processPayment() {
        System.out.println("[" + Thread.currentThread().getName() + "] Processing payment...");
        try {
            // Sleep for 2 seconds to hold up the server threads.
            // This will cause new requests to wait in a queue (Thread Exhaustion).
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[" + Thread.currentThread().getName() + "] Payment successful.");
    }
}