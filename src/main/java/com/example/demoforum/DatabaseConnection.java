package com.example.demoforum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// This class can be used to initialize the database connection
public class DatabaseConnection {
    private static final String DRIVER = "org.postgresql.Driver";

    protected static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException
    {
        Class.forName(DRIVER);
        String url = String.format("jdbc:postgresql://%s:%s/%s", System.getenv("POSTGRES_HOSTNAME"), System.getenv("POSTGRES_PORT"), System.getenv("POSTGRES_DBNAME"));
        //String url = "jdbc:postgresql://localhost/test";
        System.out.println(url);
        Properties props = new Properties();
        props.setProperty("user", System.getenv("POSTGRES_USER"));
        props.setProperty("password", System.getenv("POSTGRES_PASSWORD"));
        //props.setProperty("ssl", "true");
        Connection con = DriverManager.getConnection(url, props);
        return con;
    }
}