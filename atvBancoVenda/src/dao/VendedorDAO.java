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
import referenciaBanco.Vendedor;

/**
 *
 * @author willg
 */
public class VendedorDAO implements interfaces.IDAO<Vendedor>{

    private final String NOMEDATABELA = "vendedor";
    
    @Override
    public boolean inserir(Vendedor obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO "+NOMEDATABELA+" (`nome`, `usuario`, `senha`)"
                    + " VALUES (?, ?, ?);";
            //"INSERT INTO " + NOMEDATABELA + " (nome) VALUES (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getUsuario());
            ps.setString(3, obj.getSenha());
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
    public boolean alterar(Vendedor obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE "+NOMEDATABELA+" SET `nome`=?, `usuario`=?, "
                    + "`senha`=? WHERE `idvendedor`=?;";
            //"UPDATE " + NOMEDATABELA + " SET descricao = ? WHERE codigo = ?;";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getUsuario());
            ps.setString(3, obj.getSenha());
            ps.setInt(4, obj.getIdvendedor());
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
    public boolean excluir(Vendedor obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE idvendedor = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getIdvendedor());
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
    public Vendedor procurarPorCodigo(Vendedor obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idvendedor = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getIdvendedor());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Vendedor obej = new Vendedor();
                obej.setIdvendedor(rs.getInt(1));
                obej.setNome(rs.getString(2));
                obej.setUsuario(rs.getString(3));
                obej.setSenha(rs.getString(4),false);
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
    public boolean existe(Vendedor obj) {
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
    public List<Vendedor> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Vendedor> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Vendedor> montarLista(ResultSet rs) {
        List<Vendedor> listObj = new ArrayList<Vendedor>();
        try {
            while (rs.next()) {
                Vendedor obej = new Vendedor();
                obej.setIdvendedor(rs.getInt(1));
                obej.setNome(rs.getString(2));
                obej.setUsuario(rs.getString(3));
                obej.setSenha(rs.getString(4), false);
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
