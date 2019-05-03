package factoryMethod.exercicios.funcionarios;

public class FactoryFuncionario implements IFactoryFuncionario{

	@Override
	public Funcionario criaFuncionario(String tipo) {
		IFactoryFuncionario f;
		if("estagiario".equalsIgnoreCase(tipo)) {
			f = new FactoryFuncionario_Estagiario();
			return f.criaFuncionario(tipo);
		}else if("Limpeza".equalsIgnoreCase(tipo)){
			f = new FactoryFuncionario_Limpeza();
			return f.criaFuncionario(tipo);
		}else if("professor".equalsIgnoreCase(tipo)){
			f = new FactoryFuncionario_Professor();
			return f.criaFuncionario(tipo);
		}else {
			return new Funcionario(tipo);
		}
	}


}
