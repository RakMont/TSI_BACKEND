package PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Evento;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaAudio;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Mision;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistoriaVidaAudioRepository extends CrudRepository<HistoriaVidaAudio,Integer> {
    List<HistoriaVidaAudio> findAll();
    HistoriaVidaAudio findById(int id);
    HistoriaVidaAudio save(HistoriaVidaAudio historiaVidaAudio);
    void delete(HistoriaVidaAudio p);
}
