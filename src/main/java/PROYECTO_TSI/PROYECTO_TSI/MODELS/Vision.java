package PROYECTO_TSI.PROYECTO_TSI.MODELS;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Vision")
public class Vision {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_vision;

    @Column
    private String contenido;


    public Vision(int id_Vision, String contenido) {
        this.id_vision = id_Vision;
        this.contenido = contenido;
    }

    public Vision() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vision vision = (Vision) o;
        return id_vision == vision.id_vision &&
                Objects.equals(contenido, vision.contenido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_vision, contenido);
    }

    public int getId_vision() {
        return id_vision;
    }

    public void setId_vision(int id_vision) {
        this.id_vision = id_vision;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
