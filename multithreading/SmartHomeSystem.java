import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class SmartDevice implements Runnable {

    private String deviceName;
    private int interval;

    public SmartDevice(String deviceName, int interval) {
        this.deviceName = deviceName;
        this.interval = interval;
    }

    private String getTimeStamp() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(
                        "[" + getTimeStamp() + "] " +
                                deviceName +
                                " | Thread: " + Thread.currentThread().getName() +
                                " | Priority: " + Thread.currentThread().getPriority() +
                                " | Cycle: " + i
                );

                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
            System.out.println(deviceName + " interrupted.");
        }

        System.out.println(deviceName + " finished execution.");
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {

        // Create device tasks
        SmartDevice temperature = new SmartDevice("Temperature Sensor (5s)", 5000);
        SmartDevice security = new SmartDevice("Security Camera (3s)", 3000);
        SmartDevice light = new SmartDevice("Light Controller (4s)", 4000);
        SmartDevice door = new SmartDevice("Door Lock Monitor (6s)", 6000);

        // Create threads
        Thread t1 = new Thread(temperature, "Temp-Thread");
        Thread t2 = new Thread(security, "Security-Thread");
        Thread t3 = new Thread(light, "Light-Thread");
        Thread t4 = new Thread(door, "Door-Thread");

        // Set priorities
        t2.setPriority(10); // Security
        t1.setPriority(7);  // Temperature
        t3.setPriority(5);  // Light
        t4.setPriority(5);  // Door

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to complete
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\nAll smart home devices have completed their cycles. System shutting down.");
    }
}
