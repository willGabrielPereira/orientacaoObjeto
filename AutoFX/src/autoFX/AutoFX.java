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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.WindowEvent;

/**
 *
 * @author willg
 */
public final class AutoFX {

    /**
     * Classe interna da framework<br>
     * Baseado em <code>java.reflection</code>, é utilizado para trabalhar com a
     * classe do usuario
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
    private boolean salvarAoFechar;

    /**
     * Singleton para o AutoFX não possuir mais de uma tela, evitando
     * disperdicio de memória e processador
     *
     * @param classe classe que será trabalhada
     * @param stage tela (<code>Stage</code>) em que será apresentada as
     * informações
     * @return  <code>autoFX.AutoFX</code>
     */
    public static AutoFX getInstance(Class<?> classe, Stage stage) {
        if (instancia == null) {
            instancia = new AutoFX(classe, stage);
        }
        return instancia;
    }

    private AutoFX(Class<?> classe, Stage stage) {
        this.reflection = Reflection.getInstance(classe);
        this.stage = stage;
        criador = CriadorInterface.getInstance(reflection);
        salvarAoFechar = true;
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

        if (salvarAoFechar) {
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent t) {
                    if (criador.getLista().size() > 0) {
                        fileChooser();
                    }
                    // Coloque aqui o código a ser executado ao fechar o sistema.

                    stage.close();
                    Platform.exit();
                    System.exit(0);
                }
            });
        }

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
     * Mostra a tela (<code>stage.show()</code>) e cria caso não exista
     * <code>stage</code>
     */
    public void mostrarTela() {
        if (!mostrando) {
            if (stage.getScene() != null) {
                this.apresentarTela();
            } else {
                stage.show();
                mostrando = true;
            }
        }
    }

    /**
     * Salva em arquivo JSON os objetos
     *
     * @param local diretório a ser guardado o arquivo
     * @return true caso exito, false caso erro
     */
    public boolean salvaJson(File local) {
        return criador.salvarJson(local);
    }

    public void setSalvarAoFechar(boolean salvarAoFechar) {
        this.salvarAoFechar = salvarAoFechar;
    }
    public Stage getStage(){
        return stage;
    }

    private void fileChooser() {
        FileChooser chooser = new FileChooser();

        FileChooser.ExtensionFilter ex = new FileChooser.ExtensionFilter("JSON File", ".json");
        chooser.getExtensionFilters().add(ex);
        chooser.setInitialFileName("*.json");

        File local = chooser.showSaveDialog(stage);
        if (local == null) {
            Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType btSim = new ButtonType("sim");
            ButtonType btNao = new ButtonType("não");

            dialog.setTitle("Confirmar");
            dialog.setContentText("Deseja fechar sem salvar?");
            dialog.getButtonTypes().setAll(btSim, btNao);

            dialog.showAndWait().ifPresent(bt -> {
                if (bt == btSim) {
                    System.out.println("fechow");
                    stage.close();
                    Platform.exit();
                    System.exit(0);
                } else {
                    fileChooser();
                }
            });
        } else {
            if (local.getName().endsWith(".json")) {
                criador.salvarJson(local);
            } else {
                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setTitle("Error");
                dialog.setContentText("Extensão de arquivo incorreto!");
            }
        }
    }

}
