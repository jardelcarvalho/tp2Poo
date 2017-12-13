/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.producer;
import abstractfactory.abstractfactory.AbstractFactory;
import abstractfactory.factories.*;
/**
 *
 * @author Jardel Carvalho
 */
public class FactoryProducer {
    
    public static AbstractFactory getFactory(String tipo){
        if(tipo.equalsIgnoreCase("model"))
                return new ModelFactory();
        
        else if(tipo.equalsIgnoreCase("view"))
            return new ViewFactory();
            
        else if(tipo.equalsIgnoreCase("controller"))
            return new ControllerFactory();
        
        else if(tipo.equalsIgnoreCase("dao"))
            return new DaoFactory();
        
        return null;
    }
}
