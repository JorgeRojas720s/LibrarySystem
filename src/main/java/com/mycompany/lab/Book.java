package com.mycompany.lab;
import java.util.ArrayList;
import java.util.List;

public class Book implements Librarie {

    private String title;

    private int ISBM;

    private boolean available;
    
    private ArrayList<Person> authors;

    public Book(String name, int ISBM, boolean available, ArrayList<Person> authors) {
        this.ISBM = ISBM;
        this.title = name;
        this.available = true;
        this.authors = authors;
    }
    
    public Book(String name, int ISBM, boolean available) {
        this.ISBM = ISBM;
        this.title = name;
        this.available = true;

    }
    
    public Book() {
    }


    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
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



    @Override
    public void create(Book book) {
        DBConnection.getInstance();
        DBConnection.getInstance().createBook(book);
    }

    @Override
    public void borrow(int clientID, int ISBM) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
