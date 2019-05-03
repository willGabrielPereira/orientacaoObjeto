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
        
        api.carregaMarcas();
        System.out.println(api.getMarcas());
    }
}
