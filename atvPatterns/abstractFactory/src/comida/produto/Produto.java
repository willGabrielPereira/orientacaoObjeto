package comida.produto;

public interface Produto {
	public void setTamanho(int tamanho);
	public void setPreco(float preco);
	public int getTamanho();
	public float getPreco();
	public String info();
}
