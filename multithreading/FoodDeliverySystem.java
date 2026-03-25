class Order implements Runnable {

    private int orderId;
    private String restaurantName;
    private int deliveryTime; // in seconds
    private String deliveryType;

    public Order(int orderId, String restaurantName, int deliveryTime, String deliveryType) {
        this.orderId = orderId;
        this.restaurantName = restaurantName;
        this.deliveryTime = deliveryTime;
        this.deliveryType = deliveryType;
    }

    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();

            System.out.println("Order " + orderId + " from " + restaurantName +
                    " [" + deliveryType + "] handled by " +
                    Thread.currentThread().getName() + " → Picked up");

            Thread.sleep(deliveryTime * 500); // halfway simulation

            System.out.println("Order " + orderId +
                    " → In Transit by " + Thread.currentThread().getName());

            Thread.sleep(deliveryTime * 500); // remaining time

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.println("Order " + orderId +
                    " → Delivered by " + Thread.currentThread().getName() +
                    " | Total Time: " + totalTime + " ms");

        } catch (InterruptedException e) {
            System.out.println("Order " + orderId + " interrupted.");
        }
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {

        // Creating orders
        Order o1 = new Order(101, "Pizza Hut", 4, "Express");
        Order o2 = new Order(102, "Dominos", 6, "Standard");
        Order o3 = new Order(103, "KFC", 5, "Economy");
        Order o4 = new Order(104, "Burger King", 3, "Express");
        Order o5 = new Order(105, "Subway", 7, "Standard");

        // Creating threads (delivery agents)
        Thread t1 = new Thread(o1, "Agent-A");
        Thread t2 = new Thread(o2, "Agent-B");
        Thread t3 = new Thread(o3, "Agent-C");
        Thread t4 = new Thread(o4, "Agent-D");
        Thread t5 = new Thread(o5, "Agent-E");

        // Setting priorities
        t1.setPriority(10); // Express
        t4.setPriority(10); // Express
        t2.setPriority(5);  // Standard
        t5.setPriority(5);  // Standard
        t3.setPriority(3);  // Economy

        // Starting threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // Wait for all deliveries to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\nAll orders have been delivered.");
    }
}
