package ru.isaev.lesson41;

import org.apache.log4j.Logger;

import java.sql.*;

public class PostgresSQL {
    static final Logger logger = Logger.getLogger(PostgresSQL.class);
    static final String jdbcDriver = "org.postgresql.Driver";
    static final String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    static final String user = "postgres";
    static final String password = "007";

    public static void main(String[] args) {
        try {
            Class.forName(jdbcDriver);
            ResultSet rs = null;
            try (Connection con = DriverManager.getConnection(dbUrl, user, password);
                 Statement st = con.createStatement()) {
                try {
                    st.execute("SELECT * FROM Teachers, Courses, Students");
                } catch (SQLException e) {
                    st.execute(getIniCode());
                }

                rs = st.executeQuery(getSQLcommand());
                while (rs.next()) {
                    System.out.println("Студент: " + rs.getString("FirstName") + " обучайющийся: " + rs.getString("Name") + ". Преподаватель: " + rs.getString("TeacherName"));
                }

                rs = st.executeQuery("SELECT days FROM courses");
                while (rs.next()) {
                    int days = rs.getInt("days");
                    PreparedStatement ps = con.prepareStatement("UPDATE courses SET days = ? WHERE days = ?");
                    ps.setInt(2, days);
                    ps.setInt(1, --days);
                    ps.executeUpdate();
                }
                rs.close();
            } finally {
                if (rs != null) {
                    if (!rs.isClosed())
                        rs.close();
                }
            }
        } catch (ClassNotFoundException e) {
            logger.trace("JDBCDriver is not found.", e);
        } catch (SQLException e) {
            logger.trace("DataBase Error.", e);
        }
    }

    private static String getIniCode() {
        return "CREATE TABLE Teachers" +
                "(" +
                "   ID serial NOT NULL," +
                "   FirstName character varying(50) NOT NULL," +
                "   LastName character varying(50) NOT NULL," +
                "   CONSTRAINT Teachers_pkey PRIMARY KEY (ID)" +
                ");" +
                "CREATE TABLE Courses" +
                "(" +
                "    ID serial NOT NULL," +
                "    Name character varying(100) NOT NULL," +
                "    Days integer DEFAULT 0," +
                "    TeacherID integer," +
                "    CONSTRAINT Course_pkey PRIMARY KEY (ID)," +
                "    CONSTRAINT Course_fkey FOREIGN KEY (TeacherID)" +
                "      REFERENCES Teachers (ID) MATCH SIMPLE" +
                "        ON UPDATE CASCADE" +
                "        ON DELETE SET NULL" +
                ");" +
                "CREATE TABLE Students" +
                "(" +
                "    ID serial NOT NULL," +
                "    FirstName character varying(50) NOT NULL," +
                "    LastName character varying(50) NOT NULL," +
                "CourseID integer," +
                "    CONSTRAINT Student_pkey PRIMARY KEY (ID)," +
                "    CONSTRAINT CourseID_fkey FOREIGN KEY (CourseID)" +
                "        REFERENCES Courses (ID) MATCH SIMPLE" +
                "        ON UPDATE CASCADE" +
                "        ON DELETE SET NULL" +
                ");" +
                "INSERT INTO Teachers (FirstName, LastName) VALUES" +
                "('Иван' ,'Иванов')," +
                "('Вася' ,'Василий');" +
                "INSERT INTO Courses (Name, Days, TeacherID) VALUES ('Курс промышленной разработки поплавков' , 30, 1);" +
                "INSERT INTO Students (FirstName, LastName, CourseID) VALUES" +
                "('No.1' , '1', 1)," +
                "('No.2' , '2', 1)," +
                "('No.3' , '3', 1)," +
                "('No.4' , '4', 1);";
    }

    private static String getSQLcommand() {
        return "SELECT students.FirstName, courses.Name, teachers.FirstName || ' ' || teachers.LastName AS TeacherName" +
                "                FROM students, courses, teachers" +
                "                WHERE students.CourseID = courses.ID" +
                "                AND courses.TeacherID = teachers.ID;";
    }
}