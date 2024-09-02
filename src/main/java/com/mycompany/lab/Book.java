package com.mycompany.lab;

import java.util.ArrayList;

/**
 * The prinpincipal class for book handler
 * 
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */
public class Book implements Librarie {

    private ArrayList<Person> authors;
    private boolean available;
    private int ISBM;
    private String title;

    /**
     * Constructor of Boook.
     * 
     * @param name Title of the book
     * @param ISBM ISBM of the book.
     * @param available If the book is available.
     * @param authors The authors of the book.
     */
    public Book(String name, int ISBM, boolean available, 
            ArrayList<Person> authors) {
        this.ISBM = ISBM;
        this.title = name;
        this.available = available;
        this.authors = authors;
    }

    /**
     * Constructor of nook without author.
     * 
     * @param name Title of the book
     * @param ISBM ISBM of the book.
     * @param available If the book is available.
     */
    public Book(String name, int ISBM, boolean available) {
        this.ISBM = ISBM;
        this.title = name;
        this.available = available;
        this.authors = new ArrayList<>();
    }

    /**
     * Void Constructor.
     */
    public Book() {
        this.ISBM = 0;
        this.authors = new ArrayList<>();
        this.available = false;
        this.title = "";
    }

    /**
     * Update the information of a book in the database.
     */
    @Override
    public void update() {
        DBConnection.getInstance().updateBook(this);
    }

    /**
     * Delete a book from the database.
     * 
     * @param id ID of the book to delete.
     */
    @Override
    public void delete(int id) {
        DBConnection.getInstance().deleteBook(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getISBM() {
        return ISBM;
    }

    public void setISBM(int ISBM) {
        this.ISBM = ISBM;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ArrayList<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Person> authors) {
        this.authors = authors;
    }

    /**
     * Adds a book to the database.
     * 
     * @param book Book to add.
     */
    @Override
    public void create(Book book) {
        DBConnection.getInstance().createBook(book);
    }

    /**
     * Borroe a book to a client.
     * 
     * @param clientID Client ID.
     * @param ISBM ISMB of the book to be borrow.
     */
    @Override
    public void borrow(int clientID, int ISBM) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
