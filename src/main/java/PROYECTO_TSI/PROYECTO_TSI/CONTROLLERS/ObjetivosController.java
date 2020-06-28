package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;

import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.ObjetivosService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Mision;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Objetivos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/objetivos"})
public class ObjetivosController {
    @Autowired
    ObjetivosService objetivosService;


    @GetMapping
    public List<Objetivos> listar() {
        return objetivosService.listar();
    }

    @PostMapping
    public Objetivos agregar(@RequestBody Objetivos p) {
        return objetivosService.agregar(p);
    }

    @GetMapping(path = {"/{id}"})
    public Objetivos listarId(@PathVariable("id") int id) {
        return objetivosService.listarId(id);
    }

    @PutMapping(path = {"/{id}"})
    public Objetivos editar(@RequestBody Objetivos p, @PathVariable("id") int id) {
        p.setId_objetivos(id);
        return objetivosService.edit(p);
    }


    @DeleteMapping(path = {"/{id}"})
    public Objetivos delete(@PathVariable("id") int id){
        return objetivosService.delete(id);
    }
}
