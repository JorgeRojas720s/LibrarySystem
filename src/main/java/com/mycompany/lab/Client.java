package com.mycompany.lab;

/**
 * Representa a un cliente de la biblioteca.
 * Extiende la clase Person.
 * 
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */
public class Client extends Person {

    /**
     * Constructor de la clase Client.
     * 
     * @param name El nombre del cliente.
     * @param id El ID del cliente.
     * @param role El rol del cliente.
     */
    public Client(String name, int id, String role) {
        super(name, id, role);
    }

    /**
     * Solicita un libro (vacío).
     */
    public void requestBook() {
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
