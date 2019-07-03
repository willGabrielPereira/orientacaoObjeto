/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import autoFX.Framework;
import javafx.stage.Stage;

/**
 *
 * @author willg
 */
public class Teste extends Framework{

    @Override
    public void start(Stage primaryStage) {
        setClassToAutoFX(Coisa.class, primaryStage);
        getAutofx().apresentarTela();
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
