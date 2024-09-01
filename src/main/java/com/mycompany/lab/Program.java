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
    static Scanner scanner;

    public Program() {
        this.scanner = new Scanner(System.in);
    }
    
    void menu(){
        System.out.println("Bienvenido a bliblioteca Zierda");
        System.out.println("---------------------------------");
        System.out.println("1. Agregar cliente");
        System.out.println("2. Agregar libro");
        System.out.println("3. Prestar libro");
        System.out.println("4. Modificar libro");
        System.out.println("5. Eliminar libro");
        System.out.println("6. Generar reporte");
        System.out.println("7. Salir");

        System.out.print("Opcion: ");
        int number = scanner.nextInt();

        selectOption(number);
        
    }
    
    Person personInfo(){
        System.out.println("Ingrese el nombre del cliente");
     
        String name = scanner.next();
        
        System.out.println("Ingrese la cédula del cliente");
        int id = scanner.nextInt();
        
        System.out.println("Seleccione el rol");
        System.out.println("1. Cliente");
        System.out.println("2. Autor");
        System.out.println("3. Worker");
        Person person;
        
        int role = scanner.nextInt();
        String finalRole = "";
        if(role == 1){
            finalRole = "Client";
            person = new Client(name, id, finalRole);
        }else if (role == 2){
            finalRole = "Author";
            person = new BookAuthor(name, id, finalRole);
        }else if (role == 3){
            finalRole = "Worker";
            person = new Libraian(name,id, finalRole);
        }else{
            System.out.println("Opción no válida");
            return null;
        }
        return person;
    }
    
    void selectOption(int opt){
        switch (opt) {
            case 1:
                Person person = personInfo();
                person.registerPerson(person);
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
