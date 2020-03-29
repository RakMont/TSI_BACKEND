package PROYECTO_TSI.PROYECTO_TSI.MODELS;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="HistoriaVidaVideo")
public class HistoriaVidaVideo {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_HVV;

    @Column
    private String titulo;
    @Column
    private Date fecha;
    @Column
    private String video_HVV;

    @Override
    public String toString() {
        return "HistoriaVidaVideo{" +
                "id_HVV=" + id_HVV +
                ", titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                ", video_HVV='" + video_HVV + '\'' +
                '}';
    }

    public HistoriaVidaVideo() {
    }

    public int getId_HVV() {
        return id_HVV;
    }

    public void setId_HVV(int id_HVV) {
        this.id_HVV = id_HVV;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getVideo_HVV() {
        return video_HVV;
    }

    public void setVideo_HVV(String video_HVV) {
        this.video_HVV = video_HVV;
    }
}
