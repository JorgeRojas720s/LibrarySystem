package com.mycompany.lab;

/**
 * Represents a person (cliente, autor o trabajador).
 * 
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */

public abstract class Person {

    protected Book[] books;
    protected int id;
    protected String name;
    protected String role;

    /**
     * Constructor of the class Person.
     * 
     * @param name Name of the person.
     * @param id ID of the person.
     * @param role Role of the person (client, author, worker).
     */
    public Person(String name, int id, String role) {
        this.name = name;
        this.id = id;
        this.role = role;
    }

    /**
     * Request for the available books.
     */
    public abstract void requestAvailableBooks();

    /**
     * Add a person to the database.
     * 
     * @param person person to be add.
     */
    public abstract void registerPerson(Person person);

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
