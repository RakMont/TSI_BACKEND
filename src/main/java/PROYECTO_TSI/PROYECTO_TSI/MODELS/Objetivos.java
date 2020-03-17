package PROYECTO_TSI.PROYECTO_TSI.MODELS;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Objetivos")
public class Objetivos {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_objetivos;

    @Column
    private String contenido;

    public Objetivos(int id_objetivos, String contenido) {
        this.id_objetivos = id_objetivos;
        this.contenido = contenido;
    }

    public Objetivos() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Objetivos objetivos = (Objetivos) o;
        return id_objetivos == objetivos.id_objetivos &&
                Objects.equals(contenido, objetivos.contenido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_objetivos, contenido);
    }

    public int getId_objetivos() {
        return id_objetivos;
    }

    public void setId_objetivos(int id_objetivos) {
        this.id_objetivos = id_objetivos;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
