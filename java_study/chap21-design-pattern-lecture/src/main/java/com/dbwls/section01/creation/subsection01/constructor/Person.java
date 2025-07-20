package com.dbwls.section01.creation.subsection01.constructor;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("name: " + name + ", age: " + age);
    }

    public static void main(String[] args) {
        Person person = new Person("홍길동", 25);
        person.displayInfo();
    }
}