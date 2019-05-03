package comida.produto;

public class Lanche implements Produto{

	private int tamanho;
	private float preco;
	
	@Override
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	@Override
	public void setPreco(float preco) {
		this.preco = preco;
	}

	@Override
	public int getTamanho() {
		return tamanho;
	}

	@Override
	public float getPreco() {
		return preco;
	}

	@Override
	public String info() {
		return "Lanche";
	}

}
