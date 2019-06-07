package tomada;

public class Main {

	public static void main(String[] args) {
		ITomadaPlana plana = Factory.criar();
		
		plana.conectar();
	}

}
