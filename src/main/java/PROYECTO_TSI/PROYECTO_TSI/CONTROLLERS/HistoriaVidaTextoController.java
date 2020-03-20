package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;

import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.HistoriaVidaTextoService;
import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.MisionService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaTexto;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Mision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/historiasHVT"})
public class HistoriaVidaTextoController {
    @Autowired
    HistoriaVidaTextoService historiaVidaTextoService;


    @GetMapping
    public List<HistoriaVidaTexto> listar() {
        return historiaVidaTextoService.listar();
    }

    @PostMapping
    public HistoriaVidaTexto agregar(@RequestBody HistoriaVidaTexto p) {
        return historiaVidaTextoService.agregar(p);
    }

    @GetMapping(path = {"/{id}"})
    public HistoriaVidaTexto listarId(@PathVariable("id") int id) {
        return historiaVidaTextoService.listarId(id);
    }

    @PutMapping(path = {"/{id}"})
    public HistoriaVidaTexto editar(@RequestBody HistoriaVidaTexto p, @PathVariable("id") int id) {
        p.setId_HVT(id);
        return historiaVidaTextoService.edit(p);
    }


    @DeleteMapping(path = {"/{id}"})
    public HistoriaVidaTexto delete(@PathVariable("id") int id){
        return historiaVidaTextoService.delete(id);
    }
}
