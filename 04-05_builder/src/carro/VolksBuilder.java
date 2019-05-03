package carro;

public class VolksBuilder extends CarroBuilder{
	@Override
	public void buildPreco() {
		carro.setPreco(43000.00);
	}

	@Override
	public void buildDscMotor() {
		carro.setDscMotor("1.6 Flex");
	}

	@Override
	public void buildAnoDeFabricacao() {
		carro.setAnoDeFabricacao(2017);
	}

	@Override
	public void buildModelo() {
		carro.setModelo("Gol");
	}

	@Override
	public void buildMontadora() {
		carro.setMontadora("Volkswagen");
	}
}
