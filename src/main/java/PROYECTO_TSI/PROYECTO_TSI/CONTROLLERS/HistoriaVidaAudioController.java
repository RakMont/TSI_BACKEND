package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;


import PROYECTO_TSI.PROYECTO_TSI.INTERFACES.HistoriaVidaAudioService;
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
@RequestMapping({"/historiasHVA"})
public class HistoriaVidaAudioController {
    @Autowired
    HistoriaVidaAudioService historiaVidaAudioService;
    @Autowired
    ServletContext context;



    @PostMapping(value = "saveAudioFile")
    public ResponseEntity<Response> saveAudioFile(@RequestParam("file") MultipartFile file,@RequestParam("audio")String audio)throws JsonParseException, JsonMappingException, IOException
    {
        HistoriaVidaAudio historiaVidaAudio=new ObjectMapper().readValue(audio,HistoriaVidaAudio.class);
        historiaVidaAudio.setArchivo_mp3(file.getOriginalFilename());
        boolean isExist = new java.io.File(context.getRealPath("/historiaHVA/")).exists();
        if(!isExist){
            new java.io.File(context.getRealPath("/historiaHVA/")).mkdir();
    }
        String filename = file.getOriginalFilename();
        String modifiedFilename= FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);

        File serverfile=new java.io.File(context.getRealPath("/historiaHVA/"+ java.io.File.separator+modifiedFilename));

