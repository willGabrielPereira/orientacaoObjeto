package factoryMethod.aluno;

public class FabricaAlunoMeca implements FabricaAluno{
	@Override
	public Aluno criarAluno() {
		return new Meca();
	}
}
