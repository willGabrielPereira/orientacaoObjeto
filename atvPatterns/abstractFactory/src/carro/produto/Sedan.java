package carro.produto;

public class Sedan implements Produto{
	private String marca;
	private String modelo;
	
	@Override
	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String getMarca() {
		return marca;
	}

	@Override
	public String getModelo() {
		return modelo;
	}

	@Override
	public String info() {
		return "Sedan marca: "+marca;
	}
}
