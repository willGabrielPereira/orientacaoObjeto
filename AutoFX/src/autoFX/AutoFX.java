/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoFX;

import autoFX.grafica.CriadorInterface;
import javafx.scene.Scene;
import javafx.stage.Stage;
import autoFX.reflection.Reflection;
import java.io.File;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.WindowEvent;

/**
 * 
 * @author willg
 */
public final class AutoFX{

    /**
     * Classe interna da framework<br>
     * Baseado em <code>java.reflection</code>, é utilizado para trabalhar com a classe do usuario
     */
    protected Reflection reflection;
    /**
     * Classe interna da framework<br>
     * Criador e modificador da interface.
     */
    protected CriadorInterface criador;
    private Scene cena;
    private Stage stage;
    private boolean mostrando;
    private static AutoFX instancia;

    
    /**
     * Singleton para o AutoFX não possuir mais de uma tela, evitando disperdicio de memória e processador
     * @param classe classe que será trabalhada
     * @param stage tela (<code>Stage</code>) em que será apresentada as informações
     * @return  <code>autoFX.AutoFX</code>
     */
    public static AutoFX getInstance(Class<?> classe, Stage stage) {
        if (instancia == null) {
            instancia = new AutoFX(classe, stage);
        }
        return instancia;
    }

    private AutoFX(Class<?> classe, Stage stage) {
        this.reflection= Reflection.getInstance(classe);
        this.stage = stage;
        criador = CriadorInterface.getInstance(reflection);
        mostrando = false;
    }

    /**
     * Cria stage:Stage e cena:Scene <br>
     * Automaticamente mostra em tela
     */
    public void apresentarTela() {
        criador.iniciaCena();

        Scene scene = criador.getCena();
        stage.setScene(scene);
        stage.show();
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                FileChooser chooser = new FileChooser();
                File local = chooser.showSaveDialog(stage);
                System.out.println(local);
                criador.salvarJson(local);

                // Coloque aqui o código a ser executado ao fechar o sistema.

                stage.close();
                Platform.exit();
                System.exit(0);
            }
        });
        
        mostrando = true;
    }

    /**
     * Esconde a tela (<code>stage.hide()</code>)
     */
    public void esconderTela() {
        if (mostrando) {
            stage.hide();
            mostrando = false;
        }
    }

    /**
     * Mostra a tela (<code>stage.show()</code>) e cria caso não exista <code>stage</code>
     */
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
    
    /**
     * Salva em arquivo JSON os objetos
     * @param local diretório a ser guardado o arquivo
     * @return true caso exito, false caso erro
     */
    public boolean salvaJson(File local){
        return criador.salvarJson(local);
    }
    

}
