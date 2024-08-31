package com.mycompany.lab;

public abstract class Person {

    protected String name;

    protected int id;
    

    protected Book[] books;
    
    protected String role;

    public Person(String name, int id, String role) {
        this.name = name;
        this.id = id;
        this.role = role;
    }
    
    
    public abstract void requestAvailableBooks();
    
    public abstract void registerPerson(Person person);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
}
