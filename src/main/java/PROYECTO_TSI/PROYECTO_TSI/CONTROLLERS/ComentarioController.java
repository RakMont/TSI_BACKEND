package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;


import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.ComentarioService;
import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.HistoriaVidaTextoService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.*;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.UserRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/comentarios"})
public class ComentarioController {

    @Autowired
    ComentarioService comentarioService;
    @Autowired
    ServletContext context;
    @Autowired
    UserRepository userRepository;

    public List<User> listuserscomentRawTrabajo(){
        List<Comentario>list=comentarioService.listar();
        List<Comentario>returnList= new ArrayList<Comentario>();

        for (Comentario c:list){
            System.out.println("size is "+c.toString());
            if (c.getId_comentario_ref()==0 && c.getReferente()==1){
                returnList.add(c);
            }
        }
        List<User> returnlist=new ArrayList<>();
        List<User>list2=userRepository.findAll();

        for (Comentario c:returnList){
            for (User u:list2){
                if (u.getId()==c.getUser().getId()){
                    returnlist.add(u);
                }
            }

        }

        return returnlist;
    }
    @GetMapping(value = "/getPhotosofrawtrabajocoments")
    @CrossOrigin
    public ResponseEntity<List<String>> getPhotosofrawtrabajocoments() {
        List<User> returnlist=listuserscomentRawTrabajo();

        List<String> historiaHVA=new ArrayList<String>();
        String filesPath =context.getRealPath("/profiles");

        /////////////////////////////////////////////////////

        ///////////////////////////////////////////////////
        File folder =new File(filesPath);
        File filefolder =new File(filesPath);

        for (User user  :returnlist){
            System.out.println("esto es la lista"+ user.getNombre());

        }

        if (filefolder!=null){
            for (User o:returnlist){
                for (final File file:filefolder.listFiles()){

                    if (o.getPerfil().equals(file.getName())){
                        System.out.println("image "+o.getPerfil());
                        if(!file.isDirectory()){
                            String encodeBase64=null;
                            try{
                                String extension= FilenameUtils.getExtension(file.getName());
                                FileInputStream fileInputStream=new FileInputStream(file);
                                byte[]bytes=new byte[(int)file.length()];
                                fileInputStream.read(bytes);
                                encodeBase64= Base64.getEncoder().encodeToString(bytes);
                                historiaHVA.add("data:image/"+extension+";base64,"+encodeBase64);
                                fileInputStream.close();;

                            }catch(Exception e){


                            }
                        }
                    }

                }
            }

        }

        return new ResponseEntity<List<String>>(historiaHVA, HttpStatus.OK);
    }

    ///////////////////////////////////////////////////////////////////////////////////
    /*REFERENTE TRABAJO*/
@GetMapping(path = {"/listComentariosRawTrabajo"})
public List<Comentario> listComentariosRawTrabajo(){
    List<Comentario>list=comentarioService.listar();
    List<Comentario>returnList= new ArrayList<Comentario>();

    for (Comentario c:list){
        System.out.println("size is "+c.toString());
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
        System.out.println("refTrabajo");

        System.out.println(p.getUser());
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
