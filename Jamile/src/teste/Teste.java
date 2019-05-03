package teste;

public class Teste {
	private String oi;
	private int cod;
	public static String statico;
	
	// contrutor vazio
	public Teste() {}
	
	// construtor cheio
	public Teste(String oi, int cod) {
		this.oi = oi;
		this.cod = cod;
	}
	
	
	public String getOi() {
		return oi;
	}
	public void setOi(String oi) {
		this.oi = oi;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Teste [oi=");
		builder.append(oi);
		builder.append(", cod=");
		builder.append(cod);
		builder.append(", estatico=");
		builder.append(Teste.statico);
		builder.append("]");
		return builder.toString();
	}
	
}
