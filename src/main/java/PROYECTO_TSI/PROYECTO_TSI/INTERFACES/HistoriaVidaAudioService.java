package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaAudio;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Mision;

import java.util.List;

public interface HistoriaVidaAudioService {
    List<HistoriaVidaAudio> listar();
    HistoriaVidaAudio listarId(int id);
    HistoriaVidaAudio agregar(HistoriaVidaAudio p);
    HistoriaVidaAudio edit(HistoriaVidaAudio p);
    HistoriaVidaAudio delete(int id);
}
