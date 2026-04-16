package com.gla.Generics;

import java.util.ArrayList;

class Fruit {
    String name;

    Fruit(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Apple extends Fruit {
    Apple(String name) {
        super(name);
    }
}

class Mango extends Fruit {
    Mango(String name) {
        super(name);
    }
}

class Car {}

class FruitBox<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void display() {
        for (T f : fruits) {
            System.out.println(f);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.add(new Apple("Red Apple"));

        FruitBox<Mango> mangoBox = new FruitBox<>();
        mangoBox.add(new Mango("Alphonso Mango"));

        appleBox.display();
        mangoBox.display();

        
    }
}