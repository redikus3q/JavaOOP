package Services.FileManipulation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFileService {
    private static ReadFileService instance;

    private ReadFileService(){}

    public static ReadFileService initiateRead() {
        if (instance == null) {
            instance = new ReadFileService();
        }
        return instance;
    }

    public ArrayList<String []> read(String fileName){
        ArrayList<String []> output = new ArrayList<String []>();
        try( var in = new BufferedReader(new FileReader(fileName))) {
            String line = "";

            while( (line = in.readLine()) != null ) {
                String [] fields = line.replaceAll(", ", ",").split(",");
                output.add(fields);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }
}
