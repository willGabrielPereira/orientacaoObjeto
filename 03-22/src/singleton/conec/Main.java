package singleton.conec;

public class Main {

	public static void main(String[] args) {
		Conexao c = Conexao.getInstance("venda");
		c.conectar();
		System.out.println(c);

	}

}
