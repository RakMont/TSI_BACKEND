package PROYECTO_TSI.PROYECTO_TSI.MODELS;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Mision")
public class Mision {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mision;

    @Column
    private String contenido;

    public Mision() {
    }

    public Mision(int id_Mision, String contenido) {
        this.id_mision = id_Mision;
        this.contenido = contenido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mision mision = (Mision) o;
        return id_mision == mision.id_mision &&
                Objects.equals(contenido, mision.contenido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_mision, contenido);
    }

    public int getId_mision() {
        return id_mision;
    }

    public void setId_mision(int id_mision) {
        this.id_mision = id_mision;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
