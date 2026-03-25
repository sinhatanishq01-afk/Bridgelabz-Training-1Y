class ExamActivity implements Runnable {

    private String activityName;
    private int startDelay;   // when to start (ms)
    private int duration;     // how long to run (ms)

    public ExamActivity(String activityName, int startDelay, int duration) {
        this.activityName = activityName;
        this.startDelay = startDelay;
        this.duration = duration;
    }

    @Override
    public void run() {
        try {
            // Initial delay before activity starts
            Thread.sleep(startDelay);

            System.out.println(activityName + " started by " +
                    Thread.currentThread().getName());

            // Simulate activity duration
            Thread.sleep(duration);

            System.out.println(activityName + " completed by " +
                    Thread.currentThread().getName());

        } catch (InterruptedException e) {
            System.out.println(activityName + " interrupted.");
        }
    }
}

public class ExamHallManagement {
    public static void main(String[] args) {

        // Activities
        ExamActivity entry = new ExamActivity("Student Entry Monitoring", 0, 15000);
        ExamActivity question = new ExamActivity("Question Paper Distribution", 5000, 5000);
        ExamActivity attendance = new ExamActivity("Attendance Marking", 10000, 5000);
        ExamActivity collection = new ExamActivity("Answer Sheet Collection", 20000, 5000);

        // Threads
        Thread t1 = new Thread(entry, "Entry-Thread");
        Thread t2 = new Thread(question, "Question-Thread");
        Thread t3 = new Thread(attendance, "Attendance-Thread");
        Thread t4 = new Thread(collection, "Collection-Thread");

        // Set priorities
        t2.setPriority(10); // Question paper
        t3.setPriority(8);  // Attendance
        t4.setPriority(7);  // Collection
        t1.setPriority(5);  // Entry

        // Show initial states (NEW)
        System.out.println("Initial Thread States:");
        System.out.println("Entry: " + t1.getState());
        System.out.println("Question: " + t2.getState());
        System.out.println("Attendance: " + t3.getState());
        System.out.println("Collection: " + t4.getState());

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Monitor thread states during execution
        try {
            while (t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive()) {

                System.out.println("\nCurrent Thread States:");
                System.out.println("Entry: " + t1.getState());
                System.out.println("Question: " + t2.getState());
                System.out.println("Attendance: " + t3.getState());
                System.out.println("Collection: " + t4.getState());

                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            System.out.println("Monitoring interrupted.");
        }

        System.out.println("\nAll activities completed.");
    }
}
