package com.mycompany.lab;

public class BookAuthor extends Person {

    public BookAuthor(String name, int id, String role) {
        super(name, id, role);
    }


    public void write() {
    }

    @Override
    public void requestAvailableBooks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public void registerPerson(Person person) {
        DBConnection.getInstance();
        DBConnection.getInstance().registerUser(person);
    }
    
}
