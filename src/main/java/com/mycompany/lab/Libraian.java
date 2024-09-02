package com.mycompany.lab;

import java.util.ArrayList;

/**
 * Representa a un bibliotecario.
 * Extiende la clase Person e implementa la interfaz Librarie.
 * 
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */
public class Libraian extends Person implements Librarie {

    /**
     * Constructor de la clase Libraian.
     * 
     * @param name El nombre del bibliotecario.
     * @param id El ID del bibliotecario.
     * @param role El rol del bibliotecario.
     */
    public Libraian(String name, int id, String role) {
        super(name, id, role);
    }

    /**
     * Genera un reporte de los libros que están disponibles con sus autores
     */
    public ArrayList generateReport() {
        DBConnection.getInstance();
        return DBConnection.getInstance().getBorrowBooks();
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update() {
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

    @Override
    public void borrow(int clientID, int ISBM) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Book book) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
