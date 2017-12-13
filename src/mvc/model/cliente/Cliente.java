/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.cliente;
import abstractfactory.interfaces.Model;

/**
 *
 * @author Jardel Carvalho
 */
public class Cliente implements Model {
    private String nome;
    private String codigo;
    
    public Cliente(){
    }
    
    public Cliente(String nome, String codigo) {
            this.nome = nome;
            this.codigo = codigo;
    }

    public String getNome() {
            return nome;
    }

    public String getCodigo() {
            return codigo;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
}
