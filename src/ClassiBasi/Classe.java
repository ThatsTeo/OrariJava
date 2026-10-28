package ClassiBasi;

import java.util.ArrayList;
import java.util.Map;

public class Classe {
    private Tuple<Integer, Character, String> nomeClasse;
    private ArrayList<Docente> docenti;
    private Map<Materia, Integer> materieOre;
    private Lezione[][] tabellaLezioni;

    public Classe(ArrayList<Docente> docenti, Map<Materia, Integer> materieOre) {
        this.docenti = docenti;
        this.materieOre = materieOre;
    }

    public Classe(ArrayList<Docente> docenti, Map<Materia, Integer> materieOre, Lezione[][] tabellaLezioni) {
        this.docenti = docenti;
        this.materieOre = materieOre;
        this.tabellaLezioni = tabellaLezioni;
    }

    public Tuple<Integer, Character, String> getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(Tuple<Integer, Character, String> nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public ArrayList<Docente> getDocenti() {
        return docenti;
    }

    public void setDocenti(ArrayList<Docente> docenti) {
        this.docenti = docenti;
    }

    public Map<Materia, Integer> getMaterieOre() {
        return materieOre;
    }

    public void setMaterieOre(Map<Materia, Integer> materieOre) {
        this.materieOre = materieOre;
    }

    public Lezione[][] getTabellaLezioni() {
        return tabellaLezioni;
    }

    public void setTabellaLezioni(Lezione[][] tabellaLezioni) {
        this.tabellaLezioni = tabellaLezioni;
    }
}
