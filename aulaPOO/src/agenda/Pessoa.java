package agenda;

public class Pessoa {
	private String nome;
	private String sobrenome;
	private long fone;
	private String endereco;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.length()>=3)
			this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		if(nome.length()>=3)
			this.sobrenome = sobrenome;
	}
	public long getFone() {
		return fone;
	}
	public void setFone(long fone) {
		if(String.valueOf(fone).length()>=11)
			this.fone = fone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco.length()>0)
			this.endereco = endereco;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [nome=");
		builder.append(nome);
		builder.append(", sobrenome=");
		builder.append(sobrenome);
		builder.append(", fone=");
		builder.append(fone);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
