package PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Objetivos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ObjetivosRepository extends CrudRepository<Objetivos,Integer> {
    List<Objetivos> findAll();
    Objetivos findById(int id);
    Objetivos save(Objetivos producto);
    void delete(Objetivos p);
}
