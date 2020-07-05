package ru.isaev.lesson43.Classes;


import ru.isaev.lesson43.Classes.SQLConnection.ConnectionSettings;
import ru.isaev.lesson43.Classes.SQLConnection.SettingsKeeper;
import ru.isaev.lesson43.Classes.SQLConnection.SqlConnection;
import ru.isaev.lesson43.Interfaces.IControllable;
import ru.isaev.lesson43.Interfaces.ILoggable;

import java.rmi.ConnectIOException;

public class Controller implements IControllable, ILoggable {
    private SqlConnection sqlCon;

    public Controller(String jdbcDriver) {
        sqlCon = SettingsKeeper.readFile(jdbcDriver);
        if (sqlCon == null) {
            try {
                sqlCon = new SqlConnection(jdbcDriver);
                SettingsKeeper.writeFile(jdbcDriver, sqlCon);
            } catch (ConnectIOException e) {
                LOGGER.trace(e.getMessage(), e);
            }
        }
    }

    public void addConnection(String username, String password, String dbUrl) {
        sqlCon.addConnection(username, new ConnectionSettings(password, dbUrl));
    }

    public void connectAll() {
        sqlCon.connectAll();
    }
}
