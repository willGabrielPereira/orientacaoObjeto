package reflection;

import java.lang.reflect.Field;

public class Main {
	public static void main(String[] args) {
		TesteReflection t = new TesteReflection(Pessoa.class);
		Field att = t.getAtributos()[0];
		t.invokeParaAtributo(att, TesteReflection.SET, "Pessoa teste");
		System.out.println((Pessoa)t.getObjeto());
		
		t = new TesteReflection(Evento.class);
		t.invokeParaAtributo("nome", t.SET, "evento teste");
		System.out.println((Evento)t.getObjeto());
	}
}
