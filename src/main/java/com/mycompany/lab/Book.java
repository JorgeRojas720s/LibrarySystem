package com.mycompany.lab;

public class Book implements Librarie {

    private String title;

    private int ISBM;

    private boolean available;

    private Person[] authors;

    public Book(String name, int ISBM, boolean available) {
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
}
