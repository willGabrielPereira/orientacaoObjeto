package uteis;

public class Numeros {
	/**
	 * maior;
	 * acha o maior numero de um vetor
	 * @author William Gabriel Pereira
	 * @param n chamar sempre como 0
	 * @param v vetor de inteiros
	 * @return maior como inteiro
	 */
	public static int maior(int n, int v[]) {
		if (n == v.length-1)
        {    
            return v[n];
        } 
        else 
        { 
            int maior = maior(n+1, v);
            if (maior > v[n]){    
                return maior;    
            }else{    
                return v[n];     
            }    
        }
	}
	
	/**
	 * menor;
	 * acha o menor nummero de um vetor
	 * @author William Gabriel Pereira
	 * @param n chamar sempre como 0
	 * @param v vetor de inteiros
	 * @return menor como inteiro
	 */
	public static int menor(int n, int v[]) {
		if (n == v.length-1)
        {    
            return v[n];
        } 
        else 
        { 
            int menor = menor(n+1, v);
            if (menor < v[n]){    
                return menor;    
            }else{    
                return v[n];     
            }    
        }
	}
	
	/**
	 * expoente;
	 * gera o valor resultado de uma potenciação
	 * @author William Gabriel Pereira
	 * @param x double, base
	 * @param n int, expoente
	 * @return double
	 */
	public static double expoente(double x, int n) {
		if(n <= 0) {
			return 1;
		}else {
			return expoente(x, n-1)*x;
		}
	}
	
	/**
	 * fibonacci;
	 * gera o valor no elemento n da sequencia
	 * @author William Gabriel Pereira
	 * @param numero int
	 * @return int
	 */
	public static int fibonacci(int numero) {
		if(numero==0) {
			return 0;
		}else if(numero == 1) {
			return 1;
		}else {
			return fibonacci(numero-1) + fibonacci(numero-2);
		}
	}
	
	/**
	 * sequenciaFibonacci;
	 * gera um array de int com os valores fibonacci até o elemento desejado
	 * @author William Gabriel Pereira
	 * @param max int; quantidade de elementos
	 * @return array de int
	 */
	public static int[] sequenciaFibonacci(int max) {
		int fibo[] = new int[max+1];
		for(int i=0; i<max+1; i++) {
			fibo[i] = fibonacci(i);
		}
		return fibo;
	}
	
	/**
	 * fatorial;
	 * @param numero int
	 * @return int
	 */
	public static int fatorial(int numero) {
		if(numero<=1) {
			return 1;
		}else {
			return fatorial(numero-1)*numero;
		}
	}
}
