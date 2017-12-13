/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory.interfaces;

/**
 *
 * @author Jardel Carvalho
 */
public interface View {
    public void lerCampos();
    public void limparCampos();
    public void limparTabela();
    public void preencherCampos();
    public void preencherTabela();
    public void botao(String funcao);
}