        try{
            FileUtils.writeByteArrayToFile(serverfile,file.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        historiaVidaAudio.setArchivo_mp3(modifiedFilename);

        Date date = Date.valueOf(LocalDate.now());
        historiaVidaAudio.setFecha(date);
        HistoriaVidaAudio historiaVidaAudio1=historiaVidaAudioService.agregar(historiaVidaAudio);
        if(historiaVidaAudio!=null){
            return new ResponseEntity<Response>(new Response("Audio saved succesfull"), HttpStatus.OK);

        }else{
            return new ResponseEntity<Response>(new Response("Audio not saved"), HttpStatus.BAD_REQUEST);

        }
    }




    @PostMapping(value = "UpdateAudioFile")
    public ResponseEntity<Response> UpdateAudioFile(@RequestParam("file") Optional<MultipartFile> file2, @RequestParam("audio")String audio)throws JsonParseException, JsonMappingException, IOException
    {

        HistoriaVidaAudio historiaVidaAudio=new ObjectMapper().readValue(audio,HistoriaVidaAudio.class);
        if (file2.isPresent()) {
            MultipartFile file = file2.get();
            if (historiaVidaAudio.getArchivo_mp3().equals(file.getOriginalFilename())) {
                historiaVidaAudioService.edit(historiaVidaAudio);
                return new ResponseEntity<Response>(new Response("historia saved succesfull"), HttpStatus.OK);
            }
            else{
                if (historiaVidaAudio.getArchivo_mp3().equals(file.getOriginalFilename()))
                {
                    historiaVidaAudioService.edit(historiaVidaAudio);
                    return new ResponseEntity<Response>(new Response("Audio saved succesfull"), HttpStatus.OK);
                }
                else{

                    String auxiliar = historiaVidaAudio.getArchivo_mp3();
                    File fileToDelete = new File("src/main/webApp/historiaHVA/"+auxiliar);
                    fileToDelete.delete();

                    historiaVidaAudio.setArchivo_mp3(file.getOriginalFilename());

                    boolean isExist = new java.io.File(context.getRealPath("/historiaHVA/")).exists();
                    if(!isExist){
                        new java.io.File(context.getRealPath("/historiaHVA/")).mkdir();
                    }
                    String filename = file.getOriginalFilename();
                    String modifiedFilename= FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);

                    File serverfile=new java.io.File(context.getRealPath("/historiaHVA/"+ java.io.File.separator+modifiedFilename));

                    try{
                        FileUtils.writeByteArrayToFile(serverfile,file.getBytes());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    historiaVidaAudio.setArchivo_mp3(modifiedFilename);

                    Date date = Date.valueOf(LocalDate.now());
                    historiaVidaAudio.setFecha(date);
                    // HistoriaVidaAudio historiaVidaAudio1=historiaVidaAudioService.agregar(historiaVidaAudio);
                    HistoriaVidaAudio historiaVidaAudio1= historiaVidaAudioService.edit(historiaVidaAudio);

                }
            }
        }

        else
        {
            historiaVidaAudioService.edit(historiaVidaAudio);
            return new ResponseEntity<Response>(new Response("Convenio saved succesfull"), HttpStatus.OK);
        }
        if(historiaVidaAudio!=null){
            return new ResponseEntity<Response>(new Response("Audio saved succesfull"), HttpStatus.OK);

        }else{
            return new ResponseEntity<Response>(new Response("Audio not saved"), HttpStatus.BAD_REQUEST);

        }
    }



    @GetMapping(value = "/getHVAAudios")
    @CrossOrigin
    public ResponseEntity<List<String>> getHVAAudios() {
        List<String> historiaHVA=new ArrayList<String>();
        String filesPath =context.getRealPath("/historiaHVA");

        /////////////////////////////////////////////////////
        List<HistoriaVidaAudio>list=historiaVidaAudioService.listar();
        List<HistoriaVidaAudio> lista = new ArrayList<HistoriaVidaAudio>();
        int aux=1;
        int lenght=list.size();
        for( HistoriaVidaAudio o:list){
            lista.add(list.get(lenght-aux));
            aux++;
        }
        ///////////////////////////////////////////////////
        File folder =new File(filesPath);
        File filefolder =new File(filesPath);


        if (filefolder!=null){
            for (HistoriaVidaAudio o:lista){
                for (final File file:filefolder.listFiles()){

                    if (o.getArchivo_mp3().equals(file.getName())){
                        if(!file.isDirectory()){
                            String encodeBase64=null;
                            try{
                                String extension=FilenameUtils.getExtension(file.getName());
                                FileInputStream fileInputStream=new FileInputStream(file);
                                byte[]bytes=new byte[(int)file.length()];
                                fileInputStream.read(bytes);
                                encodeBase64= Base64.getEncoder().encodeToString(bytes);
                                historiaHVA.add("data:audio/"+extension+";base64,"+encodeBase64);
                                fileInputStream.close();;

                            }catch(Exception e){


                            }
                        }
                    }

                }
            }

        }

        return new ResponseEntity<List<String>>(historiaHVA,HttpStatus.OK);
    }

    @GetMapping
    public List<HistoriaVidaAudio> listar() {
        List<HistoriaVidaAudio>list=historiaVidaAudioService.listar();
        List<HistoriaVidaAudio> lista = new ArrayList<HistoriaVidaAudio>();
        int aux=1;
        int lenght=list.size();
        for( HistoriaVidaAudio o:list){
            lista.add(list.get(lenght-aux));
            aux++;
        }
        return lista;
    }

    @PostMapping
    public HistoriaVidaAudio agregar(@RequestBody HistoriaVidaAudio p) {
        return historiaVidaAudioService.agregar(p);
    }

    @GetMapping(path = {"/{id}"})
    public HistoriaVidaAudio listarId(@PathVariable("id") int id) {
        return historiaVidaAudioService.listarId(id);
    }

    @PutMapping(path = {"/{id}"})
    public HistoriaVidaAudio editar(@RequestBody HistoriaVidaAudio p, @PathVariable("id") int id) {
        p.setId_HVA(id);
        return historiaVidaAudioService.edit(p);
    }


    @DeleteMapping(path = {"/{id}"})
    public HistoriaVidaAudio delete(@PathVariable("id") int id)throws IOException{
        /*Path fileToDeletePath = Paths.get("src/test/resources/fileToDelete_jdk7.txt");
        Files.delete(fileToDeletePath);
        */
        return historiaVidaAudioService.delete(id);
    }
}
