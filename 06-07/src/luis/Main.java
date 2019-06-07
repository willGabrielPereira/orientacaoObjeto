package luis;

public class Main {

	public static void main(String[] args) {
		StringModificador sm = new AlteraString();
		sm = new CaixaAlta(sm);
		String s = sm.mostrarString("string");
		System.out.println(s);
		sm = new SeparaCaracteres(sm);
		s = sm.mostrarString("string");
		System.out.println(s);
		sm = new Reverter(sm);
		s = sm.mostrarString(s);
		System.out.println(s);
	}

}
