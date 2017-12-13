 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.locacao;
import abstractfactory.interfaces.Model;
import java.util.ArrayList;
import java.util.Date;
import mvc.model.cliente.Cliente;
import mvc.model.servico.Servico;
/**
 *
 * @author Jardel Carvalho
 */
public class Locacao implements Model {
    private int codigo;
    private float valor;
    private Date data;
    private ArrayList<Servico> servicos;
    private Cliente cliente;
    
    public Locacao(){
        codigo = 0;
        valor = 0F;
        data = null;
        servicos = null;
        cliente = null;
    }
    
    public Locacao(int codigo, float valor, Date data, ArrayList<Servico> servicos, Cliente cliente){
        this.codigo = codigo;
        this.valor = valor;
        this.data = data;
        this.servicos = servicos;
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
