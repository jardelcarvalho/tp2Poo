/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.servico;
import abstractfactory.interfaces.Model;

/**
 *
 * @author Jardel Carvalho
 */
public class Servico implements Model, Quantidade{
    
    private String titulo;
    private String genero;
    private int classificacaoIndicativa;
    private int codigo;
    private int quantidade;
    
    public Servico(){
        genero = titulo = "";
        classificacaoIndicativa = codigo = quantidade = 0;
    }
    
    public Servico(String titulo, String genero, int classificacaoIndicativa, int codigo, int quantidade){
        this.titulo = titulo;
        this.genero = genero;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(int classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    @Override
    public void incrementarQtd(){
        quantidade++;
    }
    
    @Override
    public void decrementarQtd(){
        quantidade -= quantidade == 0 ? 0 : 1;
    }
}
