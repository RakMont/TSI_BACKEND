package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;


import PROYECTO_TSI.PROYECTO_TSI.MODELS.Comentario;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaTexto;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.ComentarioRepository;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.HistoriaVidaTextoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class ComentarioServiceImp implements ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Override
    public List<Comentario> listar(){
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario listarId(int id){
        return comentarioRepository.findById(id);
    }

    @Override
    public Comentario agregar(Comentario p){
        Date date = Date.valueOf(LocalDate.now());
        p.setFecha(date);
        return comentarioRepository.save(p);
    }

    @Override
    public Comentario edit(Comentario p){
        Date date = Date.valueOf(LocalDate.now());
        p.setFecha(date);
        return comentarioRepository.save(p);
    }

    @Override
    public Comentario delete(int id){
        Comentario comentario=comentarioRepository.findById(id);
        if (comentario!=null){
            comentarioRepository.delete(comentario);
        }
        return comentario;
    }
}
