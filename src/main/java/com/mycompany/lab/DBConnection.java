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
    
    public List<Book> getBorrowBooks(){
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

                if(book.isAvailable()){
                    bookList.add(book);
                }
            }

            resultados.close();
            statement.close();
            connection.close();

            return bookList;

        } catch (Exception e) {
            System.out.println("No sirve hp");
        }
        return null;
    }
}
