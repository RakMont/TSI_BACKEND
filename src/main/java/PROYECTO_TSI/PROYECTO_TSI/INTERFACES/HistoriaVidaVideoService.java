package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaTexto;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaVideo;

import java.util.List;

public interface HistoriaVidaVideoService {
    List<HistoriaVidaVideo> listar();
    HistoriaVidaVideo listarId(int id);
    HistoriaVidaVideo agregar(HistoriaVidaVideo p);
    HistoriaVidaVideo edit(HistoriaVidaVideo p);
    HistoriaVidaVideo delete(int id);
}
