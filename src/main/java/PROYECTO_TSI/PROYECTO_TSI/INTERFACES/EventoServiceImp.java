package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Evento;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImp implements EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> listar(){
        return eventoRepository.findAll();
    }

    @Override
    public Evento listarId(int id){
        return eventoRepository.findById(id);
    }

    @Override
    public Evento agregar(Evento p){
        return eventoRepository.save(p);
    }

    @Override
    public Evento edit(Evento p){
        return eventoRepository.save(p);
    }

    @Override
    public Evento delete(int id){
        Evento evento=eventoRepository.findById(id);
        if (evento!=null){
            eventoRepository.delete(evento);
        }
        return evento;
    }
}
