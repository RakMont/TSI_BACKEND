package PROYECTO_TSI.PROYECTO_TSI.INTERFACES;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.HistoriaVidaTexto;
import PROYECTO_TSI.PROYECTO_TSI.REPOSITORIES.HistoriaVidaTextoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class HistoriaVidaTextoServiceImp implements HistoriaVidaTextoService  {
    @Autowired
    private HistoriaVidaTextoRepository historiaVidaTextoRepository;

    @Override
    public List<HistoriaVidaTexto> listar(){
        return historiaVidaTextoRepository.findAll();
    }

    @Override
    public HistoriaVidaTexto listarId(int id){
        return historiaVidaTextoRepository.findById(id);
    }

    @Override
    public HistoriaVidaTexto agregar(HistoriaVidaTexto p){
        Date date = Date.valueOf(LocalDate.now());
        p.setFecha(date);
        return historiaVidaTextoRepository.save(p);
    }

    @Override
    public HistoriaVidaTexto edit(HistoriaVidaTexto p){
        Date date = Date.valueOf(LocalDate.now());
        p.setFecha(date);
        return historiaVidaTextoRepository.save(p);
    }

    @Override
    public HistoriaVidaTexto delete(int id){
        HistoriaVidaTexto historiaVidaTexto=historiaVidaTextoRepository.findById(id);
        if (historiaVidaTexto!=null){
            historiaVidaTextoRepository.delete(historiaVidaTexto);
        }
        return historiaVidaTexto;
    }
}
