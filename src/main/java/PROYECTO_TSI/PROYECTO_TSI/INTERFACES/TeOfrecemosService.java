package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Objetivos;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.TeOfrecemos;

import java.util.List;

public interface TeOfrecemosService {
    List<TeOfrecemos> listar();
    TeOfrecemos listarId(int id);
    TeOfrecemos agregar(TeOfrecemos p);
    TeOfrecemos edit(TeOfrecemos p);
    TeOfrecemos delete(int id);
}
