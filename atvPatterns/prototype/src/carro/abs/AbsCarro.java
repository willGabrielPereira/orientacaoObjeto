package carro.abs;

public abstract class AbsCarro {
	private float quilometragem;
	
	public abstract AbsCarro clonar();
	public abstract String info();
	
	public void setQuilometragem(float quilometragem) {
		this.quilometragem = quilometragem;
	}
	public float getQuilometragem() {
		return quilometragem;
	}
	
}
