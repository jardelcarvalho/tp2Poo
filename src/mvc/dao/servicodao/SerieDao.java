/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao.servicodao;

import abstractfactory.interfaces.Dao;
import abstractfactory.interfaces.Model;
import java.util.ArrayList;
import mvc.dao.arquivo.Arquivo;
import mvc.dao.diretorio.Diretorio;
import mvc.model.servicos.Serie;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Jardel Carvalho
 */
public class SerieDao extends Diretorio implements Dao{

    public SerieDao(){
        super("Arquivos/Series.txt");
    }
   @Override
    public boolean gravarObjetoDao(Model objeto) {
        Arquivo arquivo = Arquivo.getInstance();
        Serie serie = (Serie) objeto;
        JSONObject json = null;
        try{
            json = new JSONObject();
            json.put("titulo", serie.getTitulo());
            json.put("genero", serie.getGenero());
            json.put("classificacaoindicativa", serie.getClassificacaoIndicativa());
            json.put("codigo", serie.getCodigo());
            json.put("quantidade", serie.getQuantidade());
            json.put("episodios", serie.getEpisodios());
            json.put("temporada", serie.getTemporada());
            return arquivo.escrever(JSONObject.valueToString(json), caminho);
        }catch(JSONException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Model> lerObjetosDao() {
        Arquivo arquivo = Arquivo.getInstance();
        ArrayList<String> dados = arquivo.ler(caminho);
        ArrayList<Model> retorno = new ArrayList<>();
        JSONObject json = null;
        try{
            for(String d : dados){
                json = new JSONObject(d);
                String titulo = (String) json.get("titulo");
                String genero = (String) json.get("genero");
                String classi_Indicativa = (String) json.get("classificacaoindicativa");
                String codigo = (String) json.get("codigo");
                String quantidade = (String) json.get("quantidade");
                String episodios = (String) json.get("episodios");
                String temporada = (String) json.get("temporada");
                retorno.add((Model) new Serie(titulo, genero, Integer.parseInt(classi_Indicativa), 
                        Integer.parseInt(codigo), Integer.parseInt(quantidade), Integer.parseInt(episodios),
                        Integer.parseInt(temporada)));
            }
        }catch(JSONException e){
            e.printStackTrace();
            retorno.clear();
            retorno = null;
            dados.clear();
        }
        return retorno;
    }

    @Override
    public boolean apagarObjetoDao(Model objeto) {
        ArrayList<Model> lidos = lerObjetosDao();
        Arquivo.getInstance().flush(caminho);
        String id = ((Integer)((Serie) objeto).getCodigo()).toString();
        String titulo = ((Serie) objeto).getTitulo();
        for(Model m : lidos){
            if(!id.equals(((Integer)((Serie) m).getCodigo()).toString()) || !titulo.equals(((Serie) m).getTitulo())){
                if(!gravarObjetoDao(m)) return false;
            }
        }
        return true;
    }
    
    public Model buscarObjeto(String identificador){
        ArrayList<Model> objetos = lerObjetosDao();
        for(Model m : objetos){
            String titulo = ((Serie)m).getTitulo();
            String codigo = ((Integer)((Serie)m).getCodigo()).toString();
            if(titulo.equals(identificador) || codigo.equals(identificador))
                return m;
        }
        return null;
    }
    
}
