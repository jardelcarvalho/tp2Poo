/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao.clientedao;

import abstractfactory.interfaces.Dao;
import abstractfactory.interfaces.Model;
import java.util.ArrayList;
import mvc.dao.arquivo.Arquivo;
import mvc.dao.diretorio.Diretorio;
import mvc.model.cliente.Cliente;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Jardel Carvalho
 */
public class ClienteDao extends Diretorio implements Dao {
    
    public ClienteDao(){
        super("Arquivos/Clientes.json");
    }
    
    @Override
    public boolean gravarObjetoDao(Model objeto){
        Cliente cliente = (Cliente) objeto;
        Arquivo arquivo = Arquivo.getInstance();
        JSONObject jsonObj = null;
        try{
            jsonObj = new JSONObject();
            jsonObj.put("nome", cliente.getNome());
            jsonObj.put("codigo", cliente.getCodigo());
            return arquivo.escrever(JSONObject.valueToString(jsonObj), caminho);
        }catch(JSONException e){
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public ArrayList<Model> lerObjetosDao(){
        Arquivo arquivo = Arquivo.getInstance();
        ArrayList<String> dados = arquivo.ler(caminho);
        ArrayList<Model> retorno = new ArrayList<>();
        JSONObject jsonObj = null;
        try{
            for(String d : dados){
                jsonObj = new JSONObject(d);
                String nome = (String) jsonObj.get("nome");
                String CPF = (String) jsonObj.get("codigo");
                retorno.add((Model) new Cliente(nome, CPF));
            }
        }catch(JSONException e){
            e.printStackTrace();
            retorno.clear();
            retorno = null;
            dados.clear();
        }
        dados.clear();
        return retorno;
    }
    
    @Override
    public boolean apagarObjetoDao(Model objeto){
        ArrayList<Model> lidos = lerObjetosDao();
        Arquivo.getInstance().flush(caminho);
        String id = ((Cliente) objeto).getCodigo();
        for(Model m : lidos){
            if(!id.equals(((Cliente) m).getCodigo())){
                if(!gravarObjetoDao(m)) return false;
            }
        }
        return true;
    }
    
    
}
