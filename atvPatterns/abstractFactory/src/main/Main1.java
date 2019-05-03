package main;

import comida.factory.AbsFactory;
import comida.produto.Produto;

public class Main1 {
	public static void main(String[] args) {
		Produto lanche = AbsFactory.criaObjeto("lanche");
		Produto pizza = AbsFactory.criaObjeto("Pizza");
		
		System.out.println(lanche.info());
		System.out.println(pizza.info());
	}
}
