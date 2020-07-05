package ru.isaev.lesson43.Classes.Statements;

import ru.isaev.lesson43.Classes.SQLConnection.SqlConnection;
import ru.isaev.lesson43.Interfaces.ILoggable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementCaller implements ILoggable {
    java.sql.Connection con;
    Statement stat;

    /**
     * Объект осуществления отдачи SQL команд БД
     *
     * @param sqlCon   соединение, через которое будет осуществляться отдача команд
     * @param username имя пользователя, от лица которого будут отправляться команды
     */
    public StatementCaller(SqlConnection sqlCon, String username) {
        con = sqlCon.getConnection(username);
        try {
            stat = con.createStatement();
        } catch (SQLException e) {
            LOGGER.trace(e.getMessage());
        }
    }

    /**
     * Отправка запроса с получение результата
     *
     * @param sb принимаемый объект StatementBuilder с собранными внутри командами
     * @return результат запроса
     */
    public ResultSet callResStat(StatementBuilder sb) {
        if (sb == null) {
            LOGGER.warn("StatementBuilder is null");
            return null;
        }
        if (!sb.isResultState()) {
            LOGGER.warn("Statement is not result");
            return null;
        }
        try {
            try {
                ResultSet rs = stat.executeQuery(sb.getStatStr());
                con.commit();
                return rs;
            } catch (SQLException e) {
                con.rollback();
                throw e;
            }
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
        return null;
    }

    /**
     * Отправка запроса на изменение содержимого БД
     *
     * @param sb принимаемый объект StatementBuilder с собранными внутри командами
     */
    public void callUpdStat(StatementBuilder sb) {
        if (sb == null) {
            LOGGER.warn("StatementBuilder is null");
            return;
        }
        if (sb.isResultState()) {
            LOGGER.warn("Statement is not action");
            return;
        }
        try {
            try {
                stat.executeUpdate(sb.getStatStr());
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                throw e;
            }
        } catch (SQLException e) {
            LOGGER.trace("Database access error", e);
        }
    }
}