package PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Comentario;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Mision;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Referente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComentarioRepository extends CrudRepository<Comentario,Integer> {
    List<Comentario> findAll();
    Comentario findById(int id);
    Comentario save(Comentario comentario);
    void delete(Comentario comentario);
}
