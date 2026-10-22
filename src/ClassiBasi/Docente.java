package ClassiBasi;

import java.util.ArrayList;

public class Docente {

    String nomeCognome;
    private int ore = 0;
    ArrayList<Classe> classi;
    ArrayList<Materia> materie;

    public Docente(String nomeCognome) {
        this.nomeCognome = nomeCognome;
    }

    public void aggiungiClasse(Classe classeDaAggiungere) {
        if(this.classi.contains(classeDaAggiungere)) {
            System.err.println("Il Docente ha gia questa classe assegnata! ");
            return;
        } else if (classeDaAggiungere == null) {
            System.err.println("La classe inserita non è valida! ");
            return;
        }
        this.classi.add(classeDaAggiungere);
    }

    public void aggiungiMateria(Materia materiaDaAggiungere) {
        if(this.materie.contains(materiaDaAggiungere)) {
            System.err.println("Il docente ha gia la materia assegnata! ");
            return;
        } else if (materiaDaAggiungere == null) {
            System.err.println("La materia inserita non è valida! ");
            return;
        }

        this.materie.add(materiaDaAggiungere);
    }
}
