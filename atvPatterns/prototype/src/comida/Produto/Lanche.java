package comida.Produto;

import comida.abs.AbsComida;

public class Lanche extends AbsComida{

	@Override
	public AbsComida clonar() {
		AbsComida clone = new Lanche();
		clone.setTamanho(this.getTamanho());
		clone.setPreco(this.getPreco());
		return clone;
	}

	@Override
	public String info() {
		return "Lanche tamanho: "+this.getTamanho();
	}

}
