package factoryMethod.pessoa;

public class Homem extends Pessoa implements IPessoa{
	public Homem(String nome, String sexo) {
		super(nome, sexo);
	}
	public String info() {
		return "Homem";
	}
}
