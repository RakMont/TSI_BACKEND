package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;


import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.ComentarioService;
import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.HistoriaVidaTextoService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Comentario;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaAudio;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaTexto;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Referente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/comentarios"})
public class ComentarioController {

    @Autowired
    ComentarioService comentarioService;
///////////////////////////////////////////////////////////////////////////////////
    /*REFERENTE TRABAJO*/
@GetMapping(path = {"/listComentariosRawTrabajo"})
public List<Comentario> listComentariosRawTrabajo(){
    List<Comentario>list=comentarioService.listar();
    List<Comentario>returnList= new ArrayList<Comentario>();

    for (Comentario c:list){
        //System.out.println("size is "+ c.getComentario().length());
        if (c.getId_comentario_ref()==0 && c.getReferente()==1){
            returnList.add(c);
        }
    }
    return returnList;
}

    @GetMapping(path = {"/listComentariosTrabajo"})
    public List<Comentario> listComentariosTrabajo(){
        List<Comentario>list=comentarioService.listar();
        List<Comentario>returnList= new ArrayList<Comentario>();

        for (Comentario c:list){
            //System.out.println("size is "+ c.getComentario().length());
            if (c.getId_comentario_ref()!=0 && c.getReferente()==1){
                returnList.add(c);
            }
        }
        return returnList;
    }

///////////////////////////////////////////////////////////////////////////////////

// ///////////////////////////////////////////////////////////////////////////////
    /*REFERENTE VIVIENDA*/
@GetMapping(path = {"/listComentariosRawVivienda"})
public List<Comentario> listComentariosRawVivienda(){
    List<Comentario>list=comentarioService.listar();
    List<Comentario>returnList= new ArrayList<Comentario>();

    for (Comentario c:list){
        //System.out.println("size is "+ c.getComentario().length());
        if (c.getId_comentario_ref()==0 && c.getReferente()==2){
            returnList.add(c);
        }
    }
    return returnList;
}

    @GetMapping(path = {"/listComentariosVivienda"})
    public List<Comentario> listComentariosVivienda(){
        List<Comentario>list=comentarioService.listar();
        List<Comentario>returnList= new ArrayList<Comentario>();

        for (Comentario c:list){
            //System.out.println("size is "+ c.getComentario().length());
            if (c.getId_comentario_ref()!=0 && c.getReferente()==2){
                returnList.add(c);
            }
        }
        return returnList;
    }

///////////////////////////////////////////////////////////////////////////////////

// ///////////////////////////////////////////////////////////////////////////////
    /*REFERENTE EDUCACION*/
@GetMapping(path = {"/listComentariosRawEducacion"})
public List<Comentario> listComentariosRawEducacion(){
    List<Comentario>list=comentarioService.listar();
    List<Comentario>returnList= new ArrayList<Comentario>();

    for (Comentario c:list){
        //System.out.println("size is "+ c.getComentario().length());
        if (c.getId_comentario_ref()==0 && c.getReferente()==3){
            returnList.add(c);
        }
    }
    return returnList;
}

    @GetMapping(path = {"/listComentariosEducacion"})
    public List<Comentario> listComentariosEducacion(){
        List<Comentario>list=comentarioService.listar();
        List<Comentario>returnList= new ArrayList<Comentario>();

        for (Comentario c:list){
            //System.out.println("size is "+ c.getComentario().length());
            if (c.getId_comentario_ref()!=0 && c.getReferente()==3){
                returnList.add(c);
            }
        }
        return returnList;
    }

///////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////
    /*REFERENTE SALUD*/
    @GetMapping(path = {"/listComentariosRawSalud"})
    public List<Comentario> listComentariosRawSalud(){
        List<Comentario>list=comentarioService.listar();
        List<Comentario>returnList= new ArrayList<Comentario>();

        for (Comentario c:list){
            //System.out.println("size is "+ c.getComentario().length());
            if (c.getId_comentario_ref()==0 && c.getReferente()==4){
                returnList.add(c);
            }
        }
        return returnList;
    }

    @GetMapping(path = {"/listComentariosSalud"})
    public List<Comentario> listComentariosSalud(){
        List<Comentario>list=comentarioService.listar();
        List<Comentario>returnList= new ArrayList<Comentario>();

        for (Comentario c:list){
            //System.out.println("size is "+ c.getComentario().length());
            if (c.getId_comentario_ref()!=0 && c.getReferente()==4){
                returnList.add(c);
            }
        }
        return returnList;
    }

///////////////////////////////////////////////////////////////////////////////////

    @GetMapping
    public List<Comentario> listar() {
        List<Comentario>list=comentarioService.listar();
        for (Comentario c:list){
            System.out.println("size is "+ c.getComentario().length());
        }
        return comentarioService.listar();
    }

    @PostMapping
    public Comentario agregar(@RequestBody Comentario p) {
        return comentarioService.agregar(p);
    }
    @PostMapping(path = {"/agregarComentarioTrabajo"})
    public Comentario agregarComentarioTrabajo(@RequestBody Comentario p) {
        System.out.println("refsalud");

        p.setReferente(1);
        return comentarioService.agregar(p);
    }
    @PostMapping(path = {"/agregarComentarioVivienda"})
    public Comentario agregarComentarioVivienda(@RequestBody Comentario p) {
        System.out.println("refsalud");

        p.setReferente(2);
        return comentarioService.agregar(p);
    }
    @PostMapping(path = {"/agregarComentarioEducacion"})
    public Comentario agregarComentarioEducacion(@RequestBody Comentario p) {
        System.out.println("refsalud");

        p.setReferente(3);
        return comentarioService.agregar(p);
    }
    @PostMapping(path = {"/agregarComentarioSalud"})
    public Comentario agregarComentarioSalud(@RequestBody Comentario p) {
        System.out.println("refsalud");

        p.setReferente(4);
        return comentarioService.agregar(p);
    }


    @PutMapping(path = {"/editarComentarioTrabajo"})
    public Comentario editarComentarioTrabajo(@RequestBody Comentario p) {
        System.out.println("refsalud");

        p.setReferente(1);
        return comentarioService.edit(p);
    }
    @PutMapping(path = {"/editarComentarioVivienda"})
    public Comentario editarComentarioVivienda(@RequestBody Comentario p) {
        System.out.println("refsalud");

        p.setReferente(2);
        return comentarioService.edit(p);
    }
    @PutMapping(path = {"/editarComentarioEducacion"})
    public Comentario editarComentarioEducacion(@RequestBody Comentario p) {
        System.out.println("refsalud");

        p.setReferente(3);
        return comentarioService.edit(p);
    }
    @PutMapping(path = {"/editarComentarioSalud"})
    public Comentario editarComentarioSalud(@RequestBody Comentario p) {
        System.out.println("refsalud");

        p.setReferente(4);
        return comentarioService.edit(p);
    }


    @GetMapping(path = {"/{id}"})
    public Comentario listarId(@PathVariable("id") int id) {
        return comentarioService.listarId(id);
    }

    @PutMapping(path = {"/{id}"})
    public Comentario editar(@RequestBody Comentario p, @PathVariable("id") int id) {
        p.setId_comentario(id);
        return comentarioService.edit(p);
    }


    @DeleteMapping(path = {"/{id}"})
    public Comentario delete(@PathVariable("id") int id){
        return comentarioService.delete(id);
    }
}
