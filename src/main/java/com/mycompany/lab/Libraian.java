package com.mycompany.lab;

import java.util.ArrayList;

/**
 * Represents the librarian. Extends the class Person and implements the
 * Librarie interface.
 *
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */
public class Libraian extends Person implements Librarie {

    /**
     * Constructor of the class Libraian.
     *
     * @param name Name of the librairan.
     * @param id ID librairan.
     * @param role Role of the librarian (worker).
     */
    public Libraian(String name, int id, String role) {
        super(name, id, role);
    }

    /**
     * Creates a report of the available books with there authors.
     */
    public ArrayList generateReport() {
        DBConnection.getInstance();
        return DBConnection.getInstance().getBorrowBooks();
    }

    @Override
    public void delete(int id) {
        DBConnection.getInstance().deleteBook(id);
    }

    @Override
    public void update(Book book) {
        DBConnection.getInstance().updateBook(book);
    }

    @Override
    public void requestAvailableBooks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void registerPerson(Person person) {
        DBConnection.getInstance().registerUser(person);
    }

    @Override
    public void borrow(int clientID, int ISBM) {
        DBConnection.getInstance().borrowBook(ISBM, clientID);
    }

    @Override
    public void create(Book book) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
