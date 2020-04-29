package PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Podcast;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Vision;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PodcastRepository extends CrudRepository<Podcast,Integer> {
    List<Podcast> findAll();
    Podcast findById(int id);
    Podcast save(Podcast podcast);
    void delete(Podcast p);
}
