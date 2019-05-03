/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.AbsConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author willg
 */
public class Conexao extends interfaces.AbsConexao{

    
    public static Connection conectar(){
        Conexao c = new Conexao();
        c.NOME_DO_BANCO = "venda";
        c.login = "root";
        c.senha = "";
        return c.conn();
    }
    
    public static ResultSet sqlPersonalizado(String sql){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(Exception e){
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
    
    
}
