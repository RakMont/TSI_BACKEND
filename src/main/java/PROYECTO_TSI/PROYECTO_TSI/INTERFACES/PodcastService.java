package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Podcast;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Tema;

import java.util.List;

public interface PodcastService {
    List<Podcast> listar();
    Podcast listarId(int id);
    Podcast agregar(Podcast p);
    Podcast edit(Podcast p);
    Podcast delete(int id);
}
