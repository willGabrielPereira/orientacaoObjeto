package carro;

public class Cliente {
	public static void main(String[] args) {
		ConcessionariaDirector concessionaria = 
				new ConcessionariaDirector(new FiatBuilder());
		concessionaria.construirCarro();
		CarroProduct carro  = concessionaria.getCarro();
		System.out.println(carro);
		
		concessionaria = new ConcessionariaDirector(new VolksBuilder());
		concessionaria.construirCarro();
		carro = concessionaria.getCarro();
		System.out.println(carro);
	}
}
