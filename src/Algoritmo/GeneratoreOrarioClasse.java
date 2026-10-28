package Algoritmo;

import ClassiBasi.Classe;
import ClassiBasi.Docente;
import ClassiBasi.Lezione;
import ClassiBasi.Materia;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class GeneratoreOrarioClasse {
    public Classe classe;
    public Lezione[][] orario = new Lezione[6][5];
    public int orarioBit = 0x0b; // max 31

    public GeneratoreOrarioClasse(Classe classe) {
        this.classe = classe;
    }

    public Lezione[][] generaOrarioClasse() {
        ArrayList<Docente> docenti = classe.getDocenti();

        for(Docente prof: docenti) {
            Map<Materia, Integer> materieOreProf = prof.getClassiMaterieOre().get(classe);

            for (Materia mat: materieOreProf.keySet()) {
                var oreProf = materieOreProf.get(mat);

                while(oreProf > 0) {
                    int randomGiorno = (new Random().nextInt(4)) + 1; // da 1 a 5
                    int randOra = (new Random().nextInt(5)) + 1; // da 1 a 6

                    int numBit = 6*(randomGiorno-1)+randOra;
                    if((orarioBit & (1 << numBit)) != 0) {
                        oreProf--;
                        orarioBit |= (1 << numBit);

                        orario[randOra][randomGiorno] = new Lezione(prof, mat, Duration.ofHours(1));
                    } else {
                        continue;
                    }
                }
            }
        }

        return orario;
    }
}
