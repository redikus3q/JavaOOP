package Services;

import Entities.Organizer;
import Services.FileManipulation.ReadFileService;
import Services.FileManipulation.WriteFileService;

import java.util.ArrayList;
import java.util.List;

public class OrganizerService {
    List<Organizer> organizers;
    WriteFileService writeFile;
    String fileName = "data/organizers.csv";

    public OrganizerService() {
        this.writeFile = WriteFileService.initiateWrite();
        organizers = new ArrayList<>();
        this.loadOrganizers();
    }

    private void loadOrganizers(){
        writeFile.writeAudit("Load_organizers");
        ReadFileService readFile = ReadFileService.initiateRead();
        ArrayList<String []> output = readFile.read(fileName);
        for(var organizer : output){
            this.createOrganizer(organizer[0], true);
        }
    }

    public Organizer createOrganizer(String name){
        return this.createOrganizer(name, false);
    }

    public Organizer createOrganizer(String name, boolean load){
        writeFile.writeAudit("Create_organizer" + name);
        Organizer organizer = new Organizer(name);
        organizers.add(organizer);
        if(!load) {
            writeFile.write(name, fileName);
        }
        return organizer;
    }

    public Organizer getOrganizer(String name){
        writeFile.writeAudit("Get_organizer " + name);
        for(Organizer organizer : organizers){
            if(organizer.getName().equals(name)){
                return organizer;
            }
        }
        return null;
    }

    public ArrayList<Organizer> getAllOrganizers(){
        writeFile.writeAudit("Get_all_events");
        return new ArrayList<Organizer>(organizers);
    }
}
