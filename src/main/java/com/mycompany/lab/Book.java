package com.mycompany.lab;

import java.util.List;

public class Book implements Librarie {

    private String title;

    private int ISBM;

    private boolean available;

    private List<Person> authors;

    public Book(String name, int ISBM, boolean available) {
    }
    
    public Book() {
    }


    @Override
    public void borrow() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create() {
        throw new UnsupportedOperationException("Not supported yet.");
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

    public List<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Person> authors) {
        this.authors = authors;
    }
    
    
}
