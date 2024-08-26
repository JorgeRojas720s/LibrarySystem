package com.mycompany.lab;

public class Libraian extends Person implements Librarie {

    public Libraian(String name, int id) {
        super(name, id);
    }

    public void generateReport() {
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

    @Override
    public void requestAvailableBooks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
