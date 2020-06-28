package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;

import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.MisionService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Mision;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Vision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)

@CrossOrigin(origins = "https://redejovenes.herokuapp.com",maxAge = 3600)
@RestController
@RequestMapping({"/misiones"})
public class MisionController {

    @Autowired
    MisionService misionService;


    @GetMapping
    public List<Mision> listar() {
        List<Mision>list=misionService.listar();
        for (Mision c:list){
            System.out.println("size is "+ c.getContenido().length());
        }
        return misionService.listar();
    }

    @PostMapping
    public Mision agregar(@RequestBody Mision p) {
        return misionService.agregar(p);
    }

    @GetMapping(path = {"/{id}"})
    public Mision listarId(@PathVariable("id") int id) {
        return misionService.listarId(id);
    }

    @PutMapping(path = {"/{id}"})
    public Mision editar(@RequestBody Mision p, @PathVariable("id") int id) {
        p.setId_mision(id);
        return misionService.edit(p);
    }


    @DeleteMapping(path = {"/{id}"})
    public Mision delete(@PathVariable("id") int id){
        return misionService.delete(id);
    }
}
