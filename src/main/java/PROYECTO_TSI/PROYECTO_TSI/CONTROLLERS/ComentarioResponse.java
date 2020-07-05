package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.sql.Date;

public class ComentarioResponse {
    private int id_comentario;
    private String comentario;
    private Date fecha;
    private int id_comentario_ref;
    private int referente;
    UserProfileResponse userProfileResponse;

    public ComentarioResponse() {
    }

    public ComentarioResponse(int id_comentario, String comentario, Date fecha, int id_comentario_ref, int referente, UserProfileResponse userProfileResponse) {
        this.id_comentario = id_comentario;
        this.comentario = comentario;
        this.fecha = fecha;
        this.id_comentario_ref = id_comentario_ref;
        this.referente = referente;
        this.userProfileResponse = userProfileResponse;
    }

    public int getId_comentario() {
        return id_comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getId_comentario_ref() {
        return id_comentario_ref;
    }

    public int getReferente() {
        return referente;
    }

    public UserProfileResponse getUserProfileResponse() {
        return userProfileResponse;
    }
}
