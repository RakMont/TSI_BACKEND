package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;


import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.HistoriaVidaTextoService;
import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.TeOfrecemosService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaTexto;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.TeOfrecemos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/teOfrecemos"})
public class TeOfrecemosController {
    @Autowired
    TeOfrecemosService teOfrecemosService;


    @GetMapping
    public List<TeOfrecemos> listar() {
        return teOfrecemosService.listar();
    }

    @PostMapping
    public TeOfrecemos agregar(@RequestBody TeOfrecemos p) {
        return teOfrecemosService.agregar(p);
    }

    @GetMapping(path = {"/{id}"})
    public TeOfrecemos listarId(@PathVariable("id") int id) {
        return teOfrecemosService.listarId(id);
    }

    @PutMapping(path = {"/{id}"})
    public TeOfrecemos editar(@RequestBody TeOfrecemos p, @PathVariable("id") int id) {
        p.setId_teOfrecemos(id);
        return teOfrecemosService.edit(p);
    }


    @DeleteMapping(path = {"/{id}"})
    public TeOfrecemos delete(@PathVariable("id") int id){
        return teOfrecemosService.delete(id);
    }
}
