package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;


import PROYECTO_TSI.PROYECTO_TSI.MODELS.Convenio;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class ConvenioServiceImp implements ConvenioService {
    @Autowired
    private ConvenioRepository convenioRepository;

    @Override
    public List<Convenio> listar(){
        return convenioRepository.findAll();
    }

    @Override
    public Convenio listarId(int id){
        return convenioRepository.findById(id);
    }

    @Override
    public Convenio agregar(Convenio p){
        return convenioRepository.save(p);
    }

    @Override
    public Convenio edit(Convenio p){
        return convenioRepository.save(p);
    }

    @Override
    public Convenio delete(int id){
        Convenio convenio=convenioRepository.findById(id);

        String auxiliar = convenio.getImagen();
        File fileToDelete = new File("src/main/webApp/convenios/"+auxiliar);
        if (convenio!=null){
            convenioRepository.delete(convenio);

            fileToDelete.delete();

        }

        return convenio;
    }
}
