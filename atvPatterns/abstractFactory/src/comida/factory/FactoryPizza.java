package comida.factory;

import comida.produto.Pizza;
import comida.produto.Produto;

public class FactoryPizza extends AbsFactory{

	@Override
	public Produto criaObjeto() {
		return new Pizza();
	}

}
