package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;


import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaTexto;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaVideo;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.HistoriaVidaTextoRepository;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.HistoriaVidaVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaVidaVideoServiceImp implements HistoriaVidaVideoService{
    @Autowired
    private HistoriaVidaVideoRepository historiaVidaVideoRepository;

    @Override
    public List<HistoriaVidaVideo> listar(){
        return historiaVidaVideoRepository.findAll();
    }

    @Override
    public HistoriaVidaVideo listarId(int id){
        return historiaVidaVideoRepository.findById(id);
    }

    @Override
    public HistoriaVidaVideo agregar(HistoriaVidaVideo p){
        return historiaVidaVideoRepository.save(p);
    }

    @Override
    public HistoriaVidaVideo edit(HistoriaVidaVideo p){
        return historiaVidaVideoRepository.save(p);
    }

    @Override
    public HistoriaVidaVideo delete(int id){
        HistoriaVidaVideo historiaVidaVideo=historiaVidaVideoRepository.findById(id);
        if (historiaVidaVideo!=null){
            historiaVidaVideoRepository.delete(historiaVidaVideo);
        }
        return historiaVidaVideo;
    }
}
