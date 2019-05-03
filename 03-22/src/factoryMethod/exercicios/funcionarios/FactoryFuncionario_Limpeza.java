package factoryMethod.exercicios.funcionarios;

public class FactoryFuncionario_Limpeza implements IFactoryFuncionario{

	@Override
	public Funcionario criaFuncionario(String tipo) {
		return new Limpeza(tipo);
	}
}
