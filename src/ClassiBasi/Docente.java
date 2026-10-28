package ClassiBasi;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Docente {

    private String nomeCognome;
    private int ore = 0;
    private TreeMap<Classe, Map<Materia, Integer>> classiMaterieOre;
    private GiorniSettimana giorniLiberi;

    public Docente(String nomeCognome) {
        this.nomeCognome = nomeCognome;
    }

    public void aggiungiClasse(Classe classeDaAggiungere, int ore, Materia materia) {
        if(this.classiMaterieOre.containsKey(classeDaAggiungere)) {
            System.err.println("Il Docente ha gia questa classe assegnata! ");
            return;
        } else if (classeDaAggiungere == null) {
            System.err.println("La classe inserita non è valida! ");
            return;
        }
        HashMap<Materia, Integer> materiaOre = new HashMap<>();
        materiaOre.put(materia, ore);
        this.classiMaterieOre.put(classeDaAggiungere, materiaOre);
    }

    public String getNomeCognome() {
        return nomeCognome;
    }

    public void setNomeCognome(String nomeCognome) {
        this.nomeCognome = nomeCognome;
    }

    public int getOre() {
        return ore;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }

    public TreeMap<Classe, Map<Materia, Integer>> getClassiMaterieOre() {
        return classiMaterieOre;
    }

    public void setClassiMaterieOre(TreeMap<Classe, Map<Materia, Integer>> classiMaterieOre) {
        this.classiMaterieOre = classiMaterieOre;
    }

    public GiorniSettimana getGiorniLiberi() {
        return giorniLiberi;
    }

    public void setGiorniLiberi(GiorniSettimana giorniLiberi) {
        this.giorniLiberi = giorniLiberi;
    }
}
