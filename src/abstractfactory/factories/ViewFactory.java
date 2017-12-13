/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.factories;
import abstractfactory.abstractfactory.AbstractFactory;
import abstractfactory.interfaces.*;
import mvc.view.ClienteView.ClienteView;
import mvc.view.ServicoView.ServicoView;
/**
 *
 * @author Jardel Carvalho
 */
public class ViewFactory extends AbstractFactory{
    @Override
    public Model getModel(String tipo){
        return null;
    }
    
    @Override
    public View getView(String tipo){
        if(tipo.equalsIgnoreCase("cliente"))
            return new ClienteView();
        else if(tipo.equalsIgnoreCase("filme"));
            
        else if(tipo.equalsIgnoreCase("serie"));
        
        else if(tipo.equalsIgnoreCase("locacao"));
                
        else if(tipo.equalsIgnoreCase("devolucao"));
        
        else if(tipo.equalsIgnoreCase("servico"))
            return new ServicoView();
                
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
