package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Objetivos;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.ObjetivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetivosServiceImp implements ObjetivosService{
    @Autowired
    private ObjetivosRepository objetivosRepository;

    @Override
    public List<Objetivos> listar(){
        return objetivosRepository.findAll();
    }

    @Override
    public Objetivos listarId(int id){
        return objetivosRepository.findById(id);
    }

    @Override
    public Objetivos agregar(Objetivos p){
        return objetivosRepository.save(p);
    }

    @Override
    public Objetivos edit(Objetivos p){
        return objetivosRepository.save(p);
    }

    @Override
    public Objetivos delete(int id){
        Objetivos p = objetivosRepository.findById(id);
        if(p!=null){
            objetivosRepository.delete(p);
        }
        return p;
    }
}
