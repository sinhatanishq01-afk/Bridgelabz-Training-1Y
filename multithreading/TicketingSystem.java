import java.util.*;

class Ticket extends Thread {

    private int ticketId;
    private String type;
    private int priority;
    private int queuePosition;

    // Static tracking
    static Map<Integer, List<Long>> waitTimes = new HashMap<>();
    static long systemStartTime;

    public Ticket(int ticketId, String type, int priority, int queuePosition) {
        this.ticketId = ticketId;
        this.type = type;
        this.priority = priority;
        this.queuePosition = queuePosition;

        setName("Agent-" + ticketId);
        setPriority(priority);
    }

    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            long waitTime = startTime - systemStartTime;

            // Store wait time per priority
            synchronized (waitTimes) {
                waitTimes.putIfAbsent(priority, new ArrayList<>());
                waitTimes.get(priority).add(waitTime);
            }

            System.out.println("START → Ticket #" + ticketId +
                    " | Type: " + type +
                    " | Priority: " + priority +
                    " | Agent: " + getName() +
                    " | Queue Position: " + queuePosition);

            // Random processing time (1–5 seconds)
            int processTime = (new Random().nextInt(5) + 1) * 1000;
            Thread.sleep(processTime);

            System.out.println("DONE  → Ticket #" + ticketId +
                    " | Type: " + type +
                    " | Agent: " + getName() +
                    " | Processing Time: " + processTime + " ms");

        } catch (InterruptedException e) {
            System.out.println("Ticket #" + ticketId + " interrupted.");
        }
    }
}

public class TicketingSystem {

    public static void main(String[] args) {

        // Ticket types
        String[] types = {
                "Critical Bug", "Feature Request",
                "General Query", "Feedback"
        };

        int[] priorities = {10, 4, 2, 1};

        List<Ticket> tickets = new ArrayList<>();
        Random rand = new Random();

        Ticket.systemStartTime = System.currentTimeMillis();

        // Create 10 tickets
        for (int i = 1; i <= 10; i++) {
            int index = rand.nextInt(4);
            Ticket t = new Ticket(i, types[index], priorities[index], i);
            tickets.add(t);
        }

        // Sort by priority (descending) → queue simulation
        tickets.sort((a, b) -> b.getPriority() - a.getPriority());

        System.out.println("Queue Order (by priority):");
        for (Ticket t : tickets) {
            System.out.println("Ticket #" + t.getId() + " | Priority: " + t.getPriority());
        }

        long totalStart = System.currentTimeMillis();

        // Start all tickets
        for (Ticket t : tickets) {
            t.start();
        }

        // Wait for completion
        for (Ticket t : tickets) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Main interrupted.");
            }
        }

        long totalEnd = System.currentTimeMillis();

        // Total processing time
        System.out.println("\nTotal Processing Time: " + (totalEnd - totalStart) + " ms");

        // Average wait time per priority
        System.out.println("\nAverage Wait Time per Priority:");
        for (int p : Ticket.waitTimes.keySet()) {
            List<Long> times = Ticket.waitTimes.get(p);
            long sum = 0;
            for (long t : times) sum += t;

            System.out.println("Priority " + p + " → " + (sum / times.size()) + " ms");
        }
    }
}
