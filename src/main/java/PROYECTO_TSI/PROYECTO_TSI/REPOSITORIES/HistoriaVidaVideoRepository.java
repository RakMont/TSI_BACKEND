package PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaVideo;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Mision;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistoriaVidaVideoRepository extends CrudRepository<HistoriaVidaVideo,Integer> {
    List<HistoriaVidaVideo> findAll();
    HistoriaVidaVideo findById(int id);
    HistoriaVidaVideo save(HistoriaVidaVideo producto);
    void delete(HistoriaVidaVideo p);
}
