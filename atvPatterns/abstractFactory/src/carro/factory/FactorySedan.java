package carro.factory;

import carro.produto.Produto;
import carro.produto.Sedan;

public class FactorySedan extends AbsFactory{

	@Override
	public Produto criaObjeto() {
		return new Sedan();
	}

}
