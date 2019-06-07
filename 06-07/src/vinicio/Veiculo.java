package vinicio;

public abstract class Veiculo {
	protected Motor motor;
	
	public abstract void criar();
	
	public void colocaMotor(final Motor motor) {
		this.motor = motor;
	}
}
