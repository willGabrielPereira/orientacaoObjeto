package debora_duda;

import java.util.ArrayList;

public class Caixa extends Component{
	protected ArrayList<Component> lista;
	
	public Caixa() {
		this.lista = new ArrayList<Component>();
	}
	
	protected Caixa(String nome) {
		this.nome = nome;
		this.lista = new ArrayList<Component>();
	}
	
	@Override
	public String getNome() {
		return nome;
	}
	public void add(Component c) {
		this.lista.add(c);
	}
	public void remove(Component c) {
		lista.remove(c);
	}
	public Component getChild(int filho) {
		return lista.get(filho);
	}
	public ArrayList<Component> getChildrens(){
		return lista;
	}
	@Override
	public void getPrint() {
		System.out.println(nome);
		for(Component i:lista) {
			i.getPrint();
		}
	}
}
