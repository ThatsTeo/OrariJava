package GUI;

import Parser.ParserCSV;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;

// TODO: Interfaccia iniziale in cui si carica il file .cvs e/o preferenze

public class MenuIniziale extends JFrame{

    protected File fileSelezionato = null;
    ParserCSV parser = null;

    private JButton bottoneMenuFile = new JButton("Scegli file");
    private JLabel nomeFileSelezionato = new JLabel("Nome del file");

    JTextArea contenutoFile = new JTextArea("Contenuto del file selezionato...",15, 30);

    public MenuIniziale() {
        super("Opzione orari");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        bottoneMenuFile.addActionListener(_ -> {
            triggerFileChooser();
        });
        add(bottoneMenuFile);

        add(nomeFileSelezionato);

        contenutoFile.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(contenutoFile);
        add(scrollPane);

        setVisible(true);
    }

    private void triggerFileChooser() {
        JFileChooser filePicker = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "File CSV", "csv"
        );
        filePicker.setFileFilter(filter);
        int returnVal = filePicker.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.fileSelezionato = filePicker.getSelectedFile();
            nomeFileSelezionato.setText("File selezionato: " + fileSelezionato.getName());

            this.parser = new ParserCSV(filePicker.getSelectedFile());
            ArrayList<String[]> data = parser.parse();
            contenutoFile.setText(parser.toString());
        }
    }
}
