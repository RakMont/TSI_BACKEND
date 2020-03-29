package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;


import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.ConvenioService;
import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.EventoService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Convenio;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/convenios"})
public class ConvenioController {
    @Autowired
    ConvenioService convenioService;


    @GetMapping
    public List<Convenio> listar() {
        return convenioService.listar();
    }

    @PostMapping
    public Convenio agregar(@RequestBody Convenio p) {
        return convenioService.agregar(p);
    }

    @GetMapping(path = {"/{id}"})
    public Convenio listarId(@PathVariable("id") int id) {
        return convenioService.listarId(id);
    }

    @PutMapping(path = {"/{id}"})
    public Convenio editar(@RequestBody Convenio p, @PathVariable("id") int id) {
        p.setId_convenio(id);
        return convenioService.edit(p);
    }


    @DeleteMapping(path = {"/{id}"})
    public Convenio delete(@PathVariable("id") int id){
        return convenioService.delete(id);
    }
}
