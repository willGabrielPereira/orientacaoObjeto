package dto;

public class Carro {
	private String id;
	private String ano_modelo;
	private String marca;
	private String name;
	private String veiculo;
	private String preco;
	private String combustivel;
	private String referencia;
	private String fipe_codigo;
	private String key;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAno_modelo() {
		return ano_modelo;
	}
	public void setAno_modelo(String ano_modelo) {
		this.ano_modelo = ano_modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getFipe_codigo() {
		return fipe_codigo;
	}
	public void setFipe_codigo(String fipe_codigo) {
		this.fipe_codigo = fipe_codigo;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Carro [id=");
		builder.append(id);
		builder.append(", ano_modelo=");
		builder.append(ano_modelo);
		builder.append(", marca=");
		builder.append(marca);
		builder.append(", name=");
		builder.append(name);
		builder.append(", veiculo=");
		builder.append(veiculo);
		builder.append(", preco=");
		builder.append(preco);
		builder.append(", combustivel=");
		builder.append(combustivel);
		builder.append(", referencia=");
		builder.append(referencia);
		builder.append(", fipe_codigo=");
		builder.append(fipe_codigo);
		builder.append(", key=");
		builder.append(key);
		builder.append("]");
		return builder.toString();
	}
	
	
}
