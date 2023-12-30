package src.Services;

import java.sql.ResultSet;

public class QueryBuilderService {
    private StringBuilder sqlQuery;

    public QueryBuilderService() {
        this.sqlQuery = new StringBuilder();
    }

    public QueryBuilderService select() {
        sqlQuery.append("SELECT ");
        return this;
    }

    public QueryBuilderService all() {
        sqlQuery.append("* ");
        return this;
    }

    public QueryBuilderService from() {
        sqlQuery.append("FROM ");
        return this;
    }

    public QueryBuilderService table(String tableName) {
        sqlQuery.append(tableName).append(" ");
        return this;
    }

    public QueryBuilderService where(String condition) {
        if (condition != null && !condition.isEmpty()) {
            sqlQuery.append("WHERE ").append(condition).append(" ");
        } else if (condition != null && condition.isEmpty()) {
            sqlQuery.append("WHERE ");
        }
        return this;
    }

    public QueryBuilderService insert() {
        sqlQuery.append("INSERT INTO ");
        return this;
    }

    public QueryBuilderService into(String tableName) {
        sqlQuery.append("INTO ").append(tableName).append(" ");
        return this;
    }

    public QueryBuilderService update(String tableName) {
        sqlQuery.append("UPDATE ").append(tableName).append(" ");
        return this;
    }

    public QueryBuilderService set(String setValues) {
        sqlQuery.append("SET ").append(setValues).append(" ");
        return this;
    }

    public QueryBuilderService delete() {
        sqlQuery.append("DELETE ");
        return this;
    }

    public QueryBuilderService fromTable(String tableName) {
        sqlQuery.append("FROM ").append(tableName).append(" ");
        return this;
    }

    public QueryBuilderService orderBy(String orderBy) {
        sqlQuery.append("ORDER BY ").append(orderBy).append(" ");
        return this;
    }

    public QueryBuilderService groupBy(String groupBy) {
        sqlQuery.append("GROUP BY ").append(groupBy).append(" ");
        return this;
    }

    public QueryBuilderService count(String columnName) {
        sqlQuery.append("COUNT(").append(columnName).append(") ");
        return this;
    }

    public QueryBuilderService min(String columnName) {
        sqlQuery.append("MIN(").append(columnName).append(") ");
        return this;
    }

    public QueryBuilderService max(String columnName) {
        sqlQuery.append("MAX(").append(columnName).append(") ");
        return this;
    }

    public QueryBuilderService sum(String columnName) {
        sqlQuery.append("SUM(").append(columnName).append(") ");
        return this;
    }

    public QueryBuilderService avg(String columnName) {
        sqlQuery.append("AVG(").append(columnName).append(") ");
        return this;
    }

    public QueryBuilderService contains(String columnName, String value) {
        sqlQuery.append(columnName).append(" LIKE '%").append(value).append("%' ");
        return this;
    }

    public QueryBuilderService timestamp(String columnName, String operator, String timestampValue) {
        sqlQuery.append(columnName).append(" ").append(operator).append(" '").append(timestampValue).append("' ");
        return this;
    }

    /*
    when using the create table command remember to us the use the 
    close comand at the end before the build or the run quries
    */
    public QueryBuilderService createTable(String tableName) {
        sqlQuery.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (");
        return this;
    }

    public QueryBuilderService column(String columnName) {
        sqlQuery.append(columnName).append(" ");
        return this;
    }

    public QueryBuilderService insertInto(String tableName) {
        sqlQuery.append("INSERT INTO ").append(tableName).append(" ");
        return this;
    }

    public QueryBuilderService columns(String columns) {
        sqlQuery.append("(").append(columns).append(") ");
        return this;
    }
    
    public QueryBuilderService addUniqueConstraint(String columnName) {
        sqlQuery.append("ADD CONSTRAINT UNIQUE (").append(columnName).append(") ");
        return this;
    }
    public QueryBuilderService alterTable(String tableName) {
        sqlQuery.append("ALTER TABLE ").append(tableName).append(" ");
        return this;
    }

    public QueryBuilderService values(String... values) {
        sqlQuery.append("VALUES (");

        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                sqlQuery.append(", ");
            }
            sqlQuery.append(values[i]);
        }

        sqlQuery.append(") ");
        return this;
    }

    public QueryBuilderService createDatabase(String databaseName) {
        sqlQuery.append("CREATE DATABASE IF NOT EXISTS ").append(databaseName).append(";");
        return this;
    }

    public QueryBuilderService useDatabase(String databaseName) {
        sqlQuery.append("USE ").append(databaseName).append(";");
        return this;
    }

    public QueryBuilderService varchar(int length) {
        sqlQuery.append("VARCHAR(").append(length).append(") ");
        return this;
    }

    public QueryBuilderService notNull() {
        sqlQuery.append("NOT NULL ");
        return this;
    }

    public QueryBuilderService primary() {
        sqlQuery.append("PRIMARY KEY ");
        return this;
    }

    public QueryBuilderService autoIncrement() {
        sqlQuery.append("AUTO_INCREMENT ");
        return this;
    }

    public QueryBuilderService defaultVal(String value) {
        sqlQuery.append("DEFAULT ").append(value).append(" ");
        return this;
    }

    public QueryBuilderService onUpdateCurrentTimestamp() {
        sqlQuery.append("ON UPDATE CURRENT_TIMESTAMP ");
        return this;
    }

    public QueryBuilderService comma() {
        sqlQuery.append(", ");
        return this;
    }

    public QueryBuilderService close() {
        sqlQuery.append(") ");
        return this;
    }


    public String build() {
        String queryString = sqlQuery.toString().trim() + ";";
        System.out.println("Query String:"+queryString);
        return queryString;
    }

    public ResultSet runQuery() {
        return DbServices.executeQuery(build());
    }
    public int runExecuteUpdate() {
        return DbServices.runExecuteUpdate(build());
    }

    
}
