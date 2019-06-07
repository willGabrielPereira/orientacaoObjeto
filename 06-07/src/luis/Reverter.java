package luis;

public class Reverter extends AlteraStringDecorator{
	public Reverter(StringModificador sm) {
		super(sm);
	}
	
	public String mostrarString(String string) {
		return reverter(string);
	}
	
	public String reverter(String string) {
		String[] s = string.split("");
		String result = "";
		for(int i=s.length-1; i>=0; i--) {
			result += s[i];
		}
		return result;
	}
}
