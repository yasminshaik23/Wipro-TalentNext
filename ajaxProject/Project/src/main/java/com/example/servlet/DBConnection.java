package com.example.servlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
        "jdbc:oracle:thin:@localhost:1521/XEPDB1";

    private static final String USER =
            "SYSTEM";

    private static final String PASSWORD =
            "Sky2307";

    public static Connection getConnection() throws Exception {

        Class.forName("oracle.jdbc.OracleDriver");

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}