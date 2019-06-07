package luis;

public class CaixaAlta extends AlteraStringDecorator{
	public CaixaAlta(StringModificador sm) {
		super(sm);
	}
	
	public String mostrarString(String string) {
		return caixaAlta(string);
	}
	
	public String caixaAlta(String string) {
		String result = string.toUpperCase();
		return result;
	}

}
