package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;


import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.TemaService;
import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.VisionService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Tema;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Vision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/temas"})
public class TemaController {

    @Autowired
    TemaService temaService;


    @GetMapping
    public List<Tema> listar() {
        return temaService.listar();
    }

    @PostMapping
    public Tema agregar(@RequestBody Tema p) {

        return temaService.agregar(p);
    }

    @GetMapping(path = {"/{id}"})
    public Tema listarId(@PathVariable("id") int id) {
        return temaService.listarId(id);
    }

    @PutMapping(path = {"/{id}"})
    public Tema editar(@RequestBody Tema p, @PathVariable("id") int id) {
        p.setId_tema(id);
        return temaService.edit(p);
    }


    @DeleteMapping(path = {"/{id}"})
    public Tema delete(@PathVariable("id") int id){
        return temaService.delete(id);
    }

}
