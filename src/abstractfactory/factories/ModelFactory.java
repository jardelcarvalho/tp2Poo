/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.factories;
import abstractfactory.abstractfactory.AbstractFactory;
import abstractfactory.interfaces.*;
import mvc.model.cliente.Cliente;
import mvc.model.servicos.Filme;
import mvc.model.servicos.Serie;
/**
 *
 * @author Jardel Carvalho
 */
public class ModelFactory extends AbstractFactory {
    @Override
    public Model getModel(String tipo){
        if(tipo.equalsIgnoreCase("cliente"))
            return new Cliente();
        
        else if(tipo.equalsIgnoreCase("filme"))
            return new Filme();
        else if(tipo.equalsIgnoreCase("serie"))
            return new Serie();
        else if(tipo.equalsIgnoreCase("locacao"));
                
        else if(tipo.equalsIgnoreCase("devolucao"));
                
        return null;
    }
    
    @Override
    public View getView(String tipo){
        return null;
    }
    
    @Override
    public Controller getController(String tipo){
        return null;
    }
    
    public Dao getDao(String tipo){
        return null;
    }
}
