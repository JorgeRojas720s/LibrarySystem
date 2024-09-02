package com.mycompany.lab;

/**
 * Representa una persona en la biblioteca (cliente, autor o trabajador).
 * 
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */
public abstract class Person {

    protected String name;
    protected int id;
    protected Book[] books;
    protected String role;

    /**
     * Constructor de la clase Person.
     * 
     * @param name El nombre de la persona.
     * @param id El ID de la persona.
     * @param role El rol de la persona (cliente, autor, trabajador).
     */
    public Person(String name, int id, String role) {
        this.name = name;
        this.id = id;
        this.role = role;
    }

    /**
     * Solicita los libros disponibles en la biblioteca.
     */
    public abstract void requestAvailableBooks();

    /**
     * Registra una persona en la base de datos.
     * 
     * @param person La persona a registrar.
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
