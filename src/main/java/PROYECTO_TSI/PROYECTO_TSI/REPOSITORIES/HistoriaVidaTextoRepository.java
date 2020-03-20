package PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaTexto;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaVideo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistoriaVidaTextoRepository extends CrudRepository<HistoriaVidaTexto,Integer> {
    List<HistoriaVidaTexto> findAll();
    HistoriaVidaTexto findById(int id);
    HistoriaVidaTexto save(HistoriaVidaTexto producto);
    void delete(HistoriaVidaTexto p);
}
