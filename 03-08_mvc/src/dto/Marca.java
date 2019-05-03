package dto;

public class Marca {
	private int codigo;
	private String descricao;
	
	public Marca() {}
	public Marca(String descricao) {
		this.descricao = descricao;
	}
	public Marca(int codigo) {
		this.codigo = codigo;
	}
	public Marca(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Marca [codigo=");
		builder.append(codigo);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append("]");
		return builder.toString();
	}
	
	
}
