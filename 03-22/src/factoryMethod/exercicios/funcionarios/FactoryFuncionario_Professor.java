package factoryMethod.exercicios.funcionarios;

public class FactoryFuncionario_Professor implements IFactoryFuncionario{

	@Override
	public Funcionario criaFuncionario(String tipo) {
		return new Professor(tipo);
	}
	
}
