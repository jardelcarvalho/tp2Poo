/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.factories;
import abstractfactory.abstractfactory.AbstractFactory;
import abstractfactory.interfaces.*;
import mvc.dao.clientedao.ClienteDao;
import mvc.dao.servicodao.FilmeDao;
import mvc.dao.servicodao.SerieDao;

/**
 *
 * @author Jardel Carvalho
 */
public class DaoFactory extends AbstractFactory {
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
        return null;
    }
    
    @Override
    public Dao getDao(String tipo){
        if(tipo.equalsIgnoreCase("cliente"))
            return new ClienteDao(); 
        
        else if(tipo.equalsIgnoreCase("filme"))
            return new FilmeDao();
        else if(tipo.equalsIgnoreCase("serie"))
            return new SerieDao();
        else if(tipo.equalsIgnoreCase("locacao"));
                
        else if(tipo.equalsIgnoreCase("devolucao"));
                
        return null;
    }
}
