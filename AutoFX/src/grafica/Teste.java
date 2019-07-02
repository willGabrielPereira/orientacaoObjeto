/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafica;

import javafx.application.Application;
import javafx.stage.Stage;
import reflection.Reflection;
import testes.Coisa;
import testes.Pessoa;

/**
 *
 * @author willg
 */
public class Teste extends Application {
    
    @Override
    public void start(Stage stage) throws Exception{
        Reflection r = Reflection.getInstance(Coisa.class);
        
        CriadorInterface cp = CriadorInterface.getInstance(r);
        cp.iniciaCena();
        
        stage.setTitle(r.getNomeClasse());
        stage.setScene(cp.getCena());
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        Teste t = new Teste();
    }
    
}
