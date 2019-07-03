/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoFX.grafica;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * Controlador da interface gráfica
 * @author willg
 */
public final class Controlador implements Initializable{

    private CriadorInterface criador;
    private Object selecionado;
    private ObservableList obsList;
    
    @FXML
    private Button salvar;

    @FXML
    private Button remover;

    @FXML
    private Button alterar;

    @FXML
    private Pane painelCad;

    @FXML
    private Pane PainelTable;

    @FXML
    private ListView listV;

    /**
     * Altera os dados do Objeto selecionado
     * @param event clique do mouse
     */
    @FXML
    void funcaoAlterar(ActionEvent event) {
        criador.pegaDados();
        criador.remover(selecionado);
        atualizaLista();
    }

    /**
     * Remove objeto selecionado
     * @param event clique do mouse
     */
    @FXML
    void funcaoRemover(ActionEvent event) {
        criador.remover(selecionado);
        atualizaLista();
    }

    /**
     * Salva Objeto
     * @param event clique do mouse 
     */
    @FXML
    void funcaoSalvar(ActionEvent event) {
        criador.pegaDados();
        
        atualizaLista();
    }

    /**
     * Seleciona objeto ao clicá-lo na lista
     * @param event clique do mouse
     */
    @FXML
    void selecionarObjeto(MouseEvent event) {
        int index = listV.getSelectionModel().getSelectedIndex();
        selecionado = criador.getLista().get(index);
        criador.carregaDados(selecionado);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        criador = CriadorInterface.getInstance(null);
        painelCad = criador.criaCena(painelCad);
    }
    
    /**
     * Atualiza a lista de objetos salvos
     */
    public void atualizaLista(){
        List lista = criador.getLista();
        obsList = FXCollections.observableArrayList(lista);
        
        int soma = 0;
        for(int i=0; i<obsList.size(); i++){
            soma+=23;
        }
        listV.setPrefHeight(soma);
        listV.setItems(obsList);
    }
    
}
