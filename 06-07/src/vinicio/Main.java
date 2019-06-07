package vinicio;

public class Main {
	public static void main(String[] args) {
		Veiculo veiculo = new Caminhao(new MotorPequeno());
		veiculo.criar();
		veiculo.colocaMotor(new MotorGrande());
		veiculo.criar();
		veiculo = new Carro(new MotorGrande());
		veiculo.criar();
		veiculo.colocaMotor(new MotorPequeno());
		veiculo.criar();
	}
}
