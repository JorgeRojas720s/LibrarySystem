package com.mycompany.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    static Scanner scanner;

    public Program() {
        this.scanner = new Scanner(System.in);
    }

    void menu() {
        int number = 0;
        while (number != 7) {
            System.out.println("Bienvenido a bliblioteca Zierda");
            System.out.println("---------------------------------");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Agregar libro");
            System.out.println("3. Prestar libro");
            System.out.println("4. Modificar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("6. Generar reporte");
            System.out.println("7. Salir");

            System.out.print("Opción: ");
            number = scanner.nextInt();
            selectOption(number);

            if (number != 7) {
                System.out.println("Presione Enter para continuar...");
                scanner.nextLine(); // Esperar a que el usuario presione Enter
            }
        }
        System.out.println("¡Gracias por usar la biblioteca Zierda!");
    }

    Person personInfo() {
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
        if (role == 1) {
            finalRole = "Client";
            person = new Client(name, id, finalRole);
        } else if (role == 2) {
            finalRole = "Author";
            person = new BookAuthor(name, id, finalRole);
        } else if (role == 3) {
            finalRole = "Worker";
            person = new Libraian(name, id, finalRole);
        } else {
            System.out.println("Opción no válida");
            return null;
        }
        return person;
    }

    Book bookInfo() {
        System.out.println("Ingrese el nombre del libro");
        String title = scanner.next();

        System.out.println("Ingrese el ISBM del libro");
        int ISBM = scanner.nextInt();
        
        System.out.println("Ingrese la cantidad de Autores");
        int numberAuthors  = scanner.nextInt();
        
        ArrayList<Person> authors = new ArrayList<>();
        
        for (int i = 0; i < numberAuthors; i++) {
            System.out.println("Ingrese la cédula del autor");
            int authorID = scanner.nextInt();
             System.out.println("Ingrese el nombre del autor");
            String authorName = scanner.next();
            Person author = new BookAuthor(authorName, authorID, "Author");
            authors.add(author);
        }
 
            
        Book book = new Book(title, ISBM, true, authors);
        book.setAvailable(true);
        return book;
    }

    public List<Integer> borrowBook() {
        System.out.println("Ingrese el ISBM del libro");
        int ISBM = scanner.nextInt();
        System.out.println("Ingrese la cédula del cliente");
        int clientID = scanner.nextInt();

        List<Integer> info = new ArrayList<>();
        info.add(ISBM);
        info.add(clientID);
        return info;
    }

    int bookISBM() {
        System.out.println("Ingrese el ISBM de libro a borrar");
        int ISBM = scanner.nextInt();
        return ISBM;
    }

    void printReport(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println("Título: " + book.getTitle() + " ISBM: " + book.getISBM());
            if( book.getAuthors() != null){
                System.out.println("Autores: " + book.getAuthors().toString());
            } 
        }
    }

    void selectOption(int opt) {
        switch (opt) {
            case 1: {
                Person person = personInfo();
                person.registerPerson(person);
            }
            break;
            case 2: {
                Book book = bookInfo();
                book.create(book);
            }
            break;
            case 3: {
                List<Integer> info = borrowBook();
                int clientID = info.get(1);
                int ISBM = info.get(0);
                Libraian librarian = new Libraian("", 0, "");
                librarian.borrow(clientID, ISBM);
            }
            break;
            case 4: {
                Book newBookInfo = bookInfo();
               // newBookInfo.create(newBookInfo.getTitle(), newBookInfo.getISBM(), newBookInfo.getAvailable());
            }
            break;
            case 5: {
                int ISBM = bookISBM();
                Book book = new Book("", ISBM, false);
                book.delete(ISBM);
            }
            break;
            case 6: {
                List<Book> bookList = DBConnection.getInstance().getBorrowBooks();
                printReport(bookList);
            }
            break;
            case 7:
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    void clearConsole() {
        // Simular la limpieza de la consola imprimiendo varias líneas vacías
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Program program = new Program();
        program.menu();
    }
}
