package PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Convenio;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Evento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConvenioRepository  extends CrudRepository<Convenio,Integer> {
    List<Convenio> findAll();
    Convenio findById(int id);
    Convenio save(Convenio evento);
    void delete(Convenio p);
}
