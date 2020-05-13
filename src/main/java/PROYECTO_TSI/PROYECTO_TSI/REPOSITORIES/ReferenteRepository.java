package PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Referente;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Tema;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReferenteRepository extends CrudRepository<Referente,Integer> {
    List<Referente> findAll();
    Referente findById(int id);
    Referente save(Referente referente);
    void delete(Referente referente);
}
