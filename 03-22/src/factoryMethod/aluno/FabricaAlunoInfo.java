package factoryMethod.aluno;

public class FabricaAlunoInfo implements FabricaAluno{

	@Override
	public Aluno criarAluno() {
		return new Info();
	}

}
