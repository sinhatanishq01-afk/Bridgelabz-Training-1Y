class BankAccount implements Runnable {

    private String accountHolder;
    private String accountType;
    private int priority;

    public BankAccount(String accountHolder, String accountType, int priority) {
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.priority = priority;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(
                        "User: " + accountHolder +
                                " | Account Type: " + accountType +
                                " | Thread: " + Thread.currentThread().getName() +
                                " | Priority: " + Thread.currentThread().getPriority() +
                                " | Checking balance (" + i + ")"
                );

                Thread.sleep(2000); // simulate 2 seconds delay
            }
        } catch (InterruptedException e) {
            System.out.println(accountHolder + " interrupted.");
        }
    }
}

public class BankSimulation {
    public static void main(String[] args) {

        // Creating BankAccount objects
        BankAccount premiumUser = new BankAccount("Alice", "Premium", Thread.MAX_PRIORITY);
        BankAccount regularUser = new BankAccount("Bob", "Regular", Thread.NORM_PRIORITY);
        BankAccount basicUser = new BankAccount("Charlie", "Basic", Thread.MIN_PRIORITY);

        // Creating Threads
        Thread t1 = new Thread(premiumUser, "Premium-Thread");
        Thread t2 = new Thread(regularUser, "Regular-Thread");
        Thread t3 = new Thread(basicUser, "Basic-Thread");

        // Setting priorities
        t1.setPriority(Thread.MAX_PRIORITY);   // 10
        t2.setPriority(Thread.NORM_PRIORITY);  // 5
        t3.setPriority(Thread.MIN_PRIORITY);   // 1

        // Starting threads
        t1.start();
        t2.start();
        t3.start();
    }
}
