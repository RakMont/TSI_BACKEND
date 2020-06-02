package PROYECTO_TSI.PROYECTO_TSI.MODELS;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name="HistoriaVidaTexto")
public class HistoriaVidaTexto {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_HVT;

    @Column
    private String titulo;
    @Column
    private Date fecha;
    @Column
    @Size(max = 2000)
    private String contenido;

    public HistoriaVidaTexto() {
    }

    @Override
    public String toString() {
        return "Historia_Vida_Texto{" +
                "id_HVT=" + id_HVT +
                ", titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                ", contenido='" + contenido + '\'' +
                '}';
    }

    public HistoriaVidaTexto(int id_HVT, String titulo, Date fecha, String contenido) {
        this.id_HVT = id_HVT;
        this.titulo = titulo;
        this.fecha = fecha;
        this.contenido = contenido;
    }

    public int getId_HVT() {
        return id_HVT;
    }

    public void setId_HVT(int id_HVT) {
        this.id_HVT = id_HVT;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
