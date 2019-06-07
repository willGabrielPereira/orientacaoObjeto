package tomada;

public class Adaptador implements ITomadaPlana{

	TomadaCircular t;
	
	public Adaptador() {
		t = new TomadaCircular();
	}
	
	@Override
	public void conectar() {
		t.conectarCirculo();
	}

}
