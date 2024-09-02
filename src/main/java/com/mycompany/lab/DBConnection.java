package com.mycompany.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase para manejar la conexión a la base de datos.
 * Implementa el patrón de diseño Singleton para asegurar que solo haya una instancia de la conexión.
 * 
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */
public class DBConnection {

    private static DBConnection instance = null;
    private Connection connection;

    private final String dbName = "librarie";

    /**
     * Obtiene la instancia única de DBConnection.
     * 
     * @return La instancia única de DBConnection.
     */
    public static synchronized DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    /**
     * Establece la conexión a la base de datos.
     * 
     * @param dbName El nombre de la base de datos a conectar.
     */
    public void connect(String dbName) {
        String url = "jdbc:mariadb://localhost:3306/" + dbName;
        String user = "root";
        String pass = "0";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("CONECTADO!!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar el MariaDB JDBC Driver");
        }
    }

    /**
     * Cierra la conexión a la base de datos.
     */
    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("DESCONECTADO!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inserta un libro en la base de datos.
     * 
     * @param book El libro a insertar.
     */
    public void createBook(Book book) {
        try {
            connect(dbName);
            String sql = "INSERT INTO tbl_books (boo_title, boo_ISBM, boo_available) VALUES (?,?,?)";
            PreparedStatement insertStatement = connection.prepareStatement(sql);
            insertStatement.setString(1, book.getTitle());
            insertStatement.setInt(2, book.getISBM());
            insertStatement.setBoolean(3, book.getAvailable());

            insertStatement.executeUpdate();
            insertStatement.close();
            registerAuthors(book);
            bookXPersons(book);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("no guardó :(");
        }
        disconnect();
    }

    /**
     * Registra los autores de un libro en la base de datos.
     * 
     * @param book El libro cuyos autores se van a registrar.
     */
    public void registerAuthors(Book book) {
        try {
            String sql = "INSERT INTO tbl_person (per_name, per_id, per_role) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            for (Person person : book.getAuthors()) {

                statement.setString(1, person.getName());
                statement.setInt(2, person.getId());
                statement.setString(3, person.getRole());
                statement.executeUpdate();
            }

            statement.close();
        } catch (Exception e) {
            System.out.println("No se guardo el autor");
        }
    }

    /**
     * Inserta las relaciones entre libros y personas en la base de datos.
     * 
     * @param book El libro cuyos autores se van a relacionar.
     */
    public void bookXPersons(Book book) {

        try {
            String sql2 = "INSERT INTO tbl_books_x_persons (bxp_book_id, bxp_person_id) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql2);

            for (Person person : book.getAuthors()) {

                statement.setInt(1, book.getISBM());
                statement.setInt(2, person.getId());
                statement.executeUpdate();
            }
            statement.close();
        } catch (Exception e) {
            System.out.println("No se guardo en BooksXPeersons");
        }

    }

    /**
     * Obtiene una lista de los libros prestados.
     * 
     * @return Una lista de libros prestados.
     */
    public ArrayList<Book> getBorrowBooks() {
        try {
            connect("librarie");

            String bookQuery = "SELECT * FROM tbl_books";
            ArrayList<Book> bookList = new ArrayList<>();

            PreparedStatement bookStatement = connection.prepareStatement(bookQuery);
            ResultSet bookResults = bookStatement.executeQuery();

            while (bookResults.next()) {
                Book book = new Book();
                book.setTitle(bookResults.getString("boo_title"));
                book.setISBM(bookResults.getInt("boo_ISBM"));
                book.setAvailable(bookResults.getBoolean("boo_available"));

                // Obtener los autores para este libro
                ArrayList<Person> authors = getAuthorsForBook(book.getISBM());
                book.setAuthors(authors);

                if (book.getAvailable()) {
                    bookList.add(book);
                }
            }

            bookResults.close();
            bookStatement.close();
            disconnect();

            return bookList;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se obtuvieron los libros");
        }
        return null;
    }

    /**
     * Obtiene los autores para un libro específico.
     * 
     * @param bookISBM El ISBM del libro cuyo autor se quiere obtener.
     * @return Una lista de autores del libro.
     */
    private ArrayList<Person> getAuthorsForBook(int bookISBM) {
        ArrayList<Person> authors = new ArrayList<>();
        try {
            String authorQuery = "SELECT p.per_name, p.per_id, p.per_role FROM tbl_person p "
                    + "JOIN tbl_books_x_persons bxp ON p.per_id = bxp.bxp_person_id "
                    + "WHERE bxp.bxp_book_id = ?";

            PreparedStatement authorStatement = connection.prepareStatement(authorQuery);
            authorStatement.setInt(1, bookISBM);

            ResultSet authorResults = authorStatement.executeQuery();

            while (authorResults.next()) {
                Person author = new BookAuthor(authorResults.getString("per_name"),
                        authorResults.getInt("per_id"),
                        authorResults.getString("per_role"));
                authors.add(author);
            }

            authorResults.close();
            authorStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se obtuvieron los autores");
        }
        return authors;
    }

    /**
     * Registra un usuario en la base de datos.
     * 
     * @param person La persona (usuario) a registrar.
     */
    public void registerUser(Person person) {

        try {
            connect(dbName);

            String sql = "INSERT INTO tbl_person (per_name, per_id, per_role) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, person.getName());
            statement.setInt(2, person.getId());
            statement.setString(3, person.getRole());

            statement.executeUpdate();
            statement.close();
            disconnect();

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("No se guardo el user");
        }
    }

    /**
     * Presta un libro a un usuario.
     * 
     * @param bookId El ISBM del libro a prestar.
     * @param personId La cédula del usuario al que se le presta el libro.
     */
    public void borrowBook(int bookId, int personId) {
        try {
            connect(dbName);
            String sql = "INSERT INTO tbl_books_x_persons (bxp_book_id, bxp_person_id) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bookId);
            statement.setInt(2, personId);

            statement.executeUpdate();
            statement.close();
            disconnect();

            System.out.println("Libro prestado");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No prestado");
        }

    }

    /**
     * Actualiza la información de un libro en la base de datos.
     * 
     * @param book El libro con la información actualizada.
     */
    public void updateBook(Book book) {
        try {
            connect(dbName);
            String sql = "UPDATE tbl_books SET boo_title = ?, boo_available = ? WHERE boo_ISBM = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setBoolean(2, book.getAvailable());
            statement.setInt(3, book.getISBM());

            statement.executeUpdate();
            statement.close();
            disconnect();
            System.out.println("Libro actualizado exitosamente");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo actualizar el libro");
        }
    }

    /**
     * Elimina un libro de la base de datos.
     * 
     * @param id El ISBM del libro a eliminar.
     */
    public void deleteBook(int id) {
        try {
            connect(dbName);
            String sql = "DELETE FROM tbl_books WHERE boo_ISBM = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();
            disconnect();
            System.out.println("Libro eliminado exitosamente");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo eliminar el libro");
        }
    }

    /**
     * Elimina un cliente de la base de datos.
     * 
     * @param id La cédula del cliente a eliminar.
     */
    public void deleteClient(int id) {
        try {
            connect(dbName);
            String sql = "DELETE FROM tbl_person WHERE per_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();
            disconnect();
            System.out.println("Cliente eliminado exitosamente");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo eliminar el cliente");
        }
    }
}
