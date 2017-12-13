/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.interfaces;
import java.util.ArrayList;

/**
 *
 * @author Jardel Carvalho
 */
public interface Controller {
    public boolean gravarObjeto(String[] atributos);
    public ArrayList<String[]> buscarObjetos();
    public boolean apagarObjeto(String identificador);
    public String[] buscarObjeto(String identificador);
}
