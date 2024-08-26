package com.mycompany.lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    public static String[] main(String[] args) {
        System.out.println("hola");
        
        ArrayList author = new <Person>ArrayList(); 
        author.add(new BookAuthor("Jorge", 1));
        
        Book book = new Book("hola", 12, author);
        book.create(book.getTitle(), book.getISBM(), author);

        List<Book> list = DBConnection.getInstance().getBorrowBooks();
        
        return null;
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
