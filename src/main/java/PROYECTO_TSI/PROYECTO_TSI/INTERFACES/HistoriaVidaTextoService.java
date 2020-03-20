package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaTexto;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Mision;

import java.util.List;

public interface HistoriaVidaTextoService {
    List<HistoriaVidaTexto> listar();
    HistoriaVidaTexto listarId(int id);
    HistoriaVidaTexto agregar(HistoriaVidaTexto p);
    HistoriaVidaTexto edit(HistoriaVidaTexto p);
    HistoriaVidaTexto delete(int id);
}
