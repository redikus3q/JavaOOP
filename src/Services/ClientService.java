package Services;

import Entities.Address;
import Entities.Client;
import Services.FileManipulation.ReadFileService;
import Services.FileManipulation.WriteFileService;

import java.util.ArrayList;
import java.util.List;

public class ClientService {
    List<Client> clients;
    AddressService addressService;
    WriteFileService writeFile;
    String fileName = "data/clients.csv";

    public ClientService() {
        this.addressService = new AddressService();
        this.writeFile = WriteFileService.initiateWrite();
        clients = new ArrayList<>();
        this.loadClients();
    }

    private void loadClients(){
        writeFile.writeAudit("Load_clients ");
        ReadFileService readFile = ReadFileService.initiateRead();
        ArrayList<String []> output = readFile.read(fileName);
        for(var client : output){
            this.createClient(client[0], client[1], client[2], true);
        }
    }

    public Client createClient(String firstName, String lastName, String addressLine){
        return this.createClient(firstName, lastName, addressLine, false);
    }

    public Client createClient(String firstName, String lastName, String addressLine, boolean load){
        writeFile.writeAudit("Create_client " + firstName + " " + lastName);
        Address address = this.addressService.getAddress(addressLine);
        if(address == null){
            System.out.println("client creation failed, address " + addressLine + " doesn't exist.");
            return null;
        }
        Client client = new Client(firstName, lastName, address);
        clients.add(client);
        if(!load) {
            writeFile.write(firstName + ", " + lastName + ", " + address.getAddressLine(), fileName);
        }
        return client;
    }

    public ArrayList<Client> getAllClients(){
        writeFile.writeAudit("Get_all_clients ");
        return new ArrayList<Client>(clients);
    }
}
