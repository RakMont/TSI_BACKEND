package PROYECTO_TSI.PROYECTO_TSI.MODELS;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name="Comentario")
public class Comentario {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_comentario;
    @Column
    @Size(max = 10000)
    private String comentario;

    @Column
    private Date fecha;

    @Column
    private int id_comentario_ref;

    @Column
    private int referente;

    public int getReferente() {
        return referente;
    }

    public void setReferente(int referente) {
        this.referente = referente;
    }

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_comentario_ref() {
        return id_comentario_ref;
    }

    public void setId_comentario_ref(int id_comentario_ref) {
        this.id_comentario_ref = id_comentario_ref;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id_comentario=" + id_comentario +
                ", comentario=" + comentario +
                ", fecha=" + fecha +
                ", id_comentario_ref=" + id_comentario_ref +
                ", user=" + user +
                '}';
    }

    public Comentario() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
