package Services.DBManipulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WriteDatabase {
    private static WriteDatabase instance;
    Connection connection;

    private WriteDatabase(){
        String url = "jdbc:mysql://localhost:3306/proiectjava";
        String username = "root";
        String password = "root";
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static WriteDatabase initiateWrite() {
        if (instance == null) {
            instance = new WriteDatabase();
        }
        return instance;
    }

    public void writeAudit(String action){
        try {
            Statement statement = connection.createStatement();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
            LocalDateTime currentTime = LocalDateTime.now();
            String now = format.format(currentTime);
            String query = String.format("insert into audit values(null, '%s', '%s')", action, now);
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void write(String text, String dbName){
        try {
            Statement statement = connection.createStatement();
            //String query = String.format("insert into cities values(null, '%s')", text);
            String query = "insert into ";
            query += dbName;
            query += " values(null";
            String[] values = text.split(",");
            for(int i = 0; i < values.length; i++){
                query += ", '";
                query += values[i];
                query += "'";
            }
            query += ")";
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
