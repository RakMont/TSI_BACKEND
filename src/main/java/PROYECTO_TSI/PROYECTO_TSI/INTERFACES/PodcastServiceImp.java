package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;


import PROYECTO_TSI.PROYECTO_TSI.MODELS.Podcast;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Tema;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.PodcastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
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
    public List<Podcast> listarPorTema(Tema tema){
        return podcastRepository.findByTema(tema);
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
        Podcast podcast=podcastRepository.findById(id);

        String auxiliar = podcast.getArchivoMP3();
        File fileToDelete = new File("src/main/webApp/podcasts/"+auxiliar);

        if (podcast!=null){
            podcastRepository.delete(podcast);

            fileToDelete.delete();

        }
        return podcast;
    }
}
