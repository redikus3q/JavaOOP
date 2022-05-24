package Services;

import Entities.Organizer;
import Services.DatabaseManagement.DBConnection;
import Services.DBManipulation.WriteDatabase;

import java.sql.*;

public class OrganizerService {
    WriteDatabase writeDB;
    Connection connection;

    public OrganizerService() {
        this.writeDB = WriteDatabase.initiateWrite();
        this.connection = DBConnection.connect().getConnection();
    }


    public Organizer createOrganizer(String name){
        writeDB.writeAudit("Create_organizer " + name);
        Organizer organizer = new Organizer(name);
        writeDB.write(name, "organizers");
        System.out.println("Created organizer " + name);
        return organizer;
    }

    public int getOrganizerId(String name){
        writeDB.writeAudit("Get_organizer " + name);
        try {
            Statement statement = connection.createStatement();
            String query = String.format("select * from organizers where name = '%s'", name);
            ResultSet result = statement.executeQuery(query);
            if(!result.next()){
                return 0;
            }
            int id = result.getInt("idOrganizer");
            statement.close();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void deleteOrganizer(String name){
        writeDB.writeAudit("Delete_organizer " + name);
        try {
            Statement statement = connection.createStatement();
            String query = String.format("delete from organizers where name = '%s'", name);
            int number = statement.executeUpdate(query);
            System.out.println("Deleted " + number + " organizers with the name " + name);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrganizer(int id, String name){
        writeDB.writeAudit("Update_organizer " + name);
        try {
            Statement statement = connection.createStatement();
            String query = String.format("update organizers set name = '%s' where (idOrganizer = '%d')", name, id);
            statement.executeUpdate(query);
            System.out.println("Changed the name of organizer with id " + id + " to " + name);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
