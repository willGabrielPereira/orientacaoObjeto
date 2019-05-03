package factoryMethod.pessoa;

public interface IPessoa {
	public default String info() {
		return "Genérico";
	}
}
