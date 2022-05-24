package Services.DatabaseManagement;

import java.sql.*;

public class DBConnection {
    private static DBConnection instance;
    Connection connection;

    private DBConnection(){
        String url = "jdbc:mysql://localhost:3306/proiectjava";
        String username = "root";
        String password = "root";
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnection connect() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
