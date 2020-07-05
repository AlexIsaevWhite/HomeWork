package ru.isaev.lesson43.Classes.Statements;

public class StatementBuilder {
    private StringBuilder statStr = new StringBuilder();
    private boolean isResultState;

    public boolean isResultState() {
        return isResultState;
    }

    public void reset() {
        statStr = new StringBuilder();
    }

    public void createTable(String tableName) {
        check();
        statStr.append("CREATE TABLE ").append(tableName);
        statStr.append(" (ID SERIAL NOT NULL, ");
        statStr.append("CONSTRAINT ").append(tableName).append("_pkey PRIMARY KEY (ID))");
    }

    public void addTableConnect(String inTableName, String toTableName) {
        check();
        statStr.append("ALTER TABLE ").append(inTableName).append(" ADD (");
        statStr.append(toTableName).append("ID INTEGER, ");
        statStr.append("CONSTRAINT ").append(inTableName).append("_fkey FOREIGN KEY (").append(toTableName).append("ID) ");
        statStr.append("REFERENCES ").append(toTableName).append(" (ID) MATCH SIMPLE");
        statStr.append(" ON UPDATE CASCADE");
        statStr.append(" ON DELETE SET NULL");
        statStr.append(");");
    }

    public void alterTable(String tableName, int defaults, int... name) {
        check();
        statStr.append("ALTER TABLE ").append(tableName).append(" ADD (");
        for (int n : name) {
            statStr.append(n).append(" INTEGER DEFAULT ").append(defaults).append(",\n");
        }
        int lastInd = statStr.length();
        statStr.delete(lastInd - 2, lastInd);
        statStr.append(");");
    }

    public void alterTable(String tableName, String... name) {
        check();
        statStr.append("ALTER TABLE ").append(tableName).append(" ADD (");
        for (String n : name) {
            int length = n.length() + 3;
            statStr.append(n).append(" VARCHAR(").append(length).append(") NOT NULL,\n");
        }
        int lastInd = statStr.length();
        statStr.delete(lastInd - 2, lastInd);
        statStr.append(");");
    }

    public void insertTable(String tableName, String columnName, String value) {
        check();
        statStr.append("INSERT INTO ").append(tableName).append(" (").append(columnName).append(") VALUES ");
        statStr.append("('").append(value).append("')");
    }

    public void insertTable(String tableName, String columnName, int value) {
        check();
        statStr.append("INSERT INTO ").append(tableName).append(" (").append(columnName).append(") VALUES ");
        statStr.append("('").append(value).append("')");
    }

    public void selectTable(String columnsName, String tablesName, String... terms) {
        if (!isResultState) reset();
        isResultState = true;
        statStr.append("SELECT ").append(columnsName).append(" FROM ").append(tablesName).append(" ");
        for (String t : terms) {
            statStr.append(" WHERE ").append(t).append(" AND ");
        }
        int lastInd = statStr.length();
        statStr.delete(lastInd - 4, lastInd);
    }

    public void updateValue(String tablesName, String columnsName, String newValue, String oldValue) {
        check();
        statStr.append("UPDATE ").append(tablesName).append(" SET ").append(columnsName).append(" = ").append(newValue);
        statStr.append(" WHERE ").append(columnsName).append(" = ").append(oldValue);
    }

    public String getStatStr() {
        return statStr.toString();
    }

    private void check() {
        if (isResultState) reset();
        isResultState = false;
    }
}