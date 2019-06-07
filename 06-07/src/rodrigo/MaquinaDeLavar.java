package rodrigo;

public class MaquinaDeLavar {
	private int temperaturaAgua;
	private int duracaoCicloLavagem;
	
	public void addSabaoEmPo() {
		System.out.println("Sabao em pó adicionado");
	}
	public void addAmaciante() {
		System.out.println("Amaciante adicionate");
	}
	public void iniciarLavagem() {
		System.out.println("Lavagem iniciada");
	}
	public int getTemperaturaAgua() {
		return temperaturaAgua;
	}
	public void setTemperaturaAgua(int temperaturaAgua) {
		this.temperaturaAgua = temperaturaAgua;
	}
	public int getDuracaoCicloLavagem() {
		return duracaoCicloLavagem;
	}
	public void setDuracaoCicloLavagem(int duracaoCicloLavagem) {
		this.duracaoCicloLavagem = duracaoCicloLavagem;
	}
	
	
}
