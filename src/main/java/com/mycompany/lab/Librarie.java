package com.mycompany.lab;

import java.util.ArrayList;

public interface Librarie {

    public void borrow(int clientID, int ISBM);

    public void create(String title, int ISBM, ArrayList<Person> author);

    public void delete(int id);

    public void update();
}
