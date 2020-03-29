package PROYECTO_TSI.PROYECTO_TSI.MODELS;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="Evento")
public class Evento {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_evento;

    @Column
    private Date fecha;

    @Column
    private Time hora;

    @Column
    private String lugar;

    @Column
    private String descripcion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return id_evento == evento.id_evento &&
                Objects.equals(fecha, evento.fecha) &&
                Objects.equals(hora, evento.hora) &&
                Objects.equals(lugar, evento.lugar) &&
                Objects.equals(descripcion, evento.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_evento, fecha, hora, lugar, descripcion);
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Evento(int id_evento, Date fecha, Time hora, String lugar, String descripcion) {
        this.id_evento = id_evento;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.descripcion = descripcion;
    }

    public Evento() {
    }
}
