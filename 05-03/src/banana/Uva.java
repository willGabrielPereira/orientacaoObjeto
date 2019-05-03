package banana;

public class Uva {
	private String cor;

	public Uva(String cor) {
		super();
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Uva [cor=");
		builder.append(cor);
		builder.append("]");
		return builder.toString();
	}
	
}
