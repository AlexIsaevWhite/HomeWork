package ru.isaev.lesson43;

import ru.isaev.lesson43.Classes.Controller;
import ru.isaev.lesson43.Interfaces.IControllable;

import java.rmi.ConnectIOException;

public class Main {
    static final String jdbcDriver = "org.postgresql.Driver";
    static final String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    static final String user = "postgres";
    static final String password = "007";
    Controller library;

    {
        library = new Controller(jdbcDriver);
        library.addConnection(user, password, dbUrl);
        library.connectAll();
    }

    public static void main(String[] args) throws ConnectIOException {
        IControllable librarian = new Main().library;

    }

    //ДЗ 43. Программа Библиотека.
    //Написать программу “Библиотека” с использованием Базы Данных
    //Список книг (автор - название) (можно хранить )
    //программа должна:
    //- выводить список книг имеющихся в наличии, отсортированный по автору, и их количество;
    //- регистрировать новых читателей;
    //- выводить список книг взятых каждым читателем;
    //- назначать книгу читателю/снимать с него книгу;
    //- выводить статистику по количеству книг в наличии/на руках читателей, автора в отношении общего объема книг;
    //- искать книгу по названию/автору.
}
