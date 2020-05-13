package PROYECTO_TSI.PROYECTO_TSI.MODELS;

import javax.persistence.*;

@Entity
@Table(name="Referente")
public class Referente {
    @Id
    @Column
    private int id_referente;
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private String video_referente;
    @Column
    private String descripcion;
    @Column
    private String titulo;

    public int getId_referente() {
        return id_referente;
    }

    public void setId_referente(int id_referente) {
        this.id_referente = id_referente;
    }

    public String getVideo_referente() {
        return video_referente;
    }

    public void setVideo_referente(String video_referente) {
        this.video_referente = video_referente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Referente() {
    }

    public Referente(int id_referente, String video_referente, String descripcion, String titulo) {
        this.id_referente = id_referente;
        this.video_referente = video_referente;
        this.descripcion = descripcion;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Referente{" +
                "id_referente=" + id_referente +
                ", video_referente='" + video_referente + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
