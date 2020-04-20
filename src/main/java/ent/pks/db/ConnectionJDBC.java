package ent.pks.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.out;

public interface ConnectionJDBC {
    String DB_DRIVER = "org.h2.Driver";
    String DB_URL = "jdbc:h2:./musicStore";
    String DB_USERNAME = "ss";
    String DB_PASSWORD = "";

    default Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            out.println("Connection OK");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("Connection ERROR");
        }
        return connection;
    }
}
