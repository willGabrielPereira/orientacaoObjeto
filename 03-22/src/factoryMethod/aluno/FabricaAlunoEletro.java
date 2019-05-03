package factoryMethod.aluno;

public class FabricaAlunoEletro implements FabricaAluno{
	@Override
	public Aluno criarAluno() {
		return new Eletro();
	}
}
