package singleton.conec;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static Conexao con;
	
	private Conexao() {}
	
	public static Conexao getInstance(String NOMEDOBANCO) {
		if(con == null) {
			con = new Conexao();
			con.setNOMEDOBANCO(NOMEDOBANCO);
		}
		return con;
	}
	
	public String getNOMEDOBANCO() {
		return NOMEDOBANCO;
	}

	public void setNOMEDOBANCO(String NOMEDOBANCO) {
		this.NOMEDOBANCO = NOMEDOBANCO;
	}

	private String NOMEDOBANCO;
	
	public Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+NOMEDOBANCO;
			return DriverManager.getConnection(url, "root", "");
		}catch(Exception e) {
			System.err.println("Erro: "+e.toString());
			e.printStackTrace();
			return null;
		}
	}
}
