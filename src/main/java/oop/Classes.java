package oop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*

 * Classes and objects: attributes, constructor, methods, this.

*/

class Person {

    private static final Logger logger = LoggerFactory.getLogger(Person.class);

    String name;
    int age;
    boolean adult;

    // Constructor to initialize the name and age attributes
    Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.adult = age >= 18;
    }

    // Method to introduce the person which prints their name and age
    void introduceOneself() {
        logger.info("Hello, I am {} and I am {} years old", name, age);
        if(adult) logger.info("I am an adult");
        else logger.info("I am not an adult");
    }

    // Method to celebrate a birthday which increases the age
    void haveBirthday() {
        age++;
    }
}

public class Classes {

    public static void main(){

        final Logger logger = LoggerFactory.getLogger(Classes.class);

        Person p1 = new Person("exampleName1", 28);
        Person p2 = new Person("exampleName2", 10);

        p1.introduceOneself();
        p2.introduceOneself();

        p1.haveBirthday();
        logger.info("{} is now {} years old.", p1.name, p1.age);
    }
}