package PROYECTO_TSI.PROYECTO_TSI.MODELS;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="Podcast")
public class Podcast {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_podcast;

    @Column
    private Date fecha;

    @Column
    private String titulo;
    @Column
    private String descripcion;
    @Column
    private String archivoMP3;

    public Podcast() {
    }

    public Podcast(int id_podcast, Date fecha, String titulo, String descripcion, String archivoMP3) {
        this.id_podcast = id_podcast;
        this.fecha = fecha;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.archivoMP3 = archivoMP3;
    }

    public int getId_podcast() {
        return id_podcast;
    }

    public void setId_podcast(int id_podcast) {
        this.id_podcast = id_podcast;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArchivoMP3() {
        return archivoMP3;
    }

    public void setArchivoMP3(String archivoMP3) {
        this.archivoMP3 = archivoMP3;
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "id_podcast=" + id_podcast +
                ", fecha=" + fecha +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", archivoMP3='" + archivoMP3 + '\'' +
                '}';
    }
}
