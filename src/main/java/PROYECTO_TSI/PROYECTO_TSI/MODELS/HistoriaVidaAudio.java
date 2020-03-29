package PROYECTO_TSI.PROYECTO_TSI.MODELS;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="HistoriaVidaAudio")
public class HistoriaVidaAudio {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_HVA;

    @Column
    private String titulo;
    @Column
    private Date fecha;
    @Column
    private String archivo_mp3;


    public int getId_HVA() {
        return id_HVA;
    }

    public void setId_HVA(int id_HVA) {
        this.id_HVA = id_HVA;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public HistoriaVidaAudio() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoriaVidaAudio that = (HistoriaVidaAudio) o;
        return id_HVA == that.id_HVA &&
                Objects.equals(titulo, that.titulo) &&
                Objects.equals(fecha, that.fecha) &&
                Objects.equals(archivo_mp3, that.archivo_mp3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_HVA, titulo, fecha, archivo_mp3);
    }

    public HistoriaVidaAudio(int id_HVA, String titulo, Date fecha, String archivo_mp3) {
        this.id_HVA = id_HVA;
        this.titulo = titulo;
        this.fecha = fecha;
        this.archivo_mp3 = archivo_mp3;
    }
}
