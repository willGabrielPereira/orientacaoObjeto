/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author willg
 */
import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbsConexao {

    public String NOME_DO_BANCO;
    public String login;
    public String senha;

    public Connection conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/" + NOME_DO_BANCO;
            return DriverManager.getConnection(url, login, senha);
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
}
