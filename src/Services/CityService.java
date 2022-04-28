package Services;

import Entities.City;
import Services.FileManipulation.ReadFileService;
import Services.FileManipulation.WriteFileService;

import java.util.ArrayList;
import java.util.List;

public class CityService {
    List<City> cities;
    WriteFileService writeFile;
    String fileName = "data/cities.csv";

    public CityService() {
        cities = new ArrayList<>();
        this.writeFile = WriteFileService.initiateWrite();
        this.loadCities();
    }

    private void loadCities(){
        writeFile.writeAudit("Load_cities");
        ReadFileService readFile = ReadFileService.initiateRead();
        ArrayList<String []> output = readFile.read(fileName);
        for(var city : output){
            this.createCity(city[0], true);
        }
    }

    public City createCity(String name){
        return this.createCity(name, false);
    }

    public City createCity(String name, boolean load){
        writeFile.writeAudit("Create_address " + name);
        City city = new City(name);
        cities.add(city);
        if(!load) {
            writeFile.write(name, fileName);
        }
        return city;
    }

    public City getCity(String name){
        writeFile.writeAudit("Get_city " + name);
        for(City city : cities){
            if(city.getName().equals(name)){
                return city;
            }
        }
        return null;
    }

    public ArrayList<City> getAllCities(){
        writeFile.writeAudit("Get_all_addresses");
        return new ArrayList<City>(cities);
    }

}
