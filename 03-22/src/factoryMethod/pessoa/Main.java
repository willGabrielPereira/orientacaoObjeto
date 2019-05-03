package factoryMethod.pessoa;

public class Main {
	public static void main(String[] args) {
		FactoryPessoa factory = new FactoryPessoa();
		Pessoa p1 = factory.criarPessoa("Rodrigo", "M");
		Pessoa p2 = factory.criarPessoa("Nara", "F");
		Pessoa p3 = factory.criarPessoa("XXXX", "");
		
		System.out.println(p1.info());
		System.out.println(p2.info());
		System.out.println(p3.info());
	}
}
