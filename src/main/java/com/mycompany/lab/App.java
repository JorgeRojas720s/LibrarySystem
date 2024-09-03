package com.mycompany.lab;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.application.Application;

import java.io.IOException;

import javafx.application.Application;

import java.io.IOException;

/**
 * Main class 
 * 
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */

/**
 * Main class of the system
 * 
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */
public class App extends Application {

    public static String[] main(String[] args) throws IOException{

        Program prg = new Program();
        prg.menu();
        return null;
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
