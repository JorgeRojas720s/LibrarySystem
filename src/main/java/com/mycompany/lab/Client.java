package com.mycompany.lab;

public class Client extends Person {

    public Client(String name, int id) {
        super(name, id);
    }

    public void requestBook() {
    }

    public void returnBook() {
    }

    @Override
    public void requestAvailableBooks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
