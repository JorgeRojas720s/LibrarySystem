package com.mycompany.lab;

import java.util.ArrayList;

public class Libraian extends Person implements Librarie {

    public Libraian(String name, int id, String role) {
        super(name, id, role);
    }

 

    public void generateReport() {
    }

    @Override
    public void borrow() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(String title, int ISBM, ArrayList<Person> author) {
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

    @Override
    public void registerPerson(Person person) {
        DBConnection.getInstance();
        DBConnection.getInstance().registerUser(person);
    }
}
