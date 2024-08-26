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
    
    public void createBook(String title, int ISBM, boolean available, ArrayList<Person> author){
        try {
            connect(dbName);
            String sql = "INSERT INTO tbl_books (boo_title, book_ISBM, boo_available) VALUES (?,?,?)";
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
}
