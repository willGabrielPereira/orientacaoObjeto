package main;

import comida.Produto.Lanche;
import comida.Produto.Pizza;
import comida.abs.AbsComida;

public class Main1 {
	public static void main(String[] args) {
		AbsComida pizza = new Pizza();
		pizza.setTamanho(45);
		AbsComida pizza2 = pizza.clonar();
		pizza2.setTamanho(35);
		System.out.println(pizza.info());
		System.out.println(pizza2.info());
		
		AbsComida lanche = new Lanche();
		lanche.setTamanho(1);
		AbsComida lanche2 = lanche.clonar();
		lanche2.setTamanho(2);
		System.out.println(lanche.info());
		System.out.println(lanche2.info());
	}
}
