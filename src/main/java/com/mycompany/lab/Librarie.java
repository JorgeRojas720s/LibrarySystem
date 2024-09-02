package com.mycompany.lab;

/**
 * Interface that difines the basic functions of a librarie.
 * 
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */
public interface Librarie {

    /**
     * Borroe a book.
     * 
     * @param clientID Client ID.
     * @param ISBM ISBM of the book.
     */
    public void borrow(int clientID, int ISBM);

    /**
     * Add a book to the database.
     * 
     * @param book Book to be create.
     */
    public void create(Book book);

    /**
     * Delete the book from the database.
     * 
     * @param id ID of the book to be delete.
     */
    public void delete(int id);

    /**
     * Update a book.
     */
    public void update();
}
