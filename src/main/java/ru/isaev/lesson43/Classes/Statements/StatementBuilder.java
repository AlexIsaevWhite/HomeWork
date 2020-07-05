package ru.isaev.lesson43.Classes.Statements;

public class StatementBuilder {
    private StringBuilder statStr = new StringBuilder();
    private boolean isResultState;

    /**
     * Сброс записей
     */
    public void reset() {
        statStr = new StringBuilder();
    }

    /**
     * Комманда на создание таблицы
     *
     * @param tableName имя таблицы
     */
    public void createTable(String tableName) {
        check();
        statStr.append(" CREATE TABLE ").append(tableName);
        statStr.append(" (ID SERIAL NOT NULL, ");
        statStr.append("PRIMARY KEY (ID));");
    }

    /**
     * Комманда на добавление в таблицу Freight Key к другой таблице
     *
     * @param fromTableName таблица, в которую будет помещен Freight key
     * @param toTableName   таблица, на которую будет ссылаться Freight key
     */
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

    /**
     * Команда на добавление столбцов Integer в таблицу
     *
     * @param tableName название таблицы
     * @param defaults  поля столбца по умолчанию
     * @param name      добавляемые столбцы
     */
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

    /**
     * Команда на добавление столбцов Varchar в таблицу
     *
     * @param tableName название таблицы
     * @param size      предельно допустимый размер полей
     * @param name      добавляемые столбцы
     */
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

    /**
     * Команда на заполнение полей таблицы
     *
     * @param tableName  название таблицы
     * @param columnName столбцы таблицы
     * @param value      значения, которые будут добавлены
     */
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

    /**
     * Запрос на предоставление данных с таблицы
     *
     * @param columnsName названия столбцов
     * @param tablesName  название таблиц
     * @param orderBy     условия сортировки
     * @param terms       условия фильтрации
     */
    public void selectTable(String columnsName, String tablesName, String orderBy, String... terms) {
        if (!isResultState) {
            reset();
            isResultState = true;
        }
        statStr.append(" SELECT ").append(columnsName).append(" FROM ").append(tablesName).append(" ");
        if (terms.length >= 1) {
            statStr.append(" WHERE ");
            for (String t : terms) {
                statStr.append(t).append(" AND ");
            }
            int lastInd = statStr.length();
            statStr.delete(lastInd - 4, lastInd);
        }
        if (orderBy == null) return;
        statStr.append(" ORDER BY ").append(orderBy);
    }

    /**
     * Команда на обновление значений таблицы
     *
     * @param tablesName  название таблицы
     * @param columnsName название столбца
     * @param newValue    новое значение
     * @param oldValue    старое значение
     */
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