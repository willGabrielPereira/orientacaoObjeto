package comida.factory;

import comida.produto.Lanche;
import comida.produto.Produto;

public class FactoryLanche extends AbsFactory{

	@Override
	public Produto criaObjeto() {
		return new Lanche();
	}

}
