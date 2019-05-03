package carro.factory;

import carro.produto.Produto;

public abstract class AbsFactory {
	public static Produto criaObjeto(String tipo) {
		AbsFactory factory;
		switch(tipo.toLowerCase()) {
		case "suv":
			factory = new FactorySUV();
			break;
		case "sedan":
			factory = new FactorySedan();
			break;
		default:
			return null;
		}
		return factory.criaObjeto();
	}
	public abstract Produto criaObjeto();
}
