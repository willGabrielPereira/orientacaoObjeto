package rodrigo;

public class MaquinaDeLavarFacade {
	MaquinaDeLavar maquina = new MaquinaDeLavar();
	
	public void lavaRoupaMuitoSuja() {
		maquina.setTemperaturaAgua(100);
		maquina.setDuracaoCicloLavagem(90);
		maquina.addSabaoEmPo();
		maquina.addAmaciante();
		maquina.iniciarLavagem();
	}
	
	public void lavaRoupaPoucoSuja() {
		maquina.setTemperaturaAgua(40);
		maquina.setDuracaoCicloLavagem(40);
		maquina.addSabaoEmPo();
		maquina.addAmaciante();
		maquina.iniciarLavagem();
	}
}
