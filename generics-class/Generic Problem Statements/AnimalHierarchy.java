package com.gla.Generics;

import java.util.*;

class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
}

public class Main {

    public static void printAnimals(List<? extends Animal> animals) {
        for (Animal a : animals) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {

        List<Dog> dogs = Arrays.asList(new Dog("Tommy"), new Dog("Bruno"));
        List<Cat> cats = Arrays.asList(new Cat("Kitty"), new Cat("Mimi"));

        printAnimals(dogs);
        printAnimals(cats);
    }
}