package comida.Produto;

import comida.abs.AbsComida;

public class Pizza extends AbsComida{

	@Override
	public AbsComida clonar() {
		AbsComida clone = new Pizza();
		clone.setTamanho(this.getTamanho());
		clone.setPreco(this.getPreco());
		return clone;
	}

	@Override
	public String info() {
		return "Pizza tamanho: "+this.getTamanho();
	}
	
}
