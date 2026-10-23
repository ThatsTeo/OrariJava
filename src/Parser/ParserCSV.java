package Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// TODO: Parser file CSV per estrarre docenti, ore e classi

public class ParserCSV {
    protected File fileCSV;
    ArrayList<String[]> datiFile;

    public ParserCSV() {}

    public ParserCSV(File file) {
        this.fileCSV = file;
        parse();
    }

    public ArrayList<String[]> parse() {
        if (fileCSV == null) {
            System.err.println("File CSV non selezionato!");
            return null;
        }
        String filePath = fileCSV.getPath();
        String line;
        String delimiter = ",";
        ArrayList<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                for (String _ : values) {
                    data.add(values);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }

        this.datiFile = data;
        return data;
    }

    public File getFileCSV() {
        return fileCSV;
    }

    public void setFileCSV(File fileCSV) {
        this.fileCSV = fileCSV;
    }

    @Override
    public String toString() {
        ArrayList<String> datiFinali = new ArrayList<>();

        boolean nomeColonne = true;

        for(String[] i: datiFile) {
            if(nomeColonne) {
                nomeColonne = false;
                continue;
            }
            for(String s: i) {
                datiFinali.add(s + "\n");
            }
        }

        return "ParserCSV{" +
                "datiFile=\n" + datiFinali +
                '}';
    }
}
