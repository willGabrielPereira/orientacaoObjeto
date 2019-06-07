package debora_duda;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Component> lista = new ArrayList<Component>();
		
		Caixa caixa1 = new Caixa("Caixa utensilios domesticos");
		Caixa caixa2 = new Caixa("Caixa talheres");
		Item faca = new Item("Faca");
		Item colher = new Item("colher");
		Item concha = new Item("Concha de silicone");
		
		caixa1.add(concha);
		caixa2.add(faca);
		caixa2.add(colher);
		caixa1.add(caixa2);
		caixa1.getPrint();
		
		lista = caixa2.getChildrens();
		
		System.out.println();
		for(Component i:lista) {
			System.out.println(i.getNome());
		}
		System.out.println();
		
		caixa1.remove(concha);
		caixa1.getPrint();
	}

}
