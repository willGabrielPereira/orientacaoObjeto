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
import referenciaBanco.Produto;

/**
 *
 * @author willg
 */
public class ProdutoDAO implements interfaces.IDAO<Produto>{

    private final String NOMEDATABELA = "produto";
    
    @Override
    public boolean inserir(Produto obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO "+NOMEDATABELA+" (`descricao`, `valor`, "
                    + "`estoque`, `imagem`) VALUES (?, ?, ?, ?);";
            //"INSERT INTO " + NOMEDATABELA + " (nome) VALUES (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getDescricao());
            ps.setDouble(2, obj.getValor());
            ps.setInt(3, obj.getEstoque());
            ps.setString(4, obj.getImagem());
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
    public boolean alterar(Produto obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE "+NOMEDATABELA+" SET `descricao`=?, `valor`=?,"
                    + " `estoque`=?, `imagem`=? WHERE `idproduto`=?;";
            //"UPDATE " + NOMEDATABELA + " SET descricao = ? WHERE codigo = ?;";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getDescricao());
            ps.setDouble(2, obj.getValor());
            ps.setInt(3, obj.getEstoque());
            ps.setString(4, obj.getImagem());
            ps.setInt(5, obj.getIdproduto());
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
    public boolean excluir(Produto obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE idproduto = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getIdproduto());
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
    public Produto procurarPorCodigo(Produto obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idproduto = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getIdproduto());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Produto obej = new Produto();
                obej.setIdproduto(rs.getInt(1));
                obej.setDescricao(rs.getString(2));
                obej.setValor(rs.getFloat(3));
                obej.setEstoque(rs.getInt(4));
                obej.setImagem(rs.getString(5));
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
    public boolean existe(Produto obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE descricao = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getDescricao());
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
    public List<Produto> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Produto> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Produto> montarLista(ResultSet rs) {
        List<Produto> listObj = new ArrayList<Produto>();
        try {
            while (rs.next()) {
                Produto obej = new Produto();
                obej.setIdproduto(rs.getInt(1));
                obej.setDescricao(rs.getString(2));
                obej.setValor(rs.getFloat(3));
                obej.setEstoque(rs.getInt(4));
                obej.setImagem(rs.getString(5));
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
