/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.abstractfactory;
import abstractfactory.interfaces.*;

/**
 *
 * @author Jardel Carvalho
 */
public abstract class AbstractFactory {
    public abstract Model getModel(String tipo);
    public abstract View getView(String tipo);
    public abstract Controller getController(String tipo);
    public abstract Dao getDao(String tipo);
}
