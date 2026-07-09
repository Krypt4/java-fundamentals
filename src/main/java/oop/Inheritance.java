package oop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

 * Inheritance: code reuse between classes (extends, super).

*/

// Base class (superclass)
class Animal {

    Logger logger = LoggerFactory.getLogger(Animal.class);

    protected String name;

    Animal(String name) {
        this.name = name;
    }

    void eat() {
        logger.info("{} is eating.", name);
    }

    void makeSound() {
        logger.info("{} makes a generic sound.", name);
    }
}

// Derived class (subclass) that inherits from Animal
class Dog extends Animal {

    Logger logger = LoggerFactory.getLogger(Dog.class);

    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        logger.info("{} says: Woof!", name);
    }

    void fetchBall() {
        logger.info("{} goes to fetch the ball.", name);
    }
}

// Derived class (subclass) that inherits from Animal
class Cat extends Animal {

    Logger logger = LoggerFactory.getLogger(Cat.class);

    Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        logger.info("{} says: Meow!", name);
    }
}

public class Inheritance {

    private static final Logger logger = LoggerFactory.getLogger(Inheritance.class);

    public static void main(String[] args) {

        Dog dog = new Dog("nameDog");
        Cat cat = new Cat("nameCat");

        dog.eat();        // Method inherited from Animal
        dog.makeSound();  // Overridden method
        dog.fetchBall();  // Dog's own method

        cat.eat();        // Method inherited from Animal
        cat.makeSound();  // Overridden method
    }
}