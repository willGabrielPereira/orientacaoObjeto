package vinicio;

public class Caminhao extends Veiculo{
	public Caminhao(final Motor motor) {
		this.motor = motor;
	}
	
	@Override
	public void criar() {
		System.out.println("O caminhao est� pronto");
		motor.info();
	}
}
