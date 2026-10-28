import Algoritmo.GeneratoreOrarioScuola;
import ClassiBasi.*;
import GUI.MenuIniziale;
import Parser.ParserCSV;

import javax.swing.*;
import java.io.File;
import java.util.List;

public class Main {

    // Avvio app (supporta sia test console che GUI)
    public static void main(String[] args) {
        if (System.getProperty("console.test") != null) {
            eseguiTestConsole();
            return;
        }

        // Avvio GUI
        SwingUtilities.invokeLater(MenuIniziale::new);
    }

    // Esegue una simulazione di generazione orario da termnale per verifica rapida
    private static void eseguiTestConsole() {
        String csvPath = "src/Parser/ore_docente_classe.csv";
        File file = new File(csvPath);

        if (!file.exists()) {
            System.err.println("File CSV non trovato: " + csvPath);
            return;
        }

        ParserCSV parser = new ParserCSV(file);
        Scuola scuola = parser.costruisciScuola();

        if (scuola == null) {
            System.err.println("Errore nella costruzione del modello scuola.");
            return;
        }

        System.out.println("Classi caricate: " + scuola.getClassi().size());
        System.out.println("Docenti caricati: " + scuola.getDocenti().size());
        System.out.println("Assegnazioni caricate: " + scuola.getAssegnazioni().size());
        System.out.println("Totale ore previste: " + scuola.getTotaleOrePreviste());

        // Genera orario per l'intera scuola
        GeneratoreOrarioScuola generatore = new GeneratoreOrarioScuola(scuola);
        boolean successo = generatore.generaOrario();

        if (successo) {
            List<String> conflitti = generatore.verificaConflitti();
            if (conflitti.isEmpty()) {
                System.out.println("\nNessun conflitto rilevato!");
            } else {
                System.out.println("\nConflitti trovati:");
                for (String c : conflitti) {
                    System.out.println("  " + c);
                }
            }

            // Stampa orario delle prime classi di esempio
            int count = 0;
            for (Classe classe : scuola.getTutteLeClassi()) {
                GeneratoreOrarioScuola.stampaOrarioClasse(classe);
                if (++count >= 3) break;
            }

            // Stampa orario dei primi docenti di esempio
            count = 0;
            for (Docente docente : scuola.getTuttiIDocenti()) {
                generatore.stampaOrarioDocente(docente);
                if (++count >= 2) break;
            }
        } else {
            System.err.println("Impossibile generare un orario valido.");
        }
    }
}
