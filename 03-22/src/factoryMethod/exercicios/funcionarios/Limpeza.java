package factoryMethod.exercicios.funcionarios;

public class Limpeza extends Funcionario implements IFuncionario{
	public Limpeza(String tipo) {
		super(tipo);
	}
	
	@Override
	public String info() {
		return "Limpeza";
	}
}
