package com.mycompany.lab;

import java.util.ArrayList;

public class Book implements Librarie {

    private String title;

    private int ISBM;

    private boolean available;

    private ArrayList<Person> authors;

    public Book(String name, int ISBM, ArrayList author) {
        this.ISBM = ISBM;
        this.title = name;
        this.available = true;
        this.authors = author;
    }

    @Override
    public void borrow() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void create(String title, int ISBM, ArrayList<Person> author) {
        DBConnection.getInstance();
        DBConnection.getInstance().createBook(title, ISBM, true, author);
        
    }

    @Override
    public void delete() {
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

    public boolean isAvailable() {
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
    
}
