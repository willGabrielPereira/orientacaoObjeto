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
public class Cliente {

    private int idcliente;
    private String nome;
    private String cpf;
    private String rg;
    private String fone;
    private String email;
    private String usuario;
    private String senha;
    private String endereco;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Cliente() {
    }

    public Cliente(int idcliente, String nome, String cpf, String rg,
            String fone, String email, String usuario, String senha,
            String endereco, int numero, String bairro, String cidade,
            String estado) {
        this.idcliente = idcliente;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.fone = fone;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;

        this.senha = Cliente.criptografia(this.senha);
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEstado() {
        return estado;
    }

    public String getFone() {
        return fone;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public String getRg() {
        return rg;
    }

    public String getSenha() {
        return senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setSenha(String senha, boolean cripto) {
        this.senha = senha;

        if (cripto) {
            this.senha = Cliente.criptografia(this.senha);
        }

    }

    public static String criptografia(String senha) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(senha.getBytes("utf8"));
            senha = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
        }
        return senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(" id: " + idcliente);
        s.append(" nome: " + nome);
        s.append(" cpf: " + cpf);
        s.append(" rg: " + rg);
        s.append(" fone: " + fone);
        s.append(" email: " + email);
        s.append(" usuario: " + usuario);
        s.append(" senha: " + senha);
        s.append(" endereco: " + endereco);
        s.append(" numero: " + numero);
        s.append(" bairro: " + bairro);
        s.append(" cidade: " + cidade);
        s.append(" estado: " + estado + "\n");
        return s.toString();
    }

}
