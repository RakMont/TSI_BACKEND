package PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Mision;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MisionRepository extends CrudRepository<Mision,Integer> {
    List<Mision> findAll();
    Mision findById(int id);
    Mision save(Mision producto);
    void delete(Mision p);
}
