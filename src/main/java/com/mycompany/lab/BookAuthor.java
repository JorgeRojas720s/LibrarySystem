package com.mycompany.lab;

/**
 * Represents an author of a book.
 * Extends Person.
 * 
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */
public class BookAuthor extends Person {

    /**
     * Constructor of the class BookAuthor.
     * 
     * @param name Name of the person.
     * @param id ID of the person.
     * @param role Role of the person (author).
     */
    public BookAuthor(String name, int id, String role) {
        super(name, id, role);
    }

    /**
     * Methods for an author create a book.
     */
    public void write() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void requestAvailableBooks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void registerPerson(Person person) {
        DBConnection.getInstance().registerUser(person);
    }
}
