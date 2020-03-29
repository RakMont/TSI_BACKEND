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
        String aux,aux2;
        char []data=new char[11];
        int i2=0;
        aux=p.getVideo_HVV();

        char []data2=aux.toCharArray();
        System.out.println("HOLAAAA ESTE ES EL URL"+data2+" "+aux.length());
       for (int i=0;i<aux.length();i++){
            if (i>=32 & i<=42){
                data[i2]=data2[i];
                i2++;
                System.out.println("HOLAAAA"+data2[i]);
            }
        }
       aux=String.copyValueOf(data);
        p.setVideo_HVV(aux);
        System.out.println("HOLAAAA"+aux);

        return historiaVidaVideoRepository.save(p);
    }

    @Override
    public HistoriaVidaVideo edit(HistoriaVidaVideo p){
        String aux,aux2;
        char []data=new char[11];
        int i2=0;
        aux=p.getVideo_HVV();

        char []data2=aux.toCharArray();
        System.out.println("HOLAAAA ESTE ES EL URL"+data2+" "+aux.length());
        for (int i=0;i<aux.length();i++){
            if (i>=32 & i<=42){
                data[i2]=data2[i];
                i2++;
                System.out.println("HOLAAAA"+data2[i]);
            }
        }
        aux=String.copyValueOf(data);
        p.setVideo_HVV(aux);
        System.out.println("HOLAAAA"+aux);
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
