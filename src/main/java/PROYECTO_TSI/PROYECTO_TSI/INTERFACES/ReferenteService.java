package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Referente;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Tema;

import java.util.List;

public interface ReferenteService {
    List<Referente> listar();
    Referente listarId(int id);
    Referente agregar(Referente p);
    Referente edit(Referente p);
    Referente delete(int id);
}
