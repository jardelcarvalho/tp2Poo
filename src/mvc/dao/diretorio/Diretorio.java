/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao.diretorio;

/**
 *
 * @author Jardel Carvalho
 */
public abstract class Diretorio {
    protected String caminho;
    
    public Diretorio(){
        
    }
    
    public Diretorio(String caminho){
        this.caminho = caminho;
    }
}
