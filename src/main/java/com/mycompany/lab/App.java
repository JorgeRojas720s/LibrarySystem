package com.mycompany.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class 
 * 
 * @author Ismael Marchena Méndez
 * @author Jorge Rojas Mena
 * @author Fabian Arguedas León
 */

public class App extends Application {

    public static String[] main(String[] args) throws IOException{

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        
//        
//        int character = reader.read();
//
//        
        System.out.println("hola");
        Program prg = new Program();
        prg.menu();
        return null;
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
