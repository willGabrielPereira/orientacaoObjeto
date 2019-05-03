package conexao;

public class Conec {
	private String host;
	private String user;
	private String pass;
	private int porta;
	
	public Conec logarComUsuario(String user) {
		this.user = user;
		return this;
	}
	public Conec usandoSenha(String pass) {
		this.pass = pass;
		return this;
	}
	public Conec conectandoEm(String host) {
		this.host = host;
		return this;
	}
	public Conec naPorta(int porta) {
		this.porta = porta;
		return this;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getPorta() {
		return porta;
	}
	public void setPorta(int porta) {
		this.porta = porta;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Conec [host=");
		builder.append(host);
		builder.append(", user=");
		builder.append(user);
		builder.append(", pass=");
		builder.append(pass);
		builder.append(", porta=");
		builder.append(porta);
		builder.append("]");
		return builder.toString();
	}
	
	
}
