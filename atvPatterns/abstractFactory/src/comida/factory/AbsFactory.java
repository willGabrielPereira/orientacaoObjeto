package comida.factory;

import comida.produto.Produto;

public abstract class AbsFactory {
	public static Produto criaObjeto(String tipo) {
		AbsFactory factory;
		switch(tipo.toLowerCase()) {
		case "lanche":
			factory = new FactoryLanche();
			break;
		case "pizza":
			factory = new FactoryPizza();
			break;
		default:
			return null;
		}
		return factory.criaObjeto();
	}
	public abstract Produto criaObjeto();
}
