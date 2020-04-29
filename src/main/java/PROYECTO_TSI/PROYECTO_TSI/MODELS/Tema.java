package PROYECTO_TSI.PROYECTO_TSI.MODELS;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="Tema")
public class Tema {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tema;

    @Column
    private String nombreTema;

    public Tema() {
    }

    public Tema(int id_tema, String nombreTema) {
        this.id_tema = id_tema;
        this.nombreTema = nombreTema;
    }

    public int getId_tema() {
        return id_tema;
    }

    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }

    public String getNombreTema() {
        return nombreTema;
    }

    public void setNombreTema(String nombreTema) {
        this.nombreTema = nombreTema;
    }

    @Override
    public String toString() {
        return "Tema{" +
                "id_tema=" + id_tema +
                ", nombreTema='" + nombreTema + '\'' +
                '}';
    }
}
