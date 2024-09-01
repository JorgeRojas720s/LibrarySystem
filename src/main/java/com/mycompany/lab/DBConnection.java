package com.mycompany.lab;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private static DBConnection instance = null;

    private Connection connection;

    private final String dbName = "librarie";

    public static synchronized DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public void connect(String dbName) {
        String url = "jdbc:mariadb://localhost:3306/" + dbName;
        String user = "root";
        String pass = "";

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

    public List<Book> getBorrowBooks() {
        try {
            connect("librarie");

            String consultation = "SELECT * FROM tbl_books";
            List<Book> bookList = new ArrayList<>();

            PreparedStatement statement = connection.prepareStatement(consultation);

            ResultSet resultados = statement.executeQuery();

            while (resultados.next()) {
                Book book = new Book();

                book.setTitle(resultados.getString("boo_title"));
                book.setISBM(resultados.getInt("boo_ISBM"));
                book.setAvailable(resultados.getBoolean("boo_available"));
                book.setAuthors(null);

                if (book.getAvailable()) {
                    bookList.add(book);
                }
            }

            resultados.close();
            statement.close();
            disconnect();

            return bookList;

        } catch (Exception e) {
            System.out.println("No se obtuvieron los libros");
        }
        return null;
    }

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

}
