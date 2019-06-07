package tomada;

public class Factory {
	public static ITomadaPlana criar() {
		return new TomadaPlana();
	}
	
	public static ITomadaPlana criar() {
		return new Adaptador();
	}
}
