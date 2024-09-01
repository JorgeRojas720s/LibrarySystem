/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab;
import java.util.Scanner;

/**
 *
 * @author igmml
 */
public class Program {
    void menu(){
        System.out.println("Bienvenido a bliblioteca Zierda");
        System.out.println("---------------------------------");
        System.out.println("1. Agregar cliente");
        System.out.println("2. Agregar libro");
        System.out.println("3. Prestar libro");
        System.out.println("4. Modificar libro");
        System.out.println("5. Eliminar libro");
        System.out.println("6. Generar reporte");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Opcion: ");
        int number = scanner.nextInt();
        scanner.close();
        selectOption(number);
        
    }
    
    void clientInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del cliente");
        
    }
    
    void selectOption(int opt){
        switch (opt) {
            case 1:
                
                break;
             case 2:
                
                break;
            case 3:
                
                break;
             case 4:
                
                break;
             case 5:
                
                break;
             case 6:
                
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}
