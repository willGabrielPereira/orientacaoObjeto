package main;

import carro.factory.AbsFactory;
import carro.produto.Produto;

public class Main2 {
	public static void main(String[] args) {
		Produto suv = AbsFactory.criaObjeto("SUV");
		suv.setMarca("Jeep");
		Produto sedan = AbsFactory.criaObjeto("sedan");
		sedan.setMarca("BMW");
		System.out.println(suv.info());
		System.out.println(sedan.info());
	}
}
