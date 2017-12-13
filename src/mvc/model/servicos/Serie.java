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
public class Serie extends Servico {
    private int episodios;
    private int temporada;

    public Serie(){
        super();
        episodios = temporada = 0;
    }
    
    public Serie(String titulo, String genero, int classificacaoIndicativa, int codigo, int quantidade, int episodios, int temporada){
        super(titulo, genero, classificacaoIndicativa, codigo, quantidade);
        this.episodios = episodios;
        this.temporada = temporada;
    }
    
    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }
    
    
}
