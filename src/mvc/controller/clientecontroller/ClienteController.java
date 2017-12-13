/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller.clientecontroller;

import abstractfactory.interfaces.Controller;
import abstractfactory.interfaces.Model;
import abstractfactory.producer.FactoryProducer;
import java.util.ArrayList;
import mvc.model.cliente.Cliente;

/**
 *
 * @author Jardel Carvalho
 */
public class ClienteController implements Controller {
    
    private Cliente novaInstancia(String[] atributos){
        Cliente instancia = (Cliente) FactoryProducer.getFactory("model").getModel("cliente");
        instancia.setNome(atributos[0]);
        instancia.setCodigo(atributos[1]);
        return instancia;
    }
    
    @Override
    public boolean gravarObjeto(String[] atributos){
        return FactoryProducer.getFactory("dao").getDao("cliente").gravarObjetoDao(novaInstancia(atributos));
    }
    
    @Override
    public ArrayList<String[]> buscarObjetos(){
        ArrayList<Model> clientes = FactoryProducer.getFactory("dao").getDao("cliente").lerObjetosDao();
        ArrayList<String[]> retorno = new ArrayList<>();
        
        if(clientes == null){
            return null;
        }
        
        for(Model cliente : clientes){
            String[] item = {((Cliente) cliente).getNome(), ((Cliente) cliente).getCodigo()};
            retorno.add(item);
        }
        return retorno;
    }
    
    @Override
    public boolean apagarObjeto(String identificador){
        return FactoryProducer.getFactory("dao").getDao("cliente").apagarObjetoDao(new Cliente("", identificador));
    }
    
    @Override
    public String[] buscarObjeto(String identificador){
        return null;
    }
}
