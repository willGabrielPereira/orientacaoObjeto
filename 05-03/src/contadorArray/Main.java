package contadorArray;

public class Main {

	public static void main(String[] args) {
		int[] a1 = {5, 10, 15, 2, -5, 100};
		int chave = 9;
		
		int total = Contador.<Integer>count(a1, chave);

	}

}
