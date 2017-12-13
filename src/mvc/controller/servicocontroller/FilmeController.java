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
import mvc.dao.servicodao.FilmeDao;
import mvc.model.servicos.Filme;

/**
 *
 * @author Jardel Carvalho
 */
public class FilmeController implements Controller {
    
    private Filme novaInstancia(String[] atributos){
        Filme instancia = (Filme) FactoryProducer.getFactory("model").getModel("filme");
        instancia.setTitulo(atributos[0]);
        instancia.setGenero(atributos[1]);
        instancia.setClassificacaoIndicativa(Integer.parseInt(atributos[2]));
        instancia.setCodigo(Integer.parseInt(atributos[3]));
        instancia.setQuantidade(Integer.parseInt(atributos[4]));
        instancia.setDuracao(Integer.parseInt(atributos[5]));
        return instancia;
    }

    @Override
    public boolean gravarObjeto(String[] atributos) {
        return FactoryProducer.getFactory("dao").getDao("filme").gravarObjetoDao(novaInstancia(atributos));
    }

    @Override
    public ArrayList<String[]> buscarObjetos() {
        ArrayList<Model> filmes = FactoryProducer.getFactory("dao").getDao("filme").lerObjetosDao();
        ArrayList<String[]> retorno = new ArrayList<>();
        
        if(filmes == null){
            return null;
        }
        
        for(Model filme : filmes){
            String[] item = {((Filme) filme).getTitulo(), 
                ((Filme) filme).getGenero()
                , ((Integer)((Filme) filme).getClassificacaoIndicativa()).toString()
                , ((Integer)((Filme) filme).getCodigo()).toString()
                , ((Integer)((Filme) filme).getQuantidade()).toString()
                , ((Integer)((Filme) filme).getDuracao()).toString()};
            retorno.add(item);
        }
        return retorno;
    }

    @Override
    public boolean apagarObjeto(String identificador) {
         return FactoryProducer.getFactory("dao").getDao("filme").apagarObjetoDao(new Filme("", "", 0, 
                 Integer.parseInt(identificador), 0, 0));
    }

    @Override
    public String[] buscarObjeto(String identificador) {
        Filme filme = (Filme) (new FilmeDao()).buscarObjeto(identificador);
        if(filme == null) return null;
        String[] retorno = {((Filme) filme).getTitulo(), 
                ((Filme) filme).getGenero()
                , ((Integer)((Filme) filme).getClassificacaoIndicativa()).toString()
                , ((Integer)((Filme) filme).getCodigo()).toString()
                , ((Integer)((Filme) filme).getQuantidade()).toString()
                , ((Integer)((Filme) filme).getDuracao()).toString()};
        return retorno;
    }
    
}
