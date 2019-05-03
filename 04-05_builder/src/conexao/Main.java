package conexao;

public class Main {

	public static void main(String[] args) {
		Conec conn = new Conec().logarComUsuario("jooj").usandoSenha("senha123")
				.conectandoEm("localhost").naPorta(2020);
		
		System.out.println(conn);
	}

}
