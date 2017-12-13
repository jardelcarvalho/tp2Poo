package abstractfactory.interfaces;
import java.util.ArrayList;
import abstractfactory.interfaces.Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jardel Carvalho
*/

public interface Dao {
    public boolean gravarObjetoDao(Model objeto);
    public ArrayList<Model> lerObjetosDao();
    public boolean apagarObjetoDao(Model objeto);
}
