package PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Mision;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.TeOfrecemos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeOfrecemosRepository extends CrudRepository<TeOfrecemos,Integer> {
    List<TeOfrecemos> findAll();
    TeOfrecemos findById(int id);
    TeOfrecemos save(TeOfrecemos teOfrecemos);
    void delete(TeOfrecemos p);
}
