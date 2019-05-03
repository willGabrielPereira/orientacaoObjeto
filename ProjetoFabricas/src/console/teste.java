package console;

import library.Biblioteca;

import java.util.List;

import java.util.Scanner;

import DTOs.*;

public class teste {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Biblioteca biblio = new Biblioteca();
		
		if(biblio.verificaConexao("http://fipeapi.appspot.com/api/1/carros/marcas.json")) {
			System.out.println("Conexão estabelecida com sucesso!");
			
			List<Marca> marcas = (List<Marca>) biblio.fabricaLista("marca", 
					"http://fipeapi.appspot.com/api/1/carros/marcas.json");
			mostraMarcas(marcas);
			
			System.out.println("\n\nselecionar ID");
			int idMarca = Integer.parseInt(scan.nextLine());
			
			List<Veiculo> veiculos = (List<Veiculo>) biblio.fabricaLista("veiculo",
					"http://fipeapi.appspot.com/api/1/carros/veiculos/"+idMarca+".json");
			
			mostraVeiculos(veiculos);
			
			System.out.println("\n\nselecionar ID veículo");
			String idVeiculo = scan.nextLine();
			
			List<AnoModelo> modelos = (List<AnoModelo>) biblio.fabricaLista("anomodelo",
					"http://fipeapi.appspot.com/api/1/carros/veiculo/"+idMarca+""
							+ "/"+idVeiculo+".json");
			mostraModelos(modelos);
			
			System.out.println("\n\nselecionar ID modelo");
			String idModelo = scan.nextLine();
			
			List<VeiculoFinal> vFinal = (List<VeiculoFinal>) biblio.fabricaLista(
					"veiculoFinal", "http://fipeapi.appspot.com/api/1/carros"
							+ "/veiculo/"+idMarca+"/"+idVeiculo+"/"+idModelo+".json");
			
			mostraFinal(vFinal);
			
			biblio.exportaLista(marcas, "marcas");
			
			marcas = biblio.limpaLista(marcas);
			
			mostraMarcas(marcas);
			
		}else {
			System.out.println("Sem Conexão!!! Desligando...");
		}
		
		
	}
	public static void mostraMarcas(List<Marca> marcas) {
		for(Marca m : marcas) {
			System.out.println(m.getId()+": "+m+";");
		}
	}
	public static void mostraVeiculos(List<Veiculo> veiculos) {
		for(Veiculo v : veiculos) {
			System.out.println(v.getId()+": "+v+";");
		}
	}
	public static void mostraModelos(List<AnoModelo> modelos) {
		for(AnoModelo a : modelos) {
			System.out.println(a.getId()+": "+a+";");
		}
	}
	public static void mostraFinal(List<VeiculoFinal> vFinal) {
		VeiculoFinal f = vFinal.get(0);
		System.out.println("Veiculo encontrado: ");
		System.out.println("id: "+f.getId());
		System.out.println("modelo ano: "+f.getAno_modelo());
		System.out.println("marca: "+f.getMarca());
		System.out.println("nome: "+f.getName());
		System.out.println("preco: "+f.getPreco());
		System.out.println("combustivel: "+f.getCombustivel());
		System.out.println("referencia: "+f.getReferencia());
		System.out.println("codigo fipe: "+f.getFipe_codigo());
	}

}
