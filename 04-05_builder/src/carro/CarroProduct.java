package carro;

public class CarroProduct {
	private double preco;
	private String dscMotor;
	private int anoDeFabricacao;
	private String modelo;
	private String montadora;
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getDscMotor() {
		return dscMotor;
	}
	public void setDscMotor(String dscMotor) {
		this.dscMotor = dscMotor;
	}
	public int getAnoDeFabricacao() {
		return anoDeFabricacao;
	}
	public void setAnoDeFabricacao(int anoDeFabricacao) {
		this.anoDeFabricacao = anoDeFabricacao;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMontadora() {
		return montadora;
	}
	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CarroProduct [preco=");
		builder.append(preco);
		builder.append(", dscMotor=");
		builder.append(dscMotor);
		builder.append(", anoDeFabricacao=");
		builder.append(anoDeFabricacao);
		builder.append(", modelo=");
		builder.append(modelo);
		builder.append(", montadora=");
		builder.append(montadora);
		builder.append("]");
		return builder.toString();
	}
	
	
}
