/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafica;

import javafx.scene.Scene;
import javafx.stage.Stage;
import reflection.Reflection;

/**
 *
 * @author willg
 */
public final class AutoFX{

    protected Reflection r;
    protected CriadorInterface ci;
    private Scene cena;
    private Stage stage;
    private boolean mostrando;
    private static AutoFX instancia;

    public static AutoFX getInstance(Class<?> classe, Stage stage) {
        if (instancia == null) {
            instancia = new AutoFX(classe, stage);
        }
        return instancia;
    }

    private AutoFX(Class<?> classe, Stage stage) {
        this.r = Reflection.getInstance(classe);
        this.stage = stage;
        ci = CriadorInterface.getInstance(r);
        mostrando = false;
    }

    public void apresentarTela() {
        ci.iniciaCena();

        Scene scene = ci.getCena();

        stage.setScene(scene);

        stage.show();
        
        mostrando = true;

    }

    public void esconderTela() {
        if (mostrando) {
            stage.hide();
            mostrando = false;
        }
    }

    public void mostrarTela() {
        if (!mostrando) {
            if(stage.getScene() != null){
                this.apresentarTela();
            }else{
                stage.show();
                mostrando = true;
            }
        }
    }


}
