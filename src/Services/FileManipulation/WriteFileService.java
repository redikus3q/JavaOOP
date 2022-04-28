package Services.FileManipulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WriteFileService {
    private static WriteFileService instance;

    private WriteFileService(){}

    public static WriteFileService initiateWrite() {
        if (instance == null) {
            instance = new WriteFileService();
        }
        return instance;
    }

    public void writeAudit(String action){
        try (FileWriter w = new FileWriter("data/audit.csv", true);
             BufferedWriter bufferedWriter = new BufferedWriter(w)) {

            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss");
            LocalDateTime currentTime = LocalDateTime.now();

            bufferedWriter.write(action + "," + format.format(currentTime) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String text, String fileName){
        try (FileWriter w = new FileWriter(fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(w)) {

            bufferedWriter.write(text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
