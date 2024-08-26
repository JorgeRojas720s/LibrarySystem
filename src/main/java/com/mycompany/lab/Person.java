package com.mycompany.lab;

public abstract class Person {

    protected String name;

    protected int id;

    protected Book[] books;

    public Person(String name, int id) {
    }

    public abstract void requestAvailableBooks();
}
