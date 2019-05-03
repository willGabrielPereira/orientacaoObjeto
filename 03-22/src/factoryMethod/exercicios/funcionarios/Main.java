package factoryMethod.exercicios.funcionarios;

public class Main {

	public static void main(String[] args) {
		FactoryFuncionario f = new FactoryFuncionario();
		
		Funcionario fun1 = f.criaFuncionario("professor");
		Funcionario fun2 = f.criaFuncionario("estagiario");
		Funcionario fun3 = f.criaFuncionario("Limpeza");
		
		System.out.println(fun1.info());
		System.out.println(fun2.info());
		System.out.println(fun3.info());

	}

}
