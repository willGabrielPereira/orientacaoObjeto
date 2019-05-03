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
public class ItemVenda extends Produto{
    private int quantidade;

    public ItemVenda() {}
    public ItemVenda(int quantidade, int idproduto, String descricao,
            float valor, int estoque, String imagem) {
        super(idproduto, descricao, valor, estoque, imagem);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void setSuper(Produto p){
        super.setDescricao(p.getDescricao());
        super.setEstoque(p.getEstoque());
        super.setIdproduto(p.getIdproduto());
        super.setImagem(p.getImagem());
        super.setValor(p.getValor());
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append(" qntd: "+quantidade+"\n");
        return s.toString();
    }
    
    

}
