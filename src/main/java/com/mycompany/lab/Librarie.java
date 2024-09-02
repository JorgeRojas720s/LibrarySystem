package com.mycompany.lab;

/**
 * Interfaz que define las operaciones para gestionar libros en la biblioteca.
 * 
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */
public interface Librarie {

    /**
     * Presta un libro a un cliente.
     * 
     * @param clientID El ID del cliente.
     * @param ISBM El número ISBM del libro.
     */
    public void borrow(int clientID, int ISBM);

    /**
     * Crea un libro en la base de datos.
     * 
     * @param book El libro a crear.
     */
    public void create(Book book);

    /**
     * Elimina un libro de la base de datos.
     * 
     * @param id El ID del libro a eliminar.
     */
    public void delete(int id);

    /**
     * Actualiza un libro en la base de datos.
     */
    public void update();
}
