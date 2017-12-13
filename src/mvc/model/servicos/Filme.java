/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.servicos;
import mvc.model.servico.Servico;
/**
 *
 * @author Jardel Carvalho
 */
public class Filme extends Servico {
    private int duracao;
    
    public Filme(){
        super();
        duracao = 0;
    }
    
    public Filme(String titulo, String genero, int classificacaoIndicativa, int codigo, int quantidade, int duracao){
        super(titulo, genero, classificacaoIndicativa, codigo, quantidade);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
}
