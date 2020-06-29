package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;


import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.PodcastService;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Podcast;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Tema;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.TemaRepository;
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
@RequestMapping({"/podcasts"})
public class PodcastController {
    @Autowired
    PodcastService podcastService;
    @Autowired
    private TemaRepository temaRepository;
    @Autowired
    ServletContext context;


    @PostMapping(value = "UpdatePodcastFile")
    public ResponseEntity<Response> UpdatePodcastFile(@RequestParam("file") Optional<MultipartFile> file2, @RequestParam("podcast") String podcast) throws JsonParseException, JsonMappingException, IOException {

        Podcast podcast1 = new ObjectMapper().readValue(podcast, Podcast.class);
            if (file2.isPresent()) {
                MultipartFile file = file2.get();
                if (podcast1.getArchivoMP3().equals(file.getOriginalFilename())) {
                    podcastService.edit(podcast1);
                    return new ResponseEntity<Response>(new Response("historia saved succesfull"), HttpStatus.OK);
                } else {
                    if (podcast1.getArchivoMP3().equals(file.getOriginalFilename())) {
                        podcastService.edit(podcast1);
                        return new ResponseEntity<Response>(new Response("Audio saved succesfull"), HttpStatus.OK);
                    } else {

                        String auxiliar = podcast1.getArchivoMP3();
                        File fileToDelete = new File("src/main/webApp/podcasts/" + auxiliar);
                        fileToDelete.delete();

                        podcast1.setArchivoMP3(file.getOriginalFilename());

                        boolean isExist = new java.io.File(context.getRealPath("/podcasts/")).exists();
                        if (!isExist) {
                            new java.io.File(context.getRealPath("/podcasts/")).mkdir();
                        }
                        String filename = file.getOriginalFilename();
                        String modifiedFilename = FilenameUtils.getBaseName(filename) + "_" + System.currentTimeMillis() + "." + FilenameUtils.getExtension(filename);

                        File serverfile = new java.io.File(context.getRealPath("/podcasts/" + java.io.File.separator + modifiedFilename));

                        try {
                            FileUtils.writeByteArrayToFile(serverfile, file.getBytes());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        podcast1.setArchivoMP3(modifiedFilename);

                        Date date = Date.valueOf(LocalDate.now());
                        podcast1.setFecha(date);
                        Podcast podcast2 = podcastService.edit(podcast1);

                    }
                }
            } else {
                podcastService.edit(podcast1);
                return new ResponseEntity<Response>(new Response("Convenio saved succesfull"), HttpStatus.OK);
            }
            if (podcast1 != null) {
                return new ResponseEntity<Response>(new Response("Audio saved succesfull"), HttpStatus.OK);

            } else {
                return new ResponseEntity<Response>(new Response("Audio not saved"), HttpStatus.BAD_REQUEST);

            }



    }



    //////////////////////////////////////////////
    ////////////////////////////////////////////////////////
    @GetMapping(value = "/getPodcastAllAudios")
    @CrossOrigin
    public ResponseEntity<List<String>> getPodcastAllAudios() {
        List<String> podcasts=new ArrayList<String>();
        String filesPath =context.getRealPath("/podcasts");

        /////////////////////////////////////////////////////
        List<Podcast>list=podcastService.listar();
        List<Podcast> lista = new ArrayList<Podcast>();
        int aux=1;
        int lenght=list.size();
        for( Podcast o:list){
            lista.add(list.get(lenght-aux));
            aux++;
        }
        ///////////////////////////////////////////////////
        File folder =new File(filesPath);
        File filefolder =new File(filesPath);

        if (filefolder!=null){
            for (Podcast o:lista){
                for (final File file:filefolder.listFiles()){

                    if (o.getArchivoMP3().equals(file.getName())){
                        if(!file.isDirectory()){
                            String encodeBase64=null;
                            try{
                                String extension= FilenameUtils.getExtension(file.getName());
                                FileInputStream fileInputStream=new FileInputStream(file);
                                byte[]bytes=new byte[(int)file.length()];
                                fileInputStream.read(bytes);
                                encodeBase64= Base64.getEncoder().encodeToString(bytes);
                                podcasts.add("data:audio/"+extension+";base64,"+encodeBase64);
                                fileInputStream.close();;

                            }catch(Exception e){


                            }
                        }
                    }

                }
            }

        }

        return new ResponseEntity<List<String>>(podcasts, HttpStatus.OK);
    }
    ////////////////////////////////////////////


    @GetMapping
    public List<Podcast> listar() {
        List<Podcast>list=podcastService.listar();
        List<Podcast> lista = new ArrayList<Podcast>();
        int aux=1;
        int lenght=list.size();
        for( Podcast o:list){
            lista.add(list.get(lenght-aux));
            aux++;
        }
        return lista;
    }
    @GetMapping(path = {"/listarByEspecie/{id}"})
    public List<Podcast> listarByEspecie(@PathVariable("id") int id) {
        Tema tema=temaRepository.findById(id);
        String  temaName = tema.getNombreTema();
        return podcastService.listarPorTema(tema);
    }

    //////////////////////////////////////////////
    @GetMapping(value = "/getPodcastAudiosByTema/{id}")
    @CrossOrigin
    public ResponseEntity<List<String>> getPodcastAudiosByTema(@PathVariable("id") int id) {
        List<String> podcasts=new ArrayList<String>();
        String filesPath =context.getRealPath("/podcasts");

        Tema tema=temaRepository.findById(id);
        String  temaName = tema.getNombreTema();
        List<Podcast>list=podcastService.listarPorTema(tema);
        List<Podcast> lista = new ArrayList<Podcast>();
        int aux=1;
        int lenght=list.size();
        for( Podcast o:list){
            lista.add(list.get(lenght-aux));
            aux++;
        }

        File folder =new File(filesPath);
        File filefolder =new File(filesPath);

        if (filefolder!=null){
            for (Podcast o:lista){
                for (final File file:filefolder.listFiles()){

                    if (o.getArchivoMP3().equals(file.getName())){
                        if(!file.isDirectory()){
                            String encodeBase64=null;
                            try{
                                String extension= FilenameUtils.getExtension(file.getName());
                                FileInputStream fileInputStream=new FileInputStream(file);
                                byte[]bytes=new byte[(int)file.length()];
                                fileInputStream.read(bytes);
                                encodeBase64= Base64.getEncoder().encodeToString(bytes);
                                podcasts.add("data:audio/"+extension+";base64,"+encodeBase64);
                                fileInputStream.close();;

                            }catch(Exception e){


                            }
                        }
                    }

                }
            }

        }

        return new ResponseEntity<List<String>>(podcasts, HttpStatus.OK);

    }
    //////////////////////////////////////////////
    @PostMapping
    public Podcast agregar(@RequestBody Podcast p) {

        Date date = Date.valueOf(LocalDate.now());
        p.setFecha(date);
        return podcastService.agregar(p);
    }

    @GetMapping(path = {"/{id}"})
    public Podcast listarId(@PathVariable("id") int id) {
        return podcastService.listarId(id);
    }




    @PutMapping(path = {"/{id}"})
    public Podcast editar(@RequestBody Podcast p, @PathVariable("id") int id) {
        p.setId_podcast(id);
        Date date = Date.valueOf(LocalDate.now());
        p.setFecha(date);
        return podcastService.edit(p);
    }


    @DeleteMapping(path = {"/{id}"})
    public Podcast delete(@PathVariable("id") int id){
        return podcastService.delete(id);
    }



    @PostMapping(value = "savePodcastFile")
    public ResponseEntity<Response> saveAudioFile(@RequestParam("file") MultipartFile file, @RequestParam("podcast")String podcast)throws JsonParseException, JsonMappingException, IOException
    {
        Podcast podcast1=new ObjectMapper().readValue(podcast,Podcast.class);
        if (podcastService.agregar(podcast1)!=null){
            podcast1.setArchivoMP3(file.getOriginalFilename());
            boolean isExist = new java.io.File(context.getRealPath("/podcasts/")).exists();
            if(!isExist){
                new java.io.File(context.getRealPath("/podcasts/")).mkdir();
            }
            String filename = file.getOriginalFilename();
            String modifiedFilename= FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
            File serverfile=new java.io.File(context.getRealPath("/podcasts/"+ java.io.File.separator+modifiedFilename));

            try{
                FileUtils.writeByteArrayToFile(serverfile,file.getBytes());
            }catch (Exception e){
                e.printStackTrace();
            }
            podcast1.setArchivoMP3(modifiedFilename);

            Date date = Date.valueOf(LocalDate.now());
            podcast1.setFecha(date);
            Podcast podcast2=podcastService.agregar(podcast1);
            if(podcast2!=null){
                return new ResponseEntity<Response>(new Response("Audio saved succesfull"), HttpStatus.OK);

            }else{
                return new ResponseEntity<Response>(new Response("Audio not saved"), HttpStatus.BAD_REQUEST);

            }
        }
        else{
            return new ResponseEntity<Response>(new Response("Audio not saved"), HttpStatus.BAD_REQUEST);
        }

    }

}
