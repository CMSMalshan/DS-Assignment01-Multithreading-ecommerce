# DS-Assignment01-Multithreading-ecommerce



## 🛒 E-commerce Checkout System (Architecture A)
This repository contains a multithreaded Java application simulating an E-commerce Checkout System using the **Thread-per-Request** architecture. It strictly utilizes Java concurrency utilities without relying on external databases or network sockets.

### 👥 Group Members
* C.M.S. Malshan (Reg No: D/BCS/24/0022)
* NMSGHN Nawarathna (Reg No: D/BCS/24/0032)

### 🚀 Features Demonstrated (Mandatory Challenges)
* **Shared Memory Management:** Coordinated access to the `InventoryStore` object.
* **Race Condition Fix:** Elimination of data inconsistencies using the `synchronized` keyword, ensuring inventory never drops below zero.
* **Thread Exhaustion Simulation:** Demonstration of a constrained Fixed Thread Pool handling blocking I/O (simulated via `Thread.sleep()` in `MockPaymentService`), forcing new requests into a wait queue.

### 🛠️ How to Run
1. Clone the repository to your local machine.
2. Open the project in your preferred Java IDE (IntelliJ IDEA, Eclipse, etc.).
3. Run the `Main.java` file.
4. Observe the console logs for exact Timestamps, Thread IDs, and the status of the Checkout process.