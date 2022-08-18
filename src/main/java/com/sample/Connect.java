package com.sample;

import java.sql.*;

public class Connect {

    private static final String JDBC_URL_CONST = "jdbc:sqlite:D:\\idea_projects\\connect-to-sqlite-manually\\src\\main\\resources\\new_db";
    private static Statement statement;

    /**
     * Connect to a sample database
     */
    public static void connect() {
        try {

            // create a connection to the database
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(JDBC_URL_CONST);

            System.out.println("Connection to SQLite has been established.");

            String sql = "SELECT * FROM Users";

            statement = connection.createStatement();
            readRs(sql);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void readRs(String sql) throws SQLException {
        ResultSet rs = statement.executeQuery(sql);

        // loop through the result set
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" +
                    rs.getString("name"));
        }
    }

    public static void main(String[] args) {
        // connect to db and execute the query
        connect();
    }
}