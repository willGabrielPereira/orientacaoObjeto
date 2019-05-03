/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import referenciaBanco.Venda;

/**
 *
 * @author willg
 */
public class ItemVendaDAO implements interfaces.IDAO<Venda>{

    private final String NOMEDATABELA = "produto_has_venda";
    
    @Override
    public boolean inserir(Venda obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO "+NOMEDATABELA+" (`venda_idvenda`, "
                    + "`produto_idproduto`, `quantidade`)"
                    + " VALUES (?, ?, ?);";
            //"INSERT INTO " + NOMEDATABELA + " (nome) VALUES (?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getIdvenda());
            //ps.setInt(2, obj.getItemVenda().get);
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
    public boolean alterar(Venda obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE "+NOMEDATABELA+" `venda_idvenda`=?, "
                    + "`produto_idproduto`=?, `quantidade`=? WHERE venda_idvenda=?;";
            //"UPDATE " + NOMEDATABELA + " SET descricao = ? WHERE codigo = ?;";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getCliente_idcliente());
            ps.setInt(2, obj.getVendedor_idvendedor());
            ps.setInt(3, obj.getIdvenda());
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
    public boolean excluir(Venda obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE idvenda = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getIdvenda());
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
    public Venda procurarPorCodigo(Venda obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idvenda = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getIdvenda());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Venda obej = new Venda();
                obej.setIdvenda(rs.getInt(1));
                obej.setData(rs.getDate(2));
                obej.setDataVencimento(rs.getDate(3));
                obej.setDataPagamento(rs.getDate(4));
                obej.setCliente_idcliente(rs.getInt(5));
                obej.setVendedor_idvendedor(rs.getInt(6));
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
    public boolean existe(Venda obj) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE idvenda = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getIdvenda());
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
    public List<Venda> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Venda> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Venda> montarLista(ResultSet rs) {
        List<Venda> listObj = new ArrayList<Venda>();
        try {
            while (rs.next()) {
                Venda obej = new Venda();
                obej.setIdvenda(rs.getInt(1));
                obej.setData(rs.getDate(2));
                obej.setDataVencimento(rs.getDate(3));
                obej.setDataPagamento(rs.getDate(4));
                obej.setCliente_idcliente(rs.getInt(5));
                obej.setVendedor_idvendedor(rs.getInt(6));
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
