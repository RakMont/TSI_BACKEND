package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;


import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.TeOfrecemosService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.TeOfrecemos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/teOfrecemos"})
public class TeOfrecemosController {
    @Autowired
    TeOfrecemosService teOfrecemosService;


    @GetMapping(path = {"/becas"})
    public List<TeOfrecemos> listarBecas() {
        List<TeOfrecemos>list=teOfrecemosService.listar();
        List<TeOfrecemos> lista = new ArrayList<TeOfrecemos>();
        for( TeOfrecemos o:list){
            if(o.getTema().equals("Beca")){
                lista.add(o);
            }
        }
        return lista;
    }

    @GetMapping(path = {"/trabajos"})
    public List<TeOfrecemos> listarTrabajos() {
        List<TeOfrecemos>list=teOfrecemosService.listar();
        List<TeOfrecemos> lista = new ArrayList<TeOfrecemos>();
        //List<TeOfrecemos>returnList=null;
        for( TeOfrecemos o:list){
            if(o.getTema().equals("Trabajo")){
                lista.add(o);
            }
        }
        return lista;

    }

    @GetMapping(path = {"/viviendas"})
    public List<TeOfrecemos> listarViviendas() {
        List<TeOfrecemos>list=teOfrecemosService.listar();
        List<TeOfrecemos> lista = new ArrayList<TeOfrecemos>();
        for( TeOfrecemos o:list){
            if(o.getTema().equals("Vivienda")){
                lista.add(o);
            }
        }
        return lista;
    }


    @PostMapping(path = {"/beca"})
    public TeOfrecemos agregarBeca(@RequestBody TeOfrecemos p) {
        p.setTema("Beca");
        return teOfrecemosService.agregar(p);
    }

    @PostMapping(path = {"/trabajo"})
    public TeOfrecemos agregarTrabajo(@RequestBody TeOfrecemos p) {
        p.setTema("Trabajo");
        return teOfrecemosService.agregar(p);
    }

    @PostMapping(path = {"/vivienda"})
    public TeOfrecemos agregarVivienda(@RequestBody TeOfrecemos p) {
        p.setTema("Vivienda");
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
