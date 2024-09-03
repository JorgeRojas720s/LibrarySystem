/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.lab;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author igmml
 */
public class BookTest {
    
    public BookTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of update method, of class Book.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Book instance = new Book();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class Book.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        Book instance = new Book();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class Book.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class Book.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        Book instance = new Book();
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getISBM method, of class Book.
     */
    @Test
    public void testGetISBM() {
        System.out.println("getISBM");
        Book instance = new Book();
        int expResult = 0;
        int result = instance.getISBM();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setISBM method, of class Book.
     */
    @Test
    public void testSetISBM() {
        System.out.println("setISBM");
        int ISBM = 0;
        Book instance = new Book();
        instance.setISBM(ISBM);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailable method, of class Book.
     */
    @Test
    public void testGetAvailable() {
        System.out.println("getAvailable");
        Book instance = new Book();
        boolean expResult = false;
        boolean result = instance.getAvailable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvailable method, of class Book.
     */
    @Test
    public void testSetAvailable() {
        System.out.println("setAvailable");
        boolean available = false;
        Book instance = new Book();
        instance.setAvailable(available);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthors method, of class Book.
     */
    @Test
    public void testGetAuthors() {
        System.out.println("getAuthors");
        Book instance = new Book();
        ArrayList<Person> expResult = null;
        ArrayList<Person> result = instance.getAuthors();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAuthors method, of class Book.
     */
    @Test
    public void testSetAuthors() {
        System.out.println("setAuthors");
        ArrayList<Person> authors = null;
        Book instance = new Book();
        instance.setAuthors(authors);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class Book.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Book book = null;
        Book instance = new Book();
        instance.create(book);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrow method, of class Book.
     */
    @Test
    public void testBorrow() {
        System.out.println("borrow");
        int clientID = 0;
        int ISBM = 0;
        Book instance = new Book();
        instance.borrow(clientID, ISBM);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
