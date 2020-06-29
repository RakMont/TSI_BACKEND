package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;


import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaVideo;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.HistoriaVidaVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class HistoriaVidaVideoServiceImp implements HistoriaVidaVideoService{
    @Autowired
    private HistoriaVidaVideoRepository historiaVidaVideoRepository;

    @Override
    public List<HistoriaVidaVideo> listar(){
        List<HistoriaVidaVideo>list=historiaVidaVideoRepository.findAll();

        return historiaVidaVideoRepository.findAll();
    }

    @Override
    public HistoriaVidaVideo listarId(int id){
        return historiaVidaVideoRepository.findById(id);
    }

    @Override
    public HistoriaVidaVideo agregar(HistoriaVidaVideo p){
        Date date = Date.valueOf(LocalDate.now());
        String aux,aux2;
        char []data=new char[11];
        int i2=0;
        aux=p.getVideo_HVV();

        char []data2=aux.toCharArray();
       for (int i=0;i<aux.length();i++){
            if (i>=32 & i<=42){
                data[i2]=data2[i];
                i2++;
            }
        }
       aux=String.copyValueOf(data);
        p.setVideo_HVV(aux);
        p.setFecha(date);
        return historiaVidaVideoRepository.save(p);
    }

    @Override
    public HistoriaVidaVideo edit(HistoriaVidaVideo p){
        Date date = Date.valueOf(LocalDate.now());
        String aux,aux2;
        char []data=new char[11];
        int i2=0;
        aux=p.getVideo_HVV();

        char []data2=aux.toCharArray();
        for (int i=0;i<aux.length();i++){
            if (i>=32 & i<=42){
                data[i2]=data2[i];
                i2++;
            }
        }
        aux=String.copyValueOf(data);
        p.setVideo_HVV(aux);
        p.setFecha(date);
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
