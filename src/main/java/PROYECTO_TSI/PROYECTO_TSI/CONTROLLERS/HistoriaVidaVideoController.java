package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;

import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.HistoriaVidaTextoService;
import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.HistoriaVidaVideoService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaTexto;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/historiasHVV"})
public class HistoriaVidaVideoController {
    @Autowired
    HistoriaVidaVideoService historiaVidaVideoService;


    @GetMapping
    public List<HistoriaVidaVideo> listar() {
        return historiaVidaVideoService.listar();
    }

    @PostMapping
    public HistoriaVidaVideo agregar(@RequestBody HistoriaVidaVideo p) {

        return historiaVidaVideoService.agregar(p);
    }

    @GetMapping(path = {"/{id}"})
    public HistoriaVidaVideo listarId(@PathVariable("id") int id) {
        return historiaVidaVideoService.listarId(id);
    }

    @PutMapping(path = {"/{id}"})
    public HistoriaVidaVideo editar(@RequestBody HistoriaVidaVideo p, @PathVariable("id") int id) {
        p.setId_HVV(id);
        return historiaVidaVideoService.edit(p);
    }


    @DeleteMapping(path = {"/{id}"})
    public HistoriaVidaVideo delete(@PathVariable("id") int id){
        return historiaVidaVideoService.delete(id);
    }
}
