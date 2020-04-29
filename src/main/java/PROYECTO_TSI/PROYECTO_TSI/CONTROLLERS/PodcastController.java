package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;


import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.PodcastService;
import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.TemaService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Podcast;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Tema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/podcasts"})
public class PodcastController {
    @Autowired
    PodcastService podcastService;


    @GetMapping
    public List<Podcast> listar() {
        return podcastService.listar();
    }

    @PostMapping
    public Podcast agregar(@RequestBody Podcast p) {

        Date date = Date.valueOf(LocalDate.now());
        p.setFecha(date);
        return podcastService.agregar(p);
    }

    @GetMapping(path = {"/{id}"})
    public Podcast listarId(@PathVariable("id") int id) {
        return podcastService.listarId(id);
    }

    @PutMapping(path = {"/{id}"})
    public Podcast editar(@RequestBody Podcast p, @PathVariable("id") int id) {
        p.setId_podcast(id);
        Date date = Date.valueOf(LocalDate.now());
        p.setFecha(date);
        return podcastService.edit(p);
    }


    @DeleteMapping(path = {"/{id}"})
    public Podcast delete(@PathVariable("id") int id){
        return podcastService.delete(id);
    }
}
