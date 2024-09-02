package com.mycompany.lab;

import java.util.ArrayList;

/**
 * Representa un libro en la biblioteca.
 * Implementa la interfaz Librarie.
 * 
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */
public class Book implements Librarie {

    private String title;
    private int ISBM;
    private boolean available;
    private ArrayList<Person> authors;

    /**
     * Constructor de la clase Book.
     * 
     * @param name El título del libro.
     * @param ISBM El número ISBM del libro.
     * @param available La disponibilidad del libro.
     * @param authors La lista de autores del libro.
     */
    public Book(String name, int ISBM, boolean available, ArrayList<Person> authors) {
        this.ISBM = ISBM;
        this.title = name;
        this.available = available;
        this.authors = authors;
    }

    /**
     * Constructor de la clase Book sin lista de autores.
     * 
     * @param name El título del libro.
     * @param ISBM El número ISBM del libro.
     * @param available La disponibilidad del libro.
     */
    public Book(String name, int ISBM, boolean available) {
        this.ISBM = ISBM;
        this.title = name;
        this.available = available;
        this.authors = new ArrayList<>();
    }

    /**
     * Constructor vacío de la clase Book.
     */
    public Book() {
        this.ISBM = 0;
        this.authors = new ArrayList<>();
        this.available = false;
        this.title = "";
    }

    /**
     * Actualiza el libro en la base de datos.
     */
    @Override
    public void update() {
        DBConnection.getInstance().updateBook(this);
    }

    /**
     * Elimina el libro de la base de datos.
     * 
     * @param id El ID del libro a eliminar.
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
     * Crea un nuevo libro en la base de datos.
     * 
     * @param book El libro a crear.
     */
    @Override
    public void create(Book book) {
        DBConnection.getInstance().createBook(book);
    }

    /**
     * Presta un libro al cliente.
     * 
     * @param clientID El ID del cliente.
     * @param ISBM El número ISBM del libro.
     */
    @Override
    public void borrow(int clientID, int ISBM) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
