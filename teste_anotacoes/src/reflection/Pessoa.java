package reflection;

import java.util.ArrayList;
import java.util.List;

class Pessoa {
	String nome;
	public Pessoa() {}
	public void	setNome(String nome) {
		this.nome = nome;
	}
	public List<String> getDesc() {
		List<String> desc = new ArrayList<String>();
		desc.add("O nome dessa classe é Pessoa ");
		desc.add("Essa é uma classe criado por Bruno");
		desc.add("Tem como Objetivo .... ");
		desc.add("Possui alguns atributos, entre eles o Id da Pessoa e o Nome da Pessoa");
		return desc;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pessoa [nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}
	
}
