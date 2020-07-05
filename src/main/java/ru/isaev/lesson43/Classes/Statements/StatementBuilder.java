package ru.isaev.lesson43.Classes.Statements;

public class StatementBuilder {
    private StringBuilder statStr = new StringBuilder();
    private boolean isResultState;

    public void reset() {
        statStr = new StringBuilder();
    }

    public void createTable(String tableName) {
        check();
        statStr.append(" CREATE TABLE ").append(tableName);
        statStr.append(" (ID SERIAL NOT NULL, ");
        statStr.append("PRIMARY KEY (ID));");
    }

    public void addTableConnect(String fromTableName, String toTableName) {
        check();
        statStr.append(" ALTER TABLE ").append(fromTableName).append(" ADD ");
        statStr.append(toTableName).append("ID INTEGER, ");
        statStr.append("ADD FOREIGN KEY (").append(toTableName).append("ID) ");
        statStr.append("REFERENCES ").append(toTableName).append(" (ID) MATCH SIMPLE");
        statStr.append(" ON UPDATE CASCADE");
        statStr.append(" ON DELETE SET NULL");
        statStr.append(";");
    }

    public void addIntColumn(String tableName, int defaults, String... name) {
        check();
        statStr.append(" ALTER TABLE ").append(tableName);
        for (String n : name) {
            statStr.append(" ADD ").append(n).append(" INTEGER DEFAULT ").append(defaults).append(", ");
        }
        int lastInd = statStr.length();
        statStr.delete(lastInd - 2, lastInd);
        statStr.append(";");
    }

    public void addStrColumn(String tableName, int size, String... name) {
        check();
        statStr.append(" ALTER TABLE ").append(tableName);
        for (String n : name) {
            statStr.append(" ADD ").append(n).append(" VARCHAR(").append(size).append(") NOT NULL,\n");
        }
        int lastInd = statStr.length();
        statStr.delete(lastInd - 2, lastInd);
        statStr.append(";");
    }

    public void insertTable(String tableName, String columnName, String... value) {
        check();
        statStr.append(" INSERT INTO ").append(tableName).append(" (").append(columnName).append(") VALUES (");
        for (String v : value) {
            statStr.append("'").append(v).append("' ,");
        }
        int lastInd = statStr.length();
        statStr.delete(lastInd - 1, lastInd);
        statStr.append(");");
    }

    public void selectTable(String columnsName, String tablesName, String orderBy, String... terms) {
        if (!isResultState) {
            reset();
            isResultState = true;
        }
        statStr.append(" SELECT ").append(columnsName).append(" FROM ").append(tablesName).append(" ");
        if (terms.length == 1) {
            for (String t : terms) {
                statStr.append(" WHERE ").append(t).append(" AND ");
            }
            int lastInd = statStr.length();
            statStr.delete(lastInd - 4, lastInd);
        }
        if (orderBy == null) return;
        statStr.append(" ORDER BY ").append(orderBy);
    }

    public void updateValue(String tablesName, String columnsName, String newValue, String oldValue) {
        check();
        statStr.append(" UPDATE ").append(tablesName).append(" SET ").append(columnsName).append(" = ").append(newValue);
        statStr.append(" WHERE ").append(columnsName).append(" = ").append(oldValue);
    }

    String getStatStr() {
        return statStr.toString();
    }

    boolean isResultState() {
        return isResultState;
    }

    private void check() {
        if (isResultState) {
            reset();
            isResultState = false;
        }
    }
}