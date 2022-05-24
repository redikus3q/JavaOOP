package Services;

import Entities.Address;
import Entities.Client;
import Services.DatabaseManagement.DBConnection;
import Services.DBManipulation.WriteDatabase;

import java.sql.*;

public class ClientService {
    AddressService addressService;
    WriteDatabase writeDB;
    Connection connection;

    public ClientService() {
        this.addressService = new AddressService();
        this.writeDB = WriteDatabase.initiateWrite();
        this.connection = DBConnection.connect().getConnection();
    }



    public Client createClient(String firstName, String lastName, String addressLine){
        writeDB.writeAudit("Create_client " + firstName + " " + lastName);
        int address_id = this.addressService.getAddressId(addressLine);
        if(address_id == 0){
            System.out.println("Client creation failed, address " + addressLine + " doesn't exist.");
            return null;
        }
        Address address = addressService.getAddress(addressLine);
        int id = addressService.getAddressId(addressLine);
        Client client = new Client(firstName, lastName, address);

        writeDB.write(firstName + "," + lastName + "," + id, "clients");

        System.out.println("Created client " + firstName + " " + lastName);

        return client;
    }

    public int getClientId(String firstName, String lastName){
        writeDB.writeAudit("Get_client id " + firstName + " " +lastName);
        try {
            Statement statement = connection.createStatement();
            String query = String.format("select * from clients where firstName = '%s' and lastName = '%s'", firstName, lastName);
            ResultSet result = statement.executeQuery(query);
            if(!result.next()){
                return 0;
            }
            int id = result.getInt("idClient");
            statement.close();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void deleteClient(String firstName, String lastName){
        writeDB.writeAudit("Delete_client " + firstName + " " +lastName);
        try {
            Statement statement = connection.createStatement();
            String query = String.format("delete from clients where firstName = '%s' and lastName = '%s'", firstName, lastName);
            int number = statement.executeUpdate(query);
            System.out.println("Deleted " + number + " clients with the name " + firstName + " " +lastName);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClient(int id, String firstName, String lastName){
        writeDB.writeAudit("Update_client " + firstName + " " +lastName);
        try {
            Statement statement = connection.createStatement();
            String query = String.format("update clients set firstName = '%s', lastName = '%s' where (idClient = '%d')", firstName, lastName, id);
            statement.executeUpdate(query);
            System.out.println("Changed the name of client with id " + id + " to " + firstName + " " +lastName);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
