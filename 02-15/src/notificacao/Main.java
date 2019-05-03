package notificacao;

public class Main {

	public static void main(String[] args) {
		Notificacao n = new Sms();
		Alerta a = new Alerta(n);
		System.out.println(a.dispararAlerta());

	}

}
