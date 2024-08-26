package com.mycompany.lab;

import java.util.ArrayList;

public interface Librarie {

    public void borrow();

    public void create(String title, int ISBM, ArrayList<Person> author);

    public void delete();

    public void update();
}
