package jesus;

public class Jesus implements ICopoAgua{
	Vinho v;
	
	public Jesus() {
		v = new Vinho();
	}
	
	@Override
	public void encher() {
		v.encherVinho();
	}
}
