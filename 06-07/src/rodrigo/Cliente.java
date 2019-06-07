package rodrigo;

public class Cliente {

	public static void main(String[] args) {
		MaquinaDeLavarFacade facade = new MaquinaDeLavarFacade();
		
		facade.lavaRoupaMuitoSuja();		
		facade.lavaRoupaPoucoSuja();
	}

}
