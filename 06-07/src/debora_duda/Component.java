package debora_duda;

public abstract class Component {
	protected String nome;
	
	public String getNome() {
		return this.nome;
	}
	public void getPrint() {
		System.out.println(this.nome);
	}
}
