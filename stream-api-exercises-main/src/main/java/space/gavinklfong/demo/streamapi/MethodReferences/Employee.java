package space.gavinklfong.demo.streamapi.MethodReferences;

// Java Program to Illustrate How One can use
// Static method reference
// To Sort with Custom Comparator

// Importing required classes
import java.io.*;
import java.util.*;

// Class 1
// Helper class
// Object need to be sorted
class Person {

    private String name;
    private Integer age;

    private Integer salary;

    // Constructor
    public Person(String name, int age,int salary)
    {
        // This keyword refers to current instance itself
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getter-setters
    public Integer getAge() { return age; }
    public String getName() { return name; }

    public Integer getSalary() { return salary; }
}

// Class 2
// Main class
 class GFG {

    // Method 1
    // Static method to compare with name
    public static int compareByName(Person a, Person b)
    {
        return a.getName().compareTo(b.getName());
    }

    // Method 2
    // Static method to compare with age
    public static int compareByAge(Person a, Person b)
    {
        return a.getAge().compareTo(b.getAge());
    }

    // Method 3
    //Compare salary
    public static int compareSalary(Person a, Person b){
        return b.getSalary().compareTo(a.getSalary());
    }

    // Method 3
    // Main driver method
    public static void main(String[] args)
    {

        // Creating an empty ArrayList of user-defined type
        // List of person
        List<Person> personList = new ArrayList<>();

        // Adding elements to above List
        // using add() method
        personList.add(new Person("vicky", 24,1000));
        personList.add(new Person("poonam", 25,2000));
        personList.add(new Person("sachin", 19,3000));

        // Using static method reference to
        // sort array by name
        Collections.sort(personList, GFG::compareByName);

        // Display message only
        System.out.println("Sort by name :");

        // Using streams over above object of Person type
        personList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);

        // Now using static method reference
        // to sort array by age
        Collections.sort(personList, GFG::compareByAge);

        // Display message only
        System.out.println("Sort by age :");

        // Using streams over above object of Person type
        personList.stream()
                .map(x -> x.getName())
                .forEach(System.out::println);

        // Now using static methods reference to sort salary
        Collections.sort(personList,GFG::compareSalary);

        // using Streams
        personList.stream().map(p-> p.getSalary()).forEach(System.out::println);

    }
}

