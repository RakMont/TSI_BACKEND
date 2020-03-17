package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Vision;

import java.util.List;

public interface VisionService {
    List<Vision> listar();
    Vision listarId(int id);
    Vision agregar(Vision p);
    Vision edit(Vision p);
    Vision delete(int id);
}
