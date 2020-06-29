package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;


import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.ConvenioService;
import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.EventoService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Convenio;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Evento;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaAudio;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/convenios"})
public class ConvenioController {
    @Autowired
    ConvenioService convenioService;
    @Autowired
    ServletContext context;


    @GetMapping(value = "/getConvenios")
    @CrossOrigin
    public ResponseEntity<List<String>> getConvenios() {
        List<String> photos=new ArrayList<String>();
        String filesPath =context.getRealPath("/convenios");
        //////////////////////////////////////////////
        List<Convenio>list=convenioService.listar();
        List<Convenio> lista = new ArrayList<Convenio>();
        int aux=1;
        int lenght=list.size();
        for( Convenio o:list){
            lista.add(list.get(lenght-aux));
            aux++;
        }

        ////////////////////////////////////////
        File filefolder =new File(filesPath);

        if (filefolder!=null){
            for (Convenio o:lista){
                for (final File file:filefolder.listFiles()){
                    if (o.getImagen().equals(file.getName())){
                        if(!file.isDirectory()){
                            String encodeBase64=null;
                            try{
                                String extension=FilenameUtils.getExtension(file.getName());
                                FileInputStream fileInputStream=new FileInputStream(file);
                                byte[]bytes=new byte[(int)file.length()];
                                fileInputStream.read(bytes);
                                encodeBase64= Base64.getEncoder().encodeToString(bytes);
                                photos.add("data:image/"+extension+";base64,"+encodeBase64);
                                fileInputStream.close();;

                            }catch(Exception e){


                            }
                        }
                    }


            }

            }
        }

        return new ResponseEntity<List<String>>(photos,HttpStatus.OK);
    }
    @GetMapping
    public List<Convenio> listar() {
        List<Convenio>list=convenioService.listar();
        List<Convenio> lista = new ArrayList<Convenio>();
        int aux=1;
        int lenght=list.size();
        for( Convenio o:list){
            lista.add(list.get(lenght-aux));
            aux++;
        }
        return lista;
    }

    @PostMapping
    public Convenio agregar(@RequestBody Convenio p) {
        return convenioService.agregar(p);
    }



    @PostMapping(value = "saveConvenioFile")
    public ResponseEntity<Response> saveConvenioFile(@RequestParam("file") MultipartFile file, @RequestParam("convenio")String convenio)throws JsonParseException, JsonMappingException, IOException
    {
        Convenio convenio1=new ObjectMapper().readValue(convenio,Convenio.class);
        convenio1.setImagen(file.getOriginalFilename());
        boolean isExist = new java.io.File(context.getRealPath("/convenios/")).exists();
        if(!isExist){
            new java.io.File(context.getRealPath("/convenios/")).mkdir();
        }
        String filename = file.getOriginalFilename();
        String modifiedFilename= FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);

        File serverfile=new java.io.File(context.getRealPath("/convenios/"+ java.io.File.separator+modifiedFilename));

        try{
            FileUtils.writeByteArrayToFile(serverfile,file.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        convenio1.setImagen(modifiedFilename);

        Convenio historiaVidaAudio1=convenioService.agregar(convenio1);
        if(convenio1!=null){
            return new ResponseEntity<Response>(new Response("Convenio saved succesfull"), HttpStatus.OK);

        }else{
            return new ResponseEntity<Response>(new Response("Convenio not saved"), HttpStatus.BAD_REQUEST);

        }
    }


    @PostMapping(value = "UpdateConvenioFile")
    public ResponseEntity<Response> UpdateConvenioFile(@RequestParam("file") Optional<MultipartFile> file2, @RequestParam("convenio")String convenio)throws JsonParseException, JsonMappingException, IOException
    {
        Convenio convenio1=new ObjectMapper().readValue(convenio,Convenio.class);
        if (file2.isPresent()){
            MultipartFile file=file2.get();
            if (convenio1.getImagen().equals(file.getOriginalFilename()))
            {
                convenioService.edit(convenio1);
                return new ResponseEntity<Response>(new Response("Convenio saved succesfull"), HttpStatus.OK);
            }
            else{
                String auxiliar = convenio1.getImagen();
                File fileToDelete = new File("src/main/webApp/convenios/"+auxiliar);
                fileToDelete.delete();

                convenio1.setImagen(file.getOriginalFilename());

                boolean isExist = new java.io.File(context.getRealPath("/convenios/")).exists();
                if(!isExist){
                    new java.io.File(context.getRealPath("/convenios/")).mkdir();
                }
                String filename = file.getOriginalFilename();
                String modifiedFilename= FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);

                File serverfile=new java.io.File(context.getRealPath("/convenios/"+ java.io.File.separator+modifiedFilename));

                try{
                    FileUtils.writeByteArrayToFile(serverfile,file.getBytes());
                }catch (Exception e){
                    e.printStackTrace();
                }
                convenio1.setImagen(modifiedFilename);


                Convenio convenio2= convenioService.edit(convenio1);

            }
        }
        else
        {
            convenioService.edit(convenio1);
            return new ResponseEntity<Response>(new Response("Convenio saved succesfull"), HttpStatus.OK);
        }


        if(convenio1!=null){
            return new ResponseEntity<Response>(new Response("convenios saved succesfull"), HttpStatus.OK);

        }else{
            return new ResponseEntity<Response>(new Response("convenios not saved"), HttpStatus.BAD_REQUEST);

        }
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
