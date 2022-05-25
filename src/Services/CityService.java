package Services;

import Entities.City;
import Services.DatabaseManagement.DBConnection;
import Services.DBManipulation.WriteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CityService {
    List<City> cities;
    Connection connection;
    String dbName = "cities";
    WriteDatabase writeDB;

    public CityService() {
        cities = new ArrayList<>();
        this.connection = DBConnection.connect().getConnection();
        this.writeDB = WriteDatabase.initiateWrite();
    }

    public City createCity(String name){
        writeDB.writeAudit("Create_city " + name);
        City city = new City(name);
        writeDB.write(name, dbName);
        System.out.println("Created city " + name);
        return city;
    }

    public int getCityId(String name){
        writeDB.writeAudit("Get_city " + name);
        try {
            Statement statement = connection.createStatement();
            String query = String.format("select * from cities where name = '%s'", name);
            ResultSet result = statement.executeQuery(query);
            if(!result.next()){
                return 0;
            }
            int id = result.getInt("idCity");
            statement.close();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void deleteCity(String name){
        writeDB.writeAudit("Delete_city " + name);
        try {
            Statement statement = connection.createStatement();
            String query = String.format("delete from cities where name = '%s'", name);
            int number = statement.executeUpdate(query);
            System.out.println("Deleted " + number + " cities with the name " + name);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCity(int id, String name){
        writeDB.writeAudit("Update_city " + name);
        try {
            Statement statement = connection.createStatement();
            String query = String.format("update cities set name = '%s' where (idCity = '%d')", name, id);
            int number = statement.executeUpdate(query);
            if(number != 0) {
                System.out.println("Changed the name of city with id " + id + " to " + name);
            }
            else{
                System.out.println("Cant find city with id " + id);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
