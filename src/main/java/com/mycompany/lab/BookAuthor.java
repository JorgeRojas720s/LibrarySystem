package com.mycompany.lab;

/**
 * Representa a un autor de libros.
 * Extiende la clase Person.
 * 
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */
public class BookAuthor extends Person {

    /**
     * Constructor de la clase BookAuthor.
     * 
     * @param name El nombre del autor.
     * @param id El ID del autor.
     * @param role El rol del autor.
     */
    public BookAuthor(String name, int id, String role) {
        super(name, id, role);
    }

    /**
     * Método para que el autor escriba un libro (vacío).
     */
    public void write() {
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
