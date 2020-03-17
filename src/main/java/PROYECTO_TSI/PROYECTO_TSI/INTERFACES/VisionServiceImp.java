package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Vision;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.VisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisionServiceImp implements VisionService{
    @Autowired
    private VisionRepository productoRepository;

    @Override
    public List<Vision> listar(){
        return productoRepository.findAll();
    }

    @Override
    public Vision listarId(int id){
        return productoRepository.findById(id);

    }

    @Override
    public Vision agregar(Vision p){
        return productoRepository.save(p);
    }

    @Override
    public Vision edit(Vision p){
        return productoRepository.save(p);
    }

    @Override
    public Vision delete(int id){
        Vision p = productoRepository.findById(id);
        if(p!=null){
            productoRepository.delete(p);
        }
        return p;
    }
}
