package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;


import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.HistoriaVidaAudioService;
import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.HistoriaVidaVideoService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaAudio;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/historiasHVA"})
public class HistoriaVidaAudioController {
    @Autowired
    HistoriaVidaAudioService historiaVidaAudioService;


    @GetMapping
    public List<HistoriaVidaAudio> listar() {
        return historiaVidaAudioService.listar();
    }

    @PostMapping
    public HistoriaVidaAudio agregar(@RequestBody HistoriaVidaAudio p) {
        return historiaVidaAudioService.agregar(p);
    }

    @GetMapping(path = {"/{id}"})
    public HistoriaVidaAudio listarId(@PathVariable("id") int id) {
        return historiaVidaAudioService.listarId(id);
    }

    @PutMapping(path = {"/{id}"})
    public HistoriaVidaAudio editar(@RequestBody HistoriaVidaAudio p, @PathVariable("id") int id) {
        p.setId_HVA(id);
        return historiaVidaAudioService.edit(p);
    }


    @DeleteMapping(path = {"/{id}"})
    public HistoriaVidaAudio delete(@PathVariable("id") int id){
        return historiaVidaAudioService.delete(id);
    }
}
