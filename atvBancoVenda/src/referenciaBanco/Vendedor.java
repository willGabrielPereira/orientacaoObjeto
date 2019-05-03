/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package referenciaBanco;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author willg
 */
public class Vendedor {

    private int idvendedor;
    private String nome;
    private String usuario;
    private String senha;

    public Vendedor() {
    }

    public Vendedor(int idvendedor, String nome, String usuario, String senha) {
        this.idvendedor = idvendedor;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;

        this.senha = Cliente.criptografia(this.senha);
    }

    public int getIdvendedor() {
        return idvendedor;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha, boolean cripto) {
        this.senha = senha;

        if (cripto) {
            this.senha = Cliente.criptografia(this.senha);
        }
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(" idVendedor: " + idvendedor);
        s.append(" nome: " + nome);
        s.append(" usuario: " + usuario);
        s.append(" senha: " + senha + "\n");
        return s.toString();
    }

}
