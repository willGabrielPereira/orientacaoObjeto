package reflection;

import java.util.ArrayList;
import java.util.List;

class Evento {
	private String nome;
	public Evento() {};
	public List getDesc() {
		List desc = new ArrayList();
		desc.add("O nome dessa classe é Evento ");
		desc.add("Essa é uma classe tem como finalidade mapear a tabela de Eventos");
		desc.add("Possui alguns atributos, entre eles o Id do Evento e o Nome do Evento");
		desc.add("Outro atributo de extrema importância é a data do Evento .. pois ela define ... ");
		return desc;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Evento [nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}
	
}