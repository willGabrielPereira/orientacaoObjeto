package carro.factory;

import carro.produto.SUV;
import carro.produto.Produto;

public class FactorySUV extends AbsFactory{

	@Override
	public Produto criaObjeto() {
		return new SUV();
	}
	
}
