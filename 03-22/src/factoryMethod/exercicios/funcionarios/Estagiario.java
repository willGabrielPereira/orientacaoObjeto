package factoryMethod.exercicios.funcionarios;

public class Estagiario extends Funcionario implements IFuncionario{
	public Estagiario(String tipo) {
		super(tipo);
	}
	
	@Override
	public String info() {
		return "Estagiario";
	}
}
