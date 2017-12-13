/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.factories;
import abstractfactory.abstractfactory.AbstractFactory;
import abstractfactory.interfaces.*;
import mvc.controller.clientecontroller.ClienteController;
import mvc.controller.servicocontroller.FilmeController;
import mvc.controller.servicocontroller.SerieController;

/**
 *
 * @author Jardel Carvalho
 */
public class ControllerFactory extends AbstractFactory {
    @Override
    public Model getModel(String tipo){
        return null;
    }
    
    @Override
    public View getView(String tipo){
        return null;
    }
    
    @Override
    public Controller getController(String tipo){
        if(tipo.equalsIgnoreCase("cliente"))
            return new ClienteController(); 
        
        else if(tipo.equalsIgnoreCase("filme"))
            return new FilmeController();
        
        else if(tipo.equalsIgnoreCase("serie"))
            return new SerieController();
        
        else if(tipo.equalsIgnoreCase("locacao"));
                
        else if(tipo.equalsIgnoreCase("devolucao"));
                
        return null;
    }
    
    public Dao getDao(String tipo){
        return null;
    }
}
