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
import mvc.model.servicos.Filme;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Jardel Carvalho
 */
public class FilmeDao extends Diretorio implements Dao {
    
    public FilmeDao(){
        super("Arquivos/Filmes.json");
    }
    
    @Override
    public boolean gravarObjetoDao(Model objeto) {
        Arquivo arquivo = Arquivo.getInstance();
        Filme filme = (Filme) objeto;
        JSONObject json = null;
        try{
            json = new JSONObject();
            json.put("titulo", filme.getTitulo());
            json.put("genero", filme.getGenero());
            json.put("classificacaoindicativa", filme.getClassificacaoIndicativa());
            json.put("codigo", filme.getCodigo());
            json.put("quantidade", filme.getQuantidade());
            json.put("duracao", filme.getDuracao());
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
                String duracao = (String) json.get("duracao");
                retorno.add((Model) new Filme(titulo, genero, Integer.parseInt(classi_Indicativa), 
                        Integer.parseInt(codigo), Integer.parseInt(quantidade), Integer.parseInt(duracao)));
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
        String id = ((Integer)((Filme) objeto).getCodigo()).toString();
        String titulo = ((Filme) objeto).getTitulo();
        for(Model m : lidos){
            if(!id.equals(((Integer)((Filme) m).getCodigo()).toString()) || !titulo.equals(((Filme) m).getTitulo())){
                if(!gravarObjetoDao(m)) return false;
            }
        }
        return true;
    }
    
    public Model buscarObjeto(String identificador){
        ArrayList<Model> objetos = lerObjetosDao();
        for(Model m : objetos){
            String titulo = ((Filme)m).getTitulo();
            String codigo = ((Integer)((Filme)m).getCodigo()).toString();
            if(titulo.equals(identificador) || codigo.equals(identificador))
                return m;
        }
        return null;
    }
    
}
