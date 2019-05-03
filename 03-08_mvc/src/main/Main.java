package main;
import java.util.ArrayList;
import java.util.List;

import bo.MarcaBo;
import dto.Marca;
public class Main {

	public static void main(String[] args) {
		pesquisarDesc();

	}
	
	public static void add() {
		MarcaBo marcaBO = new MarcaBo();
		Marca marca = new Marca("DELL");
		
		if(marcaBO.inserir(marca)) {
			System.out.println("Inserido com sucesso");
		}else {
			System.out.println("Erro ao inserir");
		}
		marca = new Marca("Android");
		if(marcaBO.inserir(marca)) {
			System.out.println("Inserido com sucesso");
		}else {
			System.out.println("Erro ao inserir");
		}
		marca = new Marca("LG");
		if(marcaBO.inserir(marca)) {
			System.out.println("Inserido com sucesso");
		}else {
			System.out.println("Erro ao inserir");
		}
	}
	
	public static void alterar() {
		MarcaBo marcaBO = new MarcaBo();
		Marca marca = new Marca(1,"Nova Marca");
		marcaBO.alterar(marca);
		marca = marcaBO.procurarPorCodigo(marca);
		System.out.println(marca);
	}
	
	public static void excluir() {
		MarcaBo marcaBO = new MarcaBo();
		Marca marca = new Marca(1);
		if ( marcaBO.excluir(marca))
			System.out.println("Excluido com Sucesso");
		else
			System.out.println("Erro ao Excluir");
	}
	public static void existe() {
		MarcaBo marcaBO = new MarcaBo();
		Marca marca = new Marca("LG");
		if ( marcaBO.existe(marca))
			System.out.println("Marca existe");
		else
			System.out.println("Marca não existe");
	}
	public static void pesquisaTodos() {
		MarcaBo marcaBO = new MarcaBo();
		List<Marca> lista = new ArrayList<Marca>();
		lista = marcaBO.PesquisarTodos ();
		for ( Marca marca : lista ) {
			System.out.println(marca.toString());
		}
	}
	public static void pesquisaCod() {
		MarcaBo marcaBO = new MarcaBo();
		Marca marca = new Marca(2);
		marca = marcaBO.procurarPorCodigo(marca);
		System.out.println(marca);
	}
	public static void pesquisarDesc() {
		MarcaBo marcaBO = new MarcaBo();
		Marca marca = new Marca("Android");
		marca = marcaBO.procurarPorDescricao(marca);
		System.out.println(marca);
	}
}
