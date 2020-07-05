package ru.isaev.lesson43;

import ru.isaev.lesson43.Classes.Controller;
import ru.isaev.lesson43.Interfaces.IControllable;

public class Main {
    Controller library;

    {
        library = new Controller("org.postgresql.Driver");
        library.addConnection("postgres", "007", "jdbc:postgresql://localhost:5432/postgres");
        library.connectAll();
        library.saveConnections();
        library.createLibrary();
    }

    public static void main(String[] args) {
        IControllable librarian = new Main().library;
        librarian.viewAllBooks();
    }
}
