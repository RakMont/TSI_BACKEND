package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaAudio;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaTexto;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaVideo;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.HistoriaVidaAudioRepository;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.HistoriaVidaTextoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class HistoriaVidaAudioServiceImp implements HistoriaVidaAudioService{
    @Autowired
    private HistoriaVidaAudioRepository historiaVidaAudioRepository;

    @Override
    public List<HistoriaVidaAudio> listar(){
        List<HistoriaVidaAudio>list=historiaVidaAudioRepository.findAll();
        for( HistoriaVidaAudio o:list){
            System.out.println("date : "+o.getFecha());
        }
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

        String auxiliar = historiaVidaAudio.getArchivo_mp3();
        File fileToDelete = new File("src/main/webApp/historiaHVA/"+auxiliar);

        if (historiaVidaAudio!=null){
            historiaVidaAudioRepository.delete(historiaVidaAudio);
        }


        System.out.println("this is the name"+fileToDelete.getName());
        fileToDelete.delete();
        //boolean success = fileToDelete.delete();
       // System.out.println("this is the delete = "+success);

        return historiaVidaAudio;
    }

}
