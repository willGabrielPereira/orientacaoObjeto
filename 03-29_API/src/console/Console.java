/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import com.api.API;
import dto.Carro;

/**
 *
 * @author willg
 */
public class Console {
    
    public static void main(String[] args){
        API api = new API();
        
        System.out.println(api.testeConexao());
        
        api.carregaMarcas();
        System.out.println(api.getMarcas().get(0));
        System.out.println(api.salvaMarca());
        
        api.carregaVeiculos(api.getMarcas().get(0));
        System.out.println(api.getVeiculos().get(0));
        System.out.println(api.salvaVeiculo());
        
        api.carregaModelos(api.getVeiculos().get(0));
        System.out.println(api.getModelos().get(0));
        System.out.println(api.salvaModelo());
        
        Carro carro = api.carregaCarro(api.getModelos().get(0));
        System.out.println(carro);
        System.out.println(api.salvaCarro(carro));
        
        api.limpaMarcas();
        System.out.println(api.getMarcas().get(0));
    }
}
