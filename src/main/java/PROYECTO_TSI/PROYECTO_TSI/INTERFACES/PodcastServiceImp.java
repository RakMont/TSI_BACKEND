package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;


import PROYECTO_TSI.PROYECTO_TSI.MODELS.Podcast;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Vision;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.PodcastRepository;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.VisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PodcastServiceImp implements PodcastService {
    @Autowired
    private PodcastRepository podcastRepository;

    @Override
    public List<Podcast> listar(){
        return podcastRepository.findAll();
    }

    @Override
    public Podcast listarId(int id){
        return podcastRepository.findById(id);

    }

    @Override
    public Podcast agregar(Podcast p){
        return podcastRepository.save(p);
    }

    @Override
    public Podcast edit(Podcast p){
        return podcastRepository.save(p);
    }

    @Override
    public Podcast delete(int id){
        Podcast p = podcastRepository.findById(id);
        if(p!=null){
            podcastRepository.delete(p);
        }
        return p;
    }
}
