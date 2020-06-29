package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;


import PROYECTO_TSI.PROYECTO_TSI.MODELS.Tema;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaServiceImp implements TemaService {
    @Autowired
    private TemaRepository temaRepository;

    @Override
    public List<Tema> listar(){
        return temaRepository.findAll();
    }

    @Override
    public Tema listarId(int id){
        return temaRepository.findById(id);

    }

    @Override
    public Tema agregar(Tema p){
        return temaRepository.save(p);
    }

    @Override
    public Tema edit(Tema p){
        return temaRepository.save(p);
    }

    @Override
    public Tema delete(int id){
        Tema p = temaRepository.findById(id);
        if(p!=null){
            temaRepository.delete(p);
        }
        return p;
    }
}
