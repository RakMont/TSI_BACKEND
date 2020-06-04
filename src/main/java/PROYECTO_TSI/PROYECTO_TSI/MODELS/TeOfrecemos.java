package PROYECTO_TSI.PROYECTO_TSI.MODELS;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="TeOfrecemos")
public class TeOfrecemos {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_teOfrecemos;

    @Column
    private String tema;

    @Column
    @Size(max = 2000)
    private String contenido;
    @Column
    @Size(max = 2000)
    private String contacto;

    @Override
    public String toString() {
        return "TeOfrecemos{" +
                "id_teOfrecemos=" + id_teOfrecemos +
                ", tema='" + tema + '\'' +
                ", contenido='" + contenido + '\'' +
                ", contacto='" + contacto + '\'' +
                '}';
    }

    public TeOfrecemos() {
    }

    public int getId_teOfrecemos() {
        return id_teOfrecemos;
    }

    public void setId_teOfrecemos(int id_teOfrecemos) {
        this.id_teOfrecemos = id_teOfrecemos;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}
