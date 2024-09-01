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
<<<<<<< HEAD
        String pass = "0";
=======
        String pass = "Zierda:33sql";
>>>>>>> db4ffb6f5b6c3cb50337136ff95a2ee890be3e05
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
    
    public void createBook(String title, int ISBM, boolean available, ArrayList<Person> author){
        try {
            connect(dbName);
            String sql = "INSERT INTO tbl_books (boo_title, boo_ISBM, boo_available) VALUES (?,?,?)";
            PreparedStatement insertStatement = connection.prepareStatement(sql);
            insertStatement.setString(1, title);
            insertStatement.setInt(2, ISBM);
            insertStatement.setBoolean(3, available);
            
            
            String checkSql = "SELECT per_id FROM tbl_person WHERE per_id = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkSql);
            checkStatement.setInt(1, author.get(0).getId());
            ResultSet resultSet = checkStatement.executeQuery();
            
            if(resultSet != null){
                while(resultSet.next()){
                    insertStatement.setInt(4, resultSet.getInt("per_id"));
                    break;
                }
            }
            
            insertStatement.executeUpdate();
            insertStatement.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("no guardó :(");
        }
        disconnect();
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
            disconnect();

            return bookList;

        } catch (Exception e) {
            System.out.println("No sirve hp");
        }
        return null;
    }
    
    public void registerUser(Person person){
    
    try { connect(dbName);
    
        String sql = "INSERT INTO tbl_person (per_name, per_id, per_role) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, person.getName());
        statement.setInt(2, person.getId());
        statement.setString(3, person.getRole());
        
        statement.executeUpdate();
        statement.close();
        disconnect();
    
    }catch(Exception e){
        
          e.printStackTrace();
            System.out.println("No se guardo el user");
    }
    }
}
