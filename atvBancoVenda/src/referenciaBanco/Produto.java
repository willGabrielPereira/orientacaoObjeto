/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package referenciaBanco;

/**
 *
 * @author willg
 */
public class Produto {
    private int idproduto;
    private String descricao;
    private float valor;
    private int estoque;
    private String imagem;

    public Produto() {}
    public Produto(int idproduto, String descricao, float valor, int estoque,
            String imagem) {
        this.idproduto = idproduto;
        this.descricao = descricao;
        this.valor = valor;
        this.estoque = estoque;
        this.imagem = imagem;
    }

    public String getDescricao() {
        return descricao;
    }
    public int getEstoque() {
        return estoque;
    }
    public int getIdproduto() {
        return idproduto;
    }
    public String getImagem() {
        return imagem;
    }
    public float getValor() {
        return valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(" idProduto: "+idproduto);
        s.append(" descricao: "+descricao);
        s.append(" valor: "+valor);
        s.append(" estoque: "+estoque);
        s.append(" imagem: "+imagem+"\n");
        return s.toString();
    }
    
        
}
