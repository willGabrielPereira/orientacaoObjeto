/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import referenciaBanco.Cliente;

/**
 *
 * @author willg
 */
public class ClienteDAO implements interfaces.IDAO<Cliente> {

    private final String NOMEDATABELA = "cliente";

    @Override
    public boolean inserir(Cliente obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO "+NOMEDATABELA+" (`nome`, `cpf`, `rg`, `fone`, `email`,"
                    + " `usuario`, `senha`, `endereco`, `numero`, `bairro`, `cidade`,"
                    + " `estado`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            //"INSERT INTO " + NOMEDATABELA + " (nome) VALUES (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getNome());
            ps.setString(3, obj.getCpf());
            ps.setString(4, obj.getRg());
            ps.setString(5, obj.getFone());
            ps.setString(6, obj.getEmail());
            ps.setString(7, obj.getUsuario());
            ps.setString(8, obj.getEndereco());
            ps.setInt(9, obj.getNumero());
            ps.setString(10, obj.getBairro());
            ps.setString(11, obj.getCidade());
            ps.setString(12, obj.getEstado());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean alterar(Cliente obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE "+NOMEDATABELA+" SET `nome`= ?, `cpf`=?, `rg`=?, `fone`=?, "
                    + "`email`=?, `usuario`=?, `endereco`=?, `numero`=?, `bairro`=?, "
                    + "`cidade`=?, `estado`=? WHERE `idcliente`=?;";
            //"UPDATE " + NOMEDATABELA + " SET descricao = ? WHERE codigo = ?;";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getCpf());
            ps.setString(3, obj.getRg());
            ps.setString(4, obj.getFone());
            ps.setString(5, obj.getEmail());
            ps.setString(6, obj.getUsuario());
            ps.setString(7, obj.getEndereco());
            ps.setInt(8, obj.getNumero());
            ps.setString(9, obj.getBairro());
            ps.setString(10, obj.getCidade());
            ps.setString(11, obj.getEstado());
            ps.setInt(12, obj.getIdcliente());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean excluir(Cliente obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE idcliente = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getIdcliente());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Cliente procurarPorCodigo(Cliente obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idcliente = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getIdcliente());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente obej = new Cliente();
                obej.setIdcliente(rs.getInt(1));
                obej.setNome(rs.getString(2));
                obej.setCpf(rs.getString(3));
                obej.setRg(rs.getString(4));
                obej.setFone(rs.getString(4));
                obej.setEmail(rs.getString(5));
                obej.setUsuario(rs.getString(6));
                obej.setSenha(rs.getString(7), false);
                obej.setEndereco(rs.getString(8));
                obej.setNumero(rs.getInt(9));
                obej.setBairro(rs.getString(10));
                obej.setCidade(rs.getString(11));
                obej.setEstado(rs.getString(12));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean existe(Cliente obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE usuario = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getUsuario());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public List<Cliente> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Cliente> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Cliente> montarLista(ResultSet rs) {
        List<Cliente> listObj = new ArrayList<Cliente>();
        try {
            while (rs.next()) {
                Cliente obej = new Cliente();
                obej.setIdcliente(rs.getInt(1));
                obej.setNome(rs.getString(2));
                obej.setCpf(rs.getString(3));
                obej.setRg(rs.getString(4));
                obej.setFone(rs.getString(4));
                obej.setEmail(rs.getString(5));
                obej.setUsuario(rs.getString(6));
                obej.setSenha(rs.getString(7), false);
                obej.setEndereco(rs.getString(8));
                obej.setNumero(rs.getInt(9));
                obej.setBairro(rs.getString(10));
                obej.setCidade(rs.getString(11));
                obej.setEstado(rs.getString(12));
                listObj.add(obej);
            }
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

}
