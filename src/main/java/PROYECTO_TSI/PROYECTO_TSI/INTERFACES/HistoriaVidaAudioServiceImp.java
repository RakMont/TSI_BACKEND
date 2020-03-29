package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaAudio;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaTexto;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.HistoriaVidaAudioRepository;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.HistoriaVidaTextoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaVidaAudioServiceImp implements HistoriaVidaAudioService{
    @Autowired
    private HistoriaVidaAudioRepository historiaVidaAudioRepository;

    @Override
    public List<HistoriaVidaAudio> listar(){
        return historiaVidaAudioRepository.findAll();
    }

    @Override
    public HistoriaVidaAudio listarId(int id){
        return historiaVidaAudioRepository.findById(id);
    }

    @Override
    public HistoriaVidaAudio agregar(HistoriaVidaAudio p){
        return historiaVidaAudioRepository.save(p);
    }

    @Override
    public HistoriaVidaAudio edit(HistoriaVidaAudio p){
        return historiaVidaAudioRepository.save(p);
    }

    @Override
    public HistoriaVidaAudio delete(int id){
        HistoriaVidaAudio historiaVidaAudio=historiaVidaAudioRepository.findById(id);
        if (historiaVidaAudio!=null){
            historiaVidaAudioRepository.delete(historiaVidaAudio);
        }
        return historiaVidaAudio;
    }

}
