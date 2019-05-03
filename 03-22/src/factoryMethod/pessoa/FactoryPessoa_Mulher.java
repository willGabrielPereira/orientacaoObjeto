package factoryMethod.pessoa;

public class FactoryPessoa_Mulher implements IFactoryPessoa{
	@Override
	public Pessoa criarPessoa(String nome, String sexo) {
		return new Mulher(nome, sexo);
	}
}
