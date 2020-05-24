package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Comentario;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Convenio;

import java.util.List;

public interface ComentarioService {
    List<Comentario> listar();
    Comentario listarId(int id);
    Comentario agregar(Comentario p);
    Comentario edit(Comentario p);
    Comentario delete(int id);
}
