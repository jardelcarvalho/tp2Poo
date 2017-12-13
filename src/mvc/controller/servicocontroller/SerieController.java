/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller.servicocontroller;

import abstractfactory.interfaces.Controller;
import abstractfactory.interfaces.Model;
import abstractfactory.producer.FactoryProducer;
import java.util.ArrayList;
import mvc.dao.servicodao.SerieDao;
import mvc.model.servicos.Serie;

/**
 *
 * @author Jardel Carvalho
 */
public class SerieController implements Controller{

    private Serie novaInstancia(String[] atributos){
        Serie instancia = (Serie) FactoryProducer.getFactory("model").getModel("serie");
        instancia.setTitulo(atributos[0]);
        instancia.setGenero(atributos[1]);
        instancia.setClassificacaoIndicativa(Integer.parseInt(atributos[2]));
        instancia.setCodigo(Integer.parseInt(atributos[3]));
        instancia.setQuantidade(Integer.parseInt(atributos[4]));
        instancia.setEpisodios(Integer.parseInt(atributos[5]));
        instancia.setTemporada(Integer.parseInt(atributos[6]));
        return instancia;
    }
    
    @Override
    public boolean gravarObjeto(String[] atributos) {
        return FactoryProducer.getFactory("dao").getDao("serie").gravarObjetoDao(novaInstancia(atributos));
    }

    @Override
    public ArrayList<String[]> buscarObjetos() {
        ArrayList<Model> series = FactoryProducer.getFactory("dao").getDao("serie").lerObjetosDao();
        ArrayList<String[]> retorno = new ArrayList<>();
        
        if(series == null){
            return null;
        }
        
        for(Model serie : series){
            String[] item = {((Serie) serie).getTitulo(), 
                ((Serie) serie).getGenero()
                , ((Integer)((Serie) serie).getClassificacaoIndicativa()).toString()
                , ((Integer)((Serie) serie).getCodigo()).toString()
                , ((Integer)((Serie) serie).getQuantidade()).toString()
                , ((Integer)((Serie) serie).getEpisodios()).toString()
                , ((Integer)((Serie) serie).getTemporada()).toString()};
            retorno.add(item);
        }
        return retorno;
    }

    @Override
    public boolean apagarObjeto(String identificador) {
         return FactoryProducer.getFactory("dao").getDao("serie").apagarObjetoDao(new Serie("", "", 0, 
                 Integer.parseInt(identificador), 0, 0, 0));
    }

    @Override
    public String[] buscarObjeto(String identificador) {
        Serie serie = (Serie) (new SerieDao()).buscarObjeto(identificador);
        if(serie == null) return null;
        String[] retorno = {((Serie) serie).getTitulo(), 
                ((Serie) serie).getGenero()
                , ((Integer)((Serie) serie).getClassificacaoIndicativa()).toString()
                , ((Integer)((Serie) serie).getCodigo()).toString()
                , ((Integer)((Serie) serie).getQuantidade()).toString()
                , ((Integer)((Serie) serie).getEpisodios()).toString()
                , ((Integer)((Serie) serie).getTemporada()).toString()};
        return retorno;
    }
    
}
