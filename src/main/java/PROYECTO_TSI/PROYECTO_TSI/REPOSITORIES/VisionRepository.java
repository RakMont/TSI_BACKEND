package PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Vision;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VisionRepository extends CrudRepository<Vision,Integer> {
    List<Vision> findAll();
    Vision findById(int id);
    Vision save(Vision producto);
    void delete(Vision p);
}
