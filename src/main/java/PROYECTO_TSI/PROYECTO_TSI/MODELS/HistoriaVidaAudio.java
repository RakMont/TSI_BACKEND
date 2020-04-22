package PROYECTO_TSI.PROYECTO_TSI.MODELS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;

@Entity
@Table(name="HistoriaVidaAudio")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
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

    @Column
    private byte[] logo;


    public HistoriaVidaAudio() {
    }
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getArchivo_mp3() {
        return archivo_mp3;
    }

    public void setArchivo_mp3(String archivo_mp3) {
        this.archivo_mp3 = archivo_mp3;
    }

    @Override
    public String toString() {
        return "HistoriaVidaAudio{" +
                "id_HVA=" + id_HVA +
                ", titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                ", archivo_mp3='" + archivo_mp3 + '\'' +
                ", logo=" + Arrays.toString(logo) +
                '}';
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public HistoriaVidaAudio(int id_HVA, String titulo, Date fecha, String archivo_mp3, byte[] logo) {
        this.id_HVA = id_HVA;
        this.titulo = titulo;
        this.fecha = fecha;
        this.archivo_mp3 = archivo_mp3;
        this.logo = logo;
    }
}
