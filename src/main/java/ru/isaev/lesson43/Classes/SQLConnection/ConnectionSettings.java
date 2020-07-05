package ru.isaev.lesson43.Classes.SQLConnection;

import java.io.Serializable;

public class ConnectionSettings implements Serializable {
    private final String password;
    private final String dbUrl;
    private java.sql.Connection connection;

    /**
     * Настройки соединения с базой данных
     *
     * @param password пароль для соединения
     * @param dbUrl    адрес БД
     */
    public ConnectionSettings(String password, String dbUrl) {
        this.password = password;
        this.dbUrl = dbUrl;
    }

    String password() {
        return password;
    }

    String dbUrl() {
        return dbUrl;
    }

    java.sql.Connection connection() {
        return connection;
    }

    void setConnection(java.sql.Connection connection) {
        this.connection = connection;
    }
}