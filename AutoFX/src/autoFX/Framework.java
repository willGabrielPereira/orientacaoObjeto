/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoFX;

import javafx.application.Application;
import javafx.stage.Stage;
import grafica.AutoFX;
import reflection.Reflection;

/**
 *
 * @author willg
 */
public abstract class Framework extends Application {
    private AutoFX autofx;

    public final AutoFX getAutofx() {
        return autofx;
    }
    
    public final void setClassToAutoFX(Class<?> classe, Stage stage){
        autofx = AutoFX.getInstance(classe, stage);
    }
    
    @Override
    public abstract void start(Stage primaryStage);
    
}
