package factoryMethod.exercicios.funcionarios;

public class FactoryFuncionario_Estagiario implements IFactoryFuncionario{

	@Override
	public Funcionario criaFuncionario(String tipo) {
		return new Estagiario(tipo);
	}
}
