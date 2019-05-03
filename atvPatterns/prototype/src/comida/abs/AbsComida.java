package comida.abs;

public abstract class AbsComida {
	private int tamanho;
	private float preco;
	
	public abstract AbsComida clonar();
	public abstract String info();
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public int getTamanho() {
		return tamanho;
	}
	public float getPreco() {
		return preco;
	}
}
