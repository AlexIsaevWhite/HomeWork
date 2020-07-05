package ru.isaev.lesson43.Classes.SQLConnection;

import ru.isaev.lesson43.Interfaces.ILoggable;

import java.io.Serializable;
import java.rmi.ConnectIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SqlConnection implements Serializable, ILoggable {
    private Map<String, ConnectionSettings> connections;
    private final String jdbcDriver;

    /**
     * Объект SQL соеднения, хранящий в себе логины и пароли соединения через jdbcDriver
     *
     * @param jdbcDriver драйвер, через который осуществляется соединение с БД
     * @throws ConnectIOException Исключение, которое выбрасывается при неправильном подключении к драйверу
     */
    public SqlConnection(String jdbcDriver) throws ConnectIOException {
        if (jdbcDriver == null) {
            throw new ConnectIOException("JDBC Driver is null. Connection is failed");
        }
        try {
            Class.forName(jdbcDriver);
            connections = new HashMap<>();
            this.jdbcDriver = jdbcDriver;
        } catch (ClassNotFoundException e) {
            throw new ConnectIOException("JDBC Driver Error. Connection is failed", e);
        }
    }

    /**
     * Возвращаемое значение используемого драйвера
     *
     * @return драйвер, который был задан при содзании объекта SQLConnection
     */
    public String jdbcDriver() {
        return jdbcDriver;
    }

    /**
     * Добавление настроек соединения с JDBCDriver
     *
     * @param username           имя пользователя
     * @param connectionSettings объект, хранящий в себе настройки соединения для данного пользователя
     */
    public void addConnection(String username, ConnectionSettings connectionSettings) {
        if (username == null || connectionSettings == null) {
            LOGGER.warn("Username or ConnectionOption is null");
            return;
        }
        connections.put(username, connectionSettings);
    }

    /**
     * Удаление настроек соединения
     *
     * @param username пользователь, чьи данные будут удалены
     */
    public void delConnection(String username) {
        if (username == null) {
            LOGGER.warn("Username is null");
            return;
        }
        connections.remove(username);
    }

    /**
     * Попытка соединения со всеми незадействованными подключениями
     */
    public void connectAll() {
        for (Map.Entry<String, ConnectionSettings> c : connections.entrySet()) {
            try {
                ConnectionSettings co = c.getValue();
                if (co.connection() == null || co.connection().isClosed()) {
                    co.setConnection(DriverManager.getConnection(co.dbUrl(), c.getKey(), co.password()));
                    co.connection().setAutoCommit(false);
                    co.connection().setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                }
            } catch (SQLException e) {
                LOGGER.warn("Invalid connection option", e);
            }
        }
    }

    /**
     * Закрытие всех соединений
     */
    public void closeAll() {
        connections.keySet().forEach(this::closeConnect);
    }

    /**
     * Выдача объекта работающего подключения к БД для запросов SQL
     *
     * @param username имя пользователя
     * @return работающее подключение к БД
     */
    public java.sql.Connection getConnection(String username) {
        if (username == null) {
            LOGGER.warn("Username is null");
            return null;
        }
        java.sql.Connection con = connections.get(username).connection();
        try {
            if (con.isClosed()) {
                LOGGER.warn("Get connection when connection is closed");
                return null;
            } else return con;
        } catch (SQLException e) {
            LOGGER.warn("Database access error", e);
        }
        return null;
    }

    /**
     * Закрытие определенного подключения
     *
     * @param username имя пользователя, для которого подключенние будет разорвано
     */
    public void closeConnect(String username) {
        if (username == null) {
            LOGGER.warn("Username is null");
            return;
        }
        try {
            ConnectionSettings co = connections.get(username);
            if (!co.connection().isClosed()) {
                co.connection().close();
            }
            co.setConnection(null);
        } catch (SQLException e) {
            LOGGER.warn("Database access error", e);
        }
    }

    /**
     * Запрос на предоставление списка активных пользователей
     *
     * @return список активных пользователей
     */
    public Set<String> getActiveUsers() {
        Set<String> userNames = new HashSet<>();
        for (Map.Entry<String, ConnectionSettings> c : connections.entrySet()) {
            try {
                if (!c.getValue().connection().isClosed()) {
                    userNames.add(c.getKey());
                }
            } catch (SQLException e) {
                LOGGER.warn("Database access error with username: " + c.getKey());
            }
        }
        return userNames;
    }

    SqlConnection getCopy() {
        try {
            SqlConnection clone = new SqlConnection(jdbcDriver);
            for (Map.Entry<String, ConnectionSettings> c : connections.entrySet()) {
                ConnectionSettings orig = c.getValue();
                ConnectionSettings cloneSettings = new ConnectionSettings(orig.password(), orig.dbUrl());
                clone.addConnection(c.getKey(), cloneSettings);
            }
            return clone;
        } catch (ConnectIOException e) {
            LOGGER.trace(e.getMessage(), e);
        }
        return null;
    }
}