package factoryMethod.pessoa;

public class FactoryPessoa implements IFactoryPessoa{

	@Override
	public Pessoa criarPessoa(String nome, String sexo) {
		IFactoryPessoa p;
		if("F".equalsIgnoreCase(sexo)) { 
			p = new FactoryPessoa_Mulher();
			return p.criarPessoa(nome, sexo);
		}else if("M".equalsIgnoreCase(sexo)) {
			p = new FactoryPessoa_Homem();
			return p.criarPessoa(nome, sexo);
		}else {
			return new Pessoa(nome,sexo);
		}
	}
	
}
