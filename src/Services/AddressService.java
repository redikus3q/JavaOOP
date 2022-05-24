package Services;

import Entities.Address;
import Entities.City;
import Services.DatabaseManagement.DBConnection;
import Services.DBManipulation.WriteDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressService {
    CityService cityService;
    WriteDatabase writeDB;
    Connection connection;

    public AddressService() {
        this.cityService = new CityService();
        this.writeDB = WriteDatabase.initiateWrite();
        this.connection = DBConnection.connect().getConnection();
    }

    public Address createAddress(String name, String cityName){
        writeDB.writeAudit("Create_address " + name);
        int city_id = this.cityService.getCityId(cityName);
        if(city_id == 0){
            System.out.println("Address creation failed, city " + cityName + " doesn't exist.");
            return null;
        }
        City city = new City(cityName);
        Address address = new Address(name, city);

        writeDB.write(name + "," + city_id, "addresses");

        System.out.println("Created address " + name);

        return address;
    }

    public Address getAddress(String addressLine){
        writeDB.writeAudit("Get_address " + addressLine);
        try {
            Statement statement = connection.createStatement();
            String query = String.format("select name from addresses " +
                    "join cities on cities.idCity = addresses.city " +
                    "where addressLine = '%s'", addressLine);
            ResultSet result = statement.executeQuery(query);
            if(!result.next()){
                return null;
            }
            String name = result.getString("name");
            City city = new City(name);
            Address address = new Address(addressLine, city);
            statement.close();
            return address;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getAddressId(String addressLine){
        writeDB.writeAudit("Get_address id " + addressLine);
        try {
            Statement statement = connection.createStatement();
            String query = String.format("select * from addresses where addressLine = '%s'", addressLine);
            ResultSet result = statement.executeQuery(query);
            if(!result.next()){
                return 0;
            }
            int id = result.getInt("idAddress");
            statement.close();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void deleteAddress(String addressLine){
        writeDB.writeAudit("Delete_address " + addressLine);
        try {
            Statement statement = connection.createStatement();
            String query = String.format("delete from addresses where addressLine = '%s'", addressLine);
            int number = statement.executeUpdate(query);
            System.out.println("Deleted " + number + " addresses with the address line " + addressLine);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAddress(int id, String addressLine){
        writeDB.writeAudit("Update_address " + addressLine);
        try {
            Statement statement = connection.createStatement();
            String query = String.format("update addresses set addressLine = '%s' where (idAddress = '%d')", addressLine, id);
            statement.executeUpdate(query);
            System.out.println("Changed the name of address with id " + id + " to " + addressLine);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
