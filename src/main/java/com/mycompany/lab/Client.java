package com.mycompany.lab;

public class Client extends Person {

    public Client(String name, int id, String role) {
        super(name, id, role);
    }


    public void requestBook() {
    }

    public void returnBook() {
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
