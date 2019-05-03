package factoryMethod.aluno;

public class Main {

	public static void main(String[] args) {
		FabricaAluno fabrica = new FabricaAlunoInfo();
		Aluno aluno = fabrica.criarAluno();
		System.out.println(aluno.exibirInfo());
		
		fabrica = new FabricaAlunoMeca();
		aluno = fabrica.criarAluno();
		System.out.println(aluno.exibirInfo());
		
		fabrica = new FabricaAlunoEletro();
		aluno = fabrica.criarAluno();
		System.out.println(aluno.exibirInfo());

	}

}
