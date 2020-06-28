package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;


import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.HistoriaVidaVideoService;
import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.ReferenteService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaVideo;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Referente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/referentes"})
public class ReferenteController {
    @Autowired
    ReferenteService referenteService;

//////////////////////////////////////////////////////////

    @GetMapping(path = {"/getReferenteTrabajo"})
    public Referente getReferenteTrabajo() {
        List<Referente> lista=referenteService.listar();
        Referente trabajo=lista.get(0);
        //return referenteService.listarId(id);
        return trabajo;
    }
    @GetMapping(path = {"/getReferenteVivienda"})
    public Referente getReferenteVivienda() {
        List<Referente> lista=referenteService.listar();
        Referente trabajo=lista.get(1);
        //return referenteService.listarId(id);
        return trabajo;
    }
    @GetMapping(path = {"/getReferenteEducacion"})
    public Referente getReferenteEducacion() {
        List<Referente> lista=referenteService.listar();
        Referente trabajo=lista.get(2);
        //return referenteService.listarId(id);
        return trabajo;
    }
    @GetMapping(path = {"/getReferenteSalud"})
    public Referente getReferenteSalud() {
        List<Referente> lista=referenteService.listar();
        Referente trabajo=lista.get(3);
        //return referenteService.listarId(id);
        return trabajo;
    }

//////////////////////////////////////////////////////////


    @GetMapping
    public List<Referente> listar() {
        return referenteService.listar();
    }

    @PostMapping
    public Referente agregar(@RequestBody Referente p) {

        return referenteService.agregar(p);
    }




    @GetMapping(path = {"/{id}"})
    public Referente listarId(@PathVariable("id") int id) {
        return referenteService.listarId(id);
    }
    @PutMapping(path = {"/{id}"})
    public Referente editar(@RequestBody Referente p, @PathVariable("id") int id) {
        p.setId_referente(id);

        return referenteService.edit(p);
    }
///////////////////////////////////////////////////////EDITAR


    @PutMapping(path = {"/editarReferenteTrabajo"})
    public Referente editarReferenteTrabajo(@RequestBody Referente p) {
        System.out.println("reftrabajo");
        p.setId_referente(1);
        return referenteService.edit(p);
    }
    @PutMapping(path = {"/editarReferenteVivienda"})
    public Referente editarReferenteVivienda(@RequestBody Referente p) {
        System.out.println("refvivienda");

        p.setId_referente(2);
        return referenteService.edit(p);
    }
    @PutMapping(path = {"/editarReferenteEducacion"})
    public Referente editarReferenteEducacion(@RequestBody Referente p) {
        System.out.println("refeducacion");

        p.setId_referente(3);
        return referenteService.edit(p);
    }
    @PutMapping(path = {"/editarReferenteSalud"})
    public Referente editarReferenteSalud(@RequestBody Referente p) {
        System.out.println("refsalud");

        p.setId_referente(4);
        return referenteService.edit(p);
    }
///////////////////////////////////////////////////////EDITAR

    @DeleteMapping(path = {"/{id}"})
    public Referente delete(@PathVariable("id") int id){
        return referenteService.delete(id);
    }
}
