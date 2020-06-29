package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;

import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.VisionService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Vision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/visiones"})
public class VisionController {

    @Autowired
    VisionService visionService;


    @GetMapping
    public List<Vision> listar() {
        List<Vision>list=visionService.listar();

        return visionService.listar();
    }

    @PostMapping
    public Vision agregar(@RequestBody Vision p) {
        return visionService.agregar(p);
    }

    @GetMapping(path = {"/{id}"})
    public Vision listarId(@PathVariable("id") int id) {
        return visionService.listarId(id);
    }

    @PutMapping(path = {"/{id}"})
    public Vision editar(@RequestBody Vision p, @PathVariable("id") int id) {
        p.setId_vision(id);
        return visionService.edit(p);
    }


    @DeleteMapping(path = {"/{id}"})
    public Vision delete(@PathVariable("id") int id){
        return visionService.delete(id);
    }
}
