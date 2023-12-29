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
        sqlQuery.append("INSERT ");
        return this;
    }

    public QueryBuilderService into(String tableName) {
        sqlQuery.append("INTO ").append(tableName).append(" ");
        return this;
    }

    public QueryBuilderService values(String values) {
        sqlQuery.append("VALUES ").append(values).append(" ");
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

    public String build() {
        return sqlQuery.toString().trim() + ";";
    }

    public ResultSet runQuery() {
        return DbServices.executeQuery(build());
    }
}
