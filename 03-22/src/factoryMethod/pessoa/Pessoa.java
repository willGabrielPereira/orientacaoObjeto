package factoryMethod.pessoa;

public class Pessoa implements IPessoa{
	private String nome;
	private String sexo;
	
	public Pessoa(String nome, String sexo) {
		setNome(nome);
		setSexo(sexo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
}
