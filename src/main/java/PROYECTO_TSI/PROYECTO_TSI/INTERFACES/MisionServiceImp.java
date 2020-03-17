package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Mision;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.MisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MisionServiceImp implements MisionService{
    @Autowired
    private MisionRepository misionRepository;

    @Override
    public List<Mision> listar(){
        return misionRepository.findAll();
    }

    @Override
    public Mision listarId(int id){
        return misionRepository.findById(id);
    }

    @Override
    public Mision agregar(Mision p){
        return misionRepository.save(p);
    }

    @Override
    public Mision edit(Mision p){
        return misionRepository.save(p);
    }

    @Override
    public Mision delete(int id){
        Mision mision=misionRepository.findById(id);
        if (mision!=null){
            misionRepository.delete(mision);
        }
        return mision;
    }
}
