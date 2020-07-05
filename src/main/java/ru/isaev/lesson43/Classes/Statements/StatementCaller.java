package ru.isaev.lesson43.Classes.Statements;

import ru.isaev.lesson43.Classes.SQLConnection.SqlConnection;
import ru.isaev.lesson43.Interfaces.ILoggable;

import java.rmi.ConnectIOException;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementCaller implements ILoggable {
    java.sql.Connection con;
    Statement stat;

    public StatementCaller(SqlConnection sqlCon, String username) throws ConnectIOException {
        try {
            con = sqlCon.getConnection(username);
            stat = con.createStatement();
        } catch (SQLException e) {
            LOGGER.trace("Can't get connection with " + username, e);
            throw new ConnectIOException("Connection is failed");
        }
    }

//    public ResultSet callResStat(StatementBuilder sb){
//        if (sb == null)
//
//        if (sb.isResultState())
//
//
//        ResultSet rs = stat.executeQuery(sb.getStatStr());
//        rs.close();
//        con.commit();
//        stat.close();
//
//        return rs;
//    }
//
//    public void callStat(StatementBuilder sb) {
//        if (sb == null)
//
//        if (!sb.isResultState())
//
//        try  {
//            stat.execute(sb.getStatStr());
//            con.commit();
//            stat.close();
//
//            ResultSet rs = null;
//            rs = stat.executeQuery(getSqlCommand());
//            while (rs.next()) {
//                System.out.println("Студент: " + rs.getString("FirstName") + " обучайющийся: "
//                        + rs.getString("Name") + ". Преподаватель: " + rs.getString("TeacherName"));
//            }
//
//            rs = st.executeQuery("SELECT days FROM courses");
//            while (rs.next()) {
//                int days = rs.getInt("days");
//                PreparedStatement ps = con.prepareStatement("UPDATE courses SET days = ? WHERE days = ?");
//                ps.setInt(2, days);
//                ps.setInt(1, --days);
//                ps.executeUpdate();
//            }
//            rs.close();
//
//        } catch (SQLException e) {
//            con.rollback();
//        }
//    }
}