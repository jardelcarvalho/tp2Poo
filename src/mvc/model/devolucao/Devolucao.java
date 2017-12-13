/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.devolucao;
import abstractfactory.interfaces.Model;
import java.util.ArrayList;
import java.util.Date;
import mvc.model.cliente.Cliente;
import mvc.model.servico.Servico;

/**
 *
 * @author Jardel Carvalho
 */
public class Devolucao implements Model {
    private int codigo;
    private Date data;
    private ArrayList<Servico> servicos;
    private Cliente cliente;
    
    public Devolucao(int codigo, Date data, ArrayList<Servico> servicos, Cliente cliente){
        this.codigo = codigo;
        this.data = data;
        this.servicos = servicos;
        this.cliente = cliente;
    }
        
    public Devolucao(){
        codigo = 0;
        data = null;
        servicos = null;
        cliente = null;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
