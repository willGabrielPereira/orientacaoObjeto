package factoryMethod.pessoa;

public class FactoryPessoa_Homem implements IFactoryPessoa{
	@Override
	public Pessoa criarPessoa(String nome, String sexo) {
		return new Homem(nome, sexo);
	}
}
