package Services;

import Entities.Address;
import Entities.City;
import Services.FileManipulation.ReadFileService;
import Services.FileManipulation.WriteFileService;

import java.util.ArrayList;
import java.util.List;

public class AddressService {
    List<Address> addresses;
    CityService cityService;
    WriteFileService writeFile;
    String fileName = "data/addresses.csv";

    public AddressService() {
        this.cityService = new CityService();
        this.writeFile = WriteFileService.initiateWrite();
        addresses = new ArrayList<>();
        this.loadAddresses();
    }

    private void loadAddresses(){
        writeFile.writeAudit("Load_addresses");
        ReadFileService readFile = ReadFileService.initiateRead();
        ArrayList<String []> output = readFile.read(fileName);
        for(var address : output){
            this.createAddress(address[0], address[1], true);
        }
    }

    public Address getAddress(String name){
        writeFile.writeAudit("Get_address " + name);
        for(Address address : addresses){
            if(address.getAddressLine().equals(name)){
                return address;
            }
        }
        return null;
    }

    public Address createAddress(String name, String cityName){
        return this.createAddress(name, cityName, false);
    }

    public Address createAddress(String name, String cityName, boolean load){
        writeFile.writeAudit("Create_address " + name);
        City city = this.cityService.getCity(cityName);
        if(city == null){
            System.out.println("Address creation failed, city " + cityName + " doesn't exist.");
            return null;
        }
        Address address = new Address(name, city);
        addresses.add(address);
        if(!load) {
            writeFile.write(name + ", " + cityName, fileName);
        }
        return address;
    }

    public ArrayList<Address> getAllAddresses(){
        writeFile.writeAudit("Get_all_addresses");
        return new ArrayList<Address>(addresses);
    }
}
