package com.mycompany.lab;

import java.util.ArrayList;

public class Libraian extends Person implements Librarie {

    public Libraian(String name, int id, String role) {
        super(name, id, role);
    }

 

    public void generateReport() {
    }

  
    @Override
    public void delete(int id) {
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

    @Override
    public void borrow(int clientID, int ISBM) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
}
