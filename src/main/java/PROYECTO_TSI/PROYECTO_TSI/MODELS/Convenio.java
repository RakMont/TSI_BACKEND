package PROYECTO_TSI.PROYECTO_TSI.MODELS;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="Convenio")
public class Convenio {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_convenio;

    @Column
    private String institucion;

    @Column
    @Size(max = 500)
    private String descripcion;

    @Column
    private String direccion;

    @Column
    private String imagen;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Convenio convenio = (Convenio) o;
        return id_convenio == convenio.id_convenio &&
                Objects.equals(institucion, convenio.institucion) &&
                Objects.equals(descripcion, convenio.descripcion) &&
                Objects.equals(direccion, convenio.direccion) &&
                Objects.equals(imagen, convenio.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_convenio, institucion, descripcion, direccion, imagen);
    }

    public int getId_convenio() {
        return id_convenio;
    }

    public void setId_convenio(int id_convenio) {
        this.id_convenio = id_convenio;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Convenio(int id_convenio, String institucion, String descripcion, String direccion, String imagen) {
        this.id_convenio = id_convenio;
        this.institucion = institucion;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.imagen = imagen;
    }

    public Convenio() {
    }
}
