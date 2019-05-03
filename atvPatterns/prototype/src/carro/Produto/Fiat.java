package carro.Produto;

import carro.abs.AbsCarro;

public class Fiat extends AbsCarro{

	@Override
	public AbsCarro clonar() {
		AbsCarro clone = new Fiat();
		clone.setQuilometragem(this.getQuilometragem());
		return clone;
	}

	@Override
	public String info() {
		return "Fiat km: "+this.getQuilometragem();
	}

}
