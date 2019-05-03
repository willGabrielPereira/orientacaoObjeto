package factoryMethod.exercicios.funcionarios;

public class Funcionario implements IFuncionario{
	private String tipo;
	
	public Funcionario(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String info() {
		return "Genérico";
	}
}
