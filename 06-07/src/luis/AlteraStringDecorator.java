package luis;

public abstract class AlteraStringDecorator implements StringModificador{
	protected StringModificador sm;
	
	public AlteraStringDecorator(StringModificador sm) {
		this.sm = sm;
	}
}
