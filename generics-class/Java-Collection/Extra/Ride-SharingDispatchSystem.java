package com.gla.Generics;

import java.util.*;

class RideRequest implements Comparable<RideRequest> {
    int id;
    int priority;

    RideRequest(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public int compareTo(RideRequest other) {
        return other.priority - this.priority;
    }

    public String toString() {
        return "Request{id=" + id + ", priority=" + priority + "}";
    }
}

class Driver {
    int id;
    String name;

    Driver(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Driver{id=" + id + ", name='" + name + "'}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver d = (Driver) o;
        return id == d.id;
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}

class Ride {
    RideRequest request;
    Driver driver;

    Ride(RideRequest request, Driver driver) {
        this.request = request;
        this.driver = driver;
    }

    public String toString() {
        return "Ride{" + request + ", " + driver + "}";
    }
}

public class Main {

    public static void main(String[] args) {

        Queue<RideRequest> requestQueue = new LinkedList<>();
        PriorityQueue<RideRequest> priorityQueue = new PriorityQueue<>();
        Set<Driver> drivers = new HashSet<>();
        List<Ride> completedRides = new ArrayList<>();

        requestQueue.add(new RideRequest(1, 2));
        requestQueue.add(new RideRequest(2, 5));
        requestQueue.add(new RideRequest(3, 1));

        priorityQueue.addAll(requestQueue);

        drivers.add(new Driver(101, "Aman"));
        drivers.add(new Driver(102, "Riya"));
        drivers.add(new Driver(103, "Rahul"));

        while (!priorityQueue.isEmpty() && !drivers.isEmpty()) {
            RideRequest req = priorityQueue.poll();

            Driver driver = drivers.iterator().next();
            drivers.remove(driver);

            System.out.println("Assigning " + req + " to " + driver);

            Ride ride = new Ride(req, driver);
            completedRides.add(ride);
        }

        System.out.println("\nCompleted Rides:");
        for (Ride r : completedRides) {
            System.out.println(r);
        }
    }
}