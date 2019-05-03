package contadorArray;

public class Contador{
	public static <T extends Comparable<T>> int count(T[] array, T chave) {
		int count = 0;
		
		for(T t : array) {
			if(t.compareTo(chave)>0) {
				count++;
			}
		}
		return count;
	}

}
