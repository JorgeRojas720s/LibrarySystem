package com.mycompany.lab;

public class BookAuthor extends Person {

    public BookAuthor(String name, int id) {
        super(name, id);
    }

    public void write() {
    }

    @Override
    public void requestAvailableBooks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
