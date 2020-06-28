package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;


import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.EventoService;
import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.MisionService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Evento;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Mision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/eventos"})
public class EventoController {
    @Autowired
    EventoService eventoService;


    @GetMapping
    public List<Evento> listar() {
        return eventoService.listar();
    }

    @PostMapping
    public Evento agregar(@RequestBody Evento p) {
        return eventoService.agregar(p);
    }

    @GetMapping(path = {"/{id}"})
    public Evento listarId(@PathVariable("id") int id) {
        return eventoService.listarId(id);
    }

    @PutMapping(path = {"/{id}"})
    public Evento editar(@RequestBody Evento p, @PathVariable("id") int id) {
        p.setId_evento(id);
        return eventoService.edit(p);
    }


    @DeleteMapping(path = {"/{id}"})
    public Evento delete(@PathVariable("id") int id){
        return eventoService.delete(id);
    }
}
