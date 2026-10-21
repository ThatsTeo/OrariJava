package Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// TODO: Parser file CSV per estrarre docenti, ore e classi

public class ParserCSV {
    File fileCSV;
    public ParserCSV(File file) {
        this.fileCSV = file;
    }

    public ArrayList<String[]> parser() {
        String filePath = fileCSV.getPath();
        String line;
        String delimiter = ",";
        ArrayList<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                for (String value : values) {
                    data.add(values);
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }

        return data;
    }
}
