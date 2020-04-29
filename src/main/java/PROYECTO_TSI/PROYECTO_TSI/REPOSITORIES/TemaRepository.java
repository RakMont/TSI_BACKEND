package PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Podcast;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Tema;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Vision;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TemaRepository extends CrudRepository<Tema,Integer> {
    List<Tema> findAll();
    Tema findById(int id);
    Tema save(Tema podcast);
    void delete(Tema p);
}
