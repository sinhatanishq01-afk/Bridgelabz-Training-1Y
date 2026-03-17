interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    public void performDuties() {
        System.out.println(name + " is cooking " + specialty);
    }
}

class Waiter extends Person implements Worker {
    int tablesAssigned;

    Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    public void performDuties() {
        System.out.println(name + " is serving " + tablesAssigned + " tables");
    }
}

public class Main {
    public static void main(String[] args) {
        Worker w1 = new Chef("Arjun", 1, "Italian");
        Worker w2 = new Waiter("Rohit", 2, 5);

        w1.performDuties();
        w2.performDuties();
    }
}