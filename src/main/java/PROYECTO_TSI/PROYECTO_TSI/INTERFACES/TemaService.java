package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Tema;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Vision;

import java.util.List;

public interface TemaService {
    List<Tema> listar();
    Tema listarId(int id);
    Tema agregar(Tema p);
    Tema edit(Tema p);
    Tema delete(int id);
}
