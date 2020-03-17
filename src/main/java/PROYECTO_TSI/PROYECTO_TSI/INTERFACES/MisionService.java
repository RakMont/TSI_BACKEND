package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Mision;

import java.util.List;

public interface MisionService {
    List<Mision> listar();
    Mision listarId(int id);
    Mision agregar(Mision p);
    Mision edit(Mision p);
    Mision delete(int id);
}
