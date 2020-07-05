package ru.isaev.lesson43.Classes;


import ru.isaev.lesson43.Classes.SQLConnection.ConnectionSettings;
import ru.isaev.lesson43.Classes.SQLConnection.SettingsKeeper;
import ru.isaev.lesson43.Classes.SQLConnection.SqlConnection;
import ru.isaev.lesson43.Classes.Statements.StatementBuilder;
import ru.isaev.lesson43.Classes.Statements.StatementCaller;
import ru.isaev.lesson43.Interfaces.IControllable;
import ru.isaev.lesson43.Interfaces.ILoggable;

import java.rmi.ConnectIOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller implements IControllable, ILoggable {
    private final String booksTable = "Books";
    private final String booksColumn1 = "Author";
    private final String booksColumn2 = "NameBook";
    private final String booksColumn3 = "Amount";
    private final String readersTable = "Readers";
    private final String readersColumn1 = "FirstName";
    private final String readersColumn2 = "LastName";
    private final String registerTable = "Register";
    private final String registerColumn = "Taken";
    private final String allTables = booksTable + ", " + readersTable + ", " + registerTable;
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

    public void saveConnections() {
        SettingsKeeper.writeFile(sqlCon.jdbcDriver(), sqlCon);
    }

    public void createLibrary() {
        for (String activeUser : sqlCon.getActiveUsers()) {
            StatementCaller stCall = new StatementCaller(sqlCon, activeUser);
            StatementBuilder stBuild = new StatementBuilder();
            stBuild.selectTable("*", allTables, null);
            ResultSet rs = stCall.callResStat(stBuild);
            if (rs != null) return;
            createLibrary(stBuild, stCall);
        }
    }

    @Override
    public void viewAllBooks() {
        for (String activeUser : sqlCon.getActiveUsers()) {
            StatementCaller stCall = new StatementCaller(sqlCon, activeUser);
            StatementBuilder stBuild = new StatementBuilder();

            String columns = booksColumn2 + ", " + booksColumn1 + ", " + booksColumn3;
            stBuild.selectTable(columns, booksTable, booksColumn1, booksColumn3 + ">0");
            ResultSet rs = stCall.callResStat(stBuild);
            try {
                while (rs.next()) {
                    System.out.println("Книга: " + rs.getString(booksColumn2) + ". Автор: "
                            + rs.getString(booksColumn1) + ". Количество: " + rs.getInt(booksColumn3));
                }
            } catch (SQLException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

    @Override
    public void regNewReader(String firstName, String lastName) {
        //регистрировать новых читателей;
        for (String activeUser : sqlCon.getActiveUsers()) {
            StatementCaller stCall = new StatementCaller(sqlCon, activeUser);
            StatementBuilder stBuild = new StatementBuilder();

            stBuild.addIntColumn(registerTable, 0, registerColumn);
            stCall.callUpdStat(stBuild);
        }
    }

    @Override
    public void viewReaderBooks(String firstName, String lastName) {
        //- выводить список книг взятых каждым читателем;
    }

    @Override
    public void giveBook(String bookName, String firstName, String lastName) {
        //назначать книгу читателю
    }

    @Override
    public void getBook(String bookName, String firstName, String lastName) {
        //снимать с него книгу;
    }

    @Override
    public void viewBookInfo(String bookName) {
        //выводить статистику по количеству книг в наличии
    }

    @Override
    public void viewReaderInfo(String firstName, String lastName) {
        //на руках читателей
    }

    @Override
    public void viewAuthorInfo(String authorName) {
        // автора в отношении общего объема книг;
    }

    @Override
    public void searchBook(String bookName, String author) {
        //- искать книгу по названию/автору.
    }

    private void createLibrary(StatementBuilder stBuild, StatementCaller stCall) {
        stBuild.reset();
        stBuild.createTable(booksTable);
        stBuild.createTable(readersTable);
        stBuild.createTable(registerTable);
        stBuild.addStrColumn(booksTable, 50, booksColumn1, booksColumn2);
        stBuild.addIntColumn(booksTable, 10, booksColumn3);
        stBuild.addStrColumn(readersTable, 30, readersColumn1, readersColumn2);
        stBuild.addTableConnect(registerTable, booksTable);
        stBuild.addTableConnect(registerTable, readersTable);
        stBuild.addIntColumn(registerTable, 0, registerColumn);
        stCall.callUpdStat(stBuild);
        libraryFilling(stBuild, stCall);
    }

    private void libraryFilling(StatementBuilder stBuild, StatementCaller stCall) {
        stBuild.reset();
        String columnNames = booksColumn1 + ", " + booksColumn2 + ", " + booksColumn3;
        stBuild.insertTable(booksTable, columnNames, "Дж. Толкин", "Сильмариллион", "3");
        stBuild.insertTable(booksTable, columnNames, "Сунь-цзы", "Искусство войны", "5");
        stBuild.insertTable(booksTable, columnNames, "Андж. Сапковский", "Ведьмак", "10");
        stBuild.insertTable(booksTable, columnNames, "Кауталья или Вишнагупта", "Артхашастра", "4");
        stBuild.insertTable(booksTable, columnNames, "Шабад М.А.", "Расчеты релейной защиты", "7");
        stCall.callUpdStat(stBuild);
    }
}
