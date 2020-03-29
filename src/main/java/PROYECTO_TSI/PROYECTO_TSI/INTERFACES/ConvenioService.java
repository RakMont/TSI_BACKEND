package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Convenio;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Evento;

import java.util.List;

public interface ConvenioService {
    List<Convenio> listar();
    Convenio listarId(int id);
    Convenio agregar(Convenio p);
    Convenio edit(Convenio p);
    Convenio delete(int id);
}
