package com.mycompany.lab;

/**
 * Represents a client in the librarie.
 * Extends the class person.
 * 
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */
public class Client extends Person {

    /**
     * Constructor of the class Client.
     * 
     * @param name Name of the client.
     * @param id ID of the client.
     * @param role Role of the client (client).
     */
    public Client(String name, int id, String role) {
        super(name, id, role);
    }

    /**
     * Request a book.
     */
    public void requestBook() {
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
