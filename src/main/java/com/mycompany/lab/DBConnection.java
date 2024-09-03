package com.mycompany.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class to handle the Database connection. Imprements Singleton for make sure
 * theres only one instace of the Database.
 *
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */
public class DBConnection {

    private Connection connection;
    private static DBConnection instance = null;
    private final String dbName = "librarie";

    /**
     * Obtains the instace of the class DBConnection.
     *
     * @return Return the instance of the class DBConnection.
     */
    public static synchronized DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    /**
     * Start the connection to the database.
     *
     * @param dbName Name of the database to be connect.
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
            System.out.println("Error, no se ha podido "
                    + "cargar el MariaDB JDBC Driver");
        }
    }

    /**
     * Close the connection of the database.
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
     * Insert the book to the database.
     *
     * @param book The book to be insert.
     */
    public void createBook(Book book) {
        try {
            connect(dbName);
            String sql = "INSERT INTO tbl_books (boo_title,"
                    + " boo_ISBM, boo_available) VALUES (?,?,?)";
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
     * Register an author to the database.
     *
     * @param book The book of the author to be save.
     */
    public void registerAuthors(Book book) {
        try {
            String sql = "INSERT INTO tbl_person (per_name, per_id, per_role)"
                    + " VALUES (?,?,?)";
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
     * Insert the relation of the books with persons.
     *
     * @param book Book of the author to realation.
     */
    public void bookXPersons(Book book) {

        try {
            String sql2 = "INSERT INTO tbl_books_x_persons (bxp_book_id,"
                    + " bxp_person_id) VALUES (?, ?)";
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
     * Obtain the list of the books that are available.
     *
     * @return Return a list of the available books.
     */
    public ArrayList<Book> getBorrowBooks() {
        try {
            connect("librarie");

            String bookQuery = "SELECT * FROM tbl_books where boo_available = 1";
            ArrayList<Book> bookList = new ArrayList<>();

            PreparedStatement bookStatement
                    = connection.prepareStatement(bookQuery);
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
     * Obtains the author of a book.
     *
     * @param bookISBM ISBM of the book.
     * @return List of the authors.
     */
    private ArrayList<Person> getAuthorsForBook(int bookISBM) {
        ArrayList<Person> authors = new ArrayList<>();
        try {
            String authorQuery = "SELECT p.per_name, p.per_id, p.per_role "
                    + "FROM tbl_person p "
                    + "JOIN tbl_books_x_persons bxp ON p.per_id = "
                    + "bxp.bxp_person_id "
                    + "WHERE bxp.bxp_book_id = ?";

            PreparedStatement authorStatement
                    = connection.prepareStatement(authorQuery);
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
     * Register an user in the database.
     *
     * @param person The person to be register.
     */
    public void registerUser(Person person) {

        try {
            connect(dbName);

            String sql = "INSERT INTO tbl_person (per_name, per_id, per_role) "
                    + "VALUES (?,?,?)";
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
     * Borrow a book to a person.
     *
     * @param bookId ISBM of the book to be borrow.
     * @param personId ID of the user that is asking for the book.
     */
    public void borrowBook(int bookId, int personId) {
        try {
            connect(dbName);
            String sql = "INSERT INTO tbl_books_x_persons (bxp_book_id,"
                    + " bxp_person_id) VALUES (?, ?)";
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
     * Update the information of a book in the database.
     *
     * @param book The book to be update.
     */
    public void updateBook(Book book) {
        try {
            connect(dbName);
            String sql = "UPDATE tbl_books SET boo_title = ?, boo_available"
                    + " = ? WHERE boo_ISBM = ?";
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
 * Delete the relation of the book from the table book_x_person
 * @param id 
 */
    public void deleteBookXPerson(int id) {
        try {
            connect(dbName);
            String deleteRelationsSQL = "DELETE FROM tbl_books_x_persons WHERE bxp_book_id = ?";
            PreparedStatement deleteRelationsStatement = connection.prepareStatement(deleteRelationsSQL);
            deleteRelationsStatement.setInt(1, id);
            deleteRelationsStatement.executeUpdate();
            deleteRelationsStatement.close();

            disconnect();
            System.out.println("Relaciones eliminadas exitosamente");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo eliminar las relaciones");
        }
    }

    /**
     * Delete a book from the database and there relation whith person.
     *
     * @param id ISBM of the book to be delete.
     */
    public void deleteBook(int id) {
        try {
            connect(dbName);
            String deleteBookSQL = "DELETE FROM tbl_books WHERE boo_ISBM = ?";
            PreparedStatement deleteBookStatement = connection.prepareStatement(deleteBookSQL);
            deleteBookStatement.setInt(1, id);
            deleteBookStatement.executeUpdate();
            deleteBookStatement.close();

            disconnect();
            System.out.println("Libro eliminado exitosamente");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo eliminar el libro");
        }
    }

    /**
     * Delete a person from the database.
     *
     * @param id id of the person to be delete.
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
