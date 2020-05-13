package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Referente;
import PROYECTO_TSI.PROYECTO_TSI.MODELS.Tema;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.ReferenteRepository;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenteServiceImp implements ReferenteService{
    @Autowired
    private ReferenteRepository referenteRepository;

    @Override
    public List<Referente> listar(){
        return referenteRepository.findAll();
    }

    @Override
    public Referente listarId(int id){
        return referenteRepository.findById(id);

    }

    @Override
    public Referente agregar(Referente p){
        String aux,aux2;
        char []data=new char[11];
        int i2=0;
        aux=p.getVideo_referente();

        char []data2=aux.toCharArray();
        System.out.println("HOLAAAA ESTE ES EL URL"+data2+" "+aux.length());
        for (int i=0;i<aux.length();i++){
            if (i>=32 & i<=42){
                data[i2]=data2[i];
                i2++;
                System.out.println("HOLAAAA"+data2[i]);
            }
        }
        aux=String.copyValueOf(data);
        p.setVideo_referente(aux);
        System.out.println("HOLAAAA"+aux);
        return referenteRepository.save(p);
    }

    @Override
    public Referente edit(Referente p){
        String aux,aux2;
        char []data=new char[11];
        int i2=0;
        aux=p.getVideo_referente();

        char []data2=aux.toCharArray();
        System.out.println("HOLAAAA ESTE ES EL URL"+data2+" "+aux.length());
        for (int i=0;i<aux.length();i++){
            if (i>=32 & i<=42){
                data[i2]=data2[i];
                i2++;
                System.out.println("HOLAAAA"+data2[i]);
            }
        }
        aux=String.copyValueOf(data);
        p.setVideo_referente(aux);
        System.out.println("HOLAAAA"+aux);
        return referenteRepository.save(p);
    }

    @Override
    public Referente delete(int id){
        Referente p = referenteRepository.findById(id);
        if(p!=null){
            referenteRepository.delete(p);
        }
        return p;
    }
}
