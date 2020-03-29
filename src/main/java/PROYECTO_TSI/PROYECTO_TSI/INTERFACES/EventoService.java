package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Evento;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaAudio;

import java.util.List;

public interface EventoService {
    List<Evento> listar();
    Evento listarId(int id);
    Evento agregar(Evento p);
    Evento edit(Evento p);
    Evento delete(int id);

}
