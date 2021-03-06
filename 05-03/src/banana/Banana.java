package banana;

public class Banana {
	private String tipo;
	private String origem;
	
	public Banana(String tipo, String origem) {
		this.tipo = tipo;
		this.origem = origem;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNacionalidade() {
		return origem;
	}
	public void setNacionalidade(String nacionalidade) {
		this.origem = nacionalidade;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Banana [tipo=");
		builder.append(tipo);
		builder.append(", nacionalidade=");
		builder.append(origem);
		builder.append("]");
		return builder.toString();
	}
}
