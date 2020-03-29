package PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Evento;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Mision;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventoRepository extends CrudRepository<Evento,Integer> {
    List<Evento> findAll();
    Evento findById(int id);
    Evento save(Evento evento);
    void delete(Evento p);
}
