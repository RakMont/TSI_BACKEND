package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;


import PROYECTO_TSI.PROYECTO_TSI.MODELS.TeOfrecemos;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.TeOfrecemosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeOfrecemosServiceImp implements TeOfrecemosService{
    @Autowired
    private TeOfrecemosRepository teOfrecemosRepository;

    @Override
    public List<TeOfrecemos> listar(){
        return teOfrecemosRepository.findAll();
    }

    @Override
    public TeOfrecemos listarId(int id){
        return teOfrecemosRepository.findById(id);
    }

    @Override
    public TeOfrecemos agregar(TeOfrecemos p){
        return teOfrecemosRepository.save(p);
    }

    @Override
    public TeOfrecemos edit(TeOfrecemos p){
        return teOfrecemosRepository.save(p);
    }

    @Override
    public TeOfrecemos delete(int id){
        TeOfrecemos p = teOfrecemosRepository.findById(id);
        if(p!=null){
            teOfrecemosRepository.delete(p);
        }
        return p;
    }
}
