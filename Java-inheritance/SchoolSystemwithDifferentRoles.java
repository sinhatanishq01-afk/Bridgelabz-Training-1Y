class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayRole() {
        System.out.println("Person");
    }
}

class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println("Teacher");
    }
}

class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println("Student");
    }
}

class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        System.out.println("Staff");
    }
}

public class Main {
    public static void main(String[] args) {
        Person p1 = new Teacher("Amit", 35, "Math");
        Person p2 = new Student("Riya", 20, "A");
        Person p3 = new Staff("Raj", 40, "Administration");

        p1.displayRole();
        p2.displayRole();
        p3.displayRole();
    }
}