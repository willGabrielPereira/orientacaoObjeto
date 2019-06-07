package agenda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Agenda {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Quantas pessoas deseja adicionar? ");
		int qnts = Integer.parseInt(ler.nextLine());
		
		Pessoa[] pessoas = new Pessoa[qnts];
		for(int i=0; i<qnts; i++) {
			pessoas[i] = new Pessoa();
			
			// LÊ NOME
			System.out.print("Nome: ");
			pessoas[i].setNome(ler.nextLine());
			
			// LÊ SOBRENOME
			System.out.print("Sobrenome: ");
			pessoas[i].setSobrenome(ler.nextLine());
			
			// LÊ FONE
			System.out.print("Telefone: ");
			pessoas[i].setFone(Long.parseLong(ler.nextLine()));
			
			// LÊ ENDERECO
			System.out.print("Endereco: ");
			pessoas[i].setEndereco(ler.nextLine());
		}
		
		
		System.out.println("Todas as pessoas: ");
		System.out.println(Arrays.toString(pessoas));
	}

}
