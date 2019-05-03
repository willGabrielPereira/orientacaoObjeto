package main;

import carro.Produto.Fiat;
import carro.abs.AbsCarro;

public class Main2 {

	public static void main(String[] args) {
		AbsCarro fiat = new Fiat();
		fiat.setQuilometragem(3000f);
		AbsCarro fiatNovo = fiat.clonar();
		fiatNovo.setQuilometragem(0);
		
		System.out.println(fiat.info());
		System.out.println(fiatNovo.info());
		
	}

}
