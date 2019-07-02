    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

/**
 *
 * @author willg
 */
public class Coisa {
    private String nome;
    private int tamanho;
    private int cor;

    public String getNome() {
        return nome;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public Integer getCor() {
        return cor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public void setCor(Integer cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Coisa{" + "nome=" + nome + ", tamanho=" + tamanho + ", cor=" + cor + '}';
    }
    
    
}
