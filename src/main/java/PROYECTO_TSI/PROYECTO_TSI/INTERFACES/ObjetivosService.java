package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Mision;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Objetivos;

import java.util.List;

public interface ObjetivosService {
    List<Objetivos> listar();
    Objetivos listarId(int id);
    Objetivos agregar(Objetivos p);
    Objetivos edit(Objetivos p);
    Objetivos delete(int id);
}
