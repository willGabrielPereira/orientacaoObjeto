package factoryMethod.exercicios.funcionarios;

public class Professor extends Funcionario implements IFuncionario{
	
	public Professor(String tipo) {
		super(tipo);
	}
	
	@Override
	public String info() {
		return "Professor";
	}
}
