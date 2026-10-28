package ClassiBasi;

import java.time.Duration;

public class Lezione {
    private Docente docente;
    private Materia materia;
    private Duration durata;

    public Lezione(Docente docente, Materia materia, Duration durata) {
        this.docente = docente;
        this.materia = materia;
        this.durata = durata;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Duration getDurata() {
        return durata;
    }

    public void setDurata(Duration durata) {
        this.durata = durata;
    }
}
