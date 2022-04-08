package com.kashigin.stanislav.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection {
    private static final String DB_URL = "POSTGRES_DB_URL";
    private static final String DB_NAME = "postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASS = "admin";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL+DB_NAME, DB_USER, DB_PASS);
    }
}
