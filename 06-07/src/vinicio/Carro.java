package vinicio;

public class Carro extends Veiculo{
	public Carro(final Motor motor) {
		this.motor = motor;
	}
	@Override
	public void criar() {
		System.out.println("O carro está pronto");
		motor.info();
	}
}
