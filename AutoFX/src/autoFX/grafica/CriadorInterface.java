/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoFX.grafica;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import autoFX.reflection.Reflection;

/**
 * Utilizado para o desenvolvimento da interface gráfica <br>
 * Gera botões, Labels (legendas) e TextFields (entradas)
 * @author willg
 */
public final class CriadorInterface{
    private static CriadorInterface ci;
    private static Reflection reflection;
    private List lista;
    private Field[] atributos;
    private Scene cena;
    private List<TextField> fields;
    
    /**
     * Singleton para o CriadorInterface, evitando disperdicio de memória e processador
     * @param reflection Reflection que a interface utilizará
     * @return CriadorInterface
     */
    public static synchronized CriadorInterface getInstance(Reflection reflection){
        if(ci == null){
            ci = new CriadorInterface(reflection);
        }        
        return ci;
    }
    
    private CriadorInterface(Reflection reflection){
        this.atributos = reflection.getAtributos();
        CriadorInterface.reflection = reflection;
        fields = new ArrayList<>();
        lista = new ArrayList<>();
    }
    
    /**
     * Inicia a Scene (cena), usando o FXML padrão que gera toda a tela de fundo
     */
    public void iniciaCena(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("tela.fxml"));
            cena = new Scene(root);
        } catch (IOException ex) {
            Logger.getLogger(CriadorInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Scene getCena(){
        return cena;
    }

    public CriadorInterface getCi() {
        return ci;
    }

    /**
     * Retorna lista dos objetos salvos
     * @return List
     */
    public List getLista() {
        return lista;
    }
    
    /**
     * Gera as legendas e entradas de acordo com a classe recebida
     * @param painelCad Pane ao qual será adicionada as legendas e entradas
     * @return Pane possuindo label e textField de cada atributo
     */
    public Pane criaCena(Pane painelCad){
        
        int layoutY = 42;
        final int layoutXLabel = 68;
        final int layoutXText = 308;
        
        Font fonte = new Font("Times New Roman", 16);
        
        if(atributos.length>0){
            int soma = 42+25;
            for(int i=1; i<atributos.length; i++){
                soma+=33;
            }
            soma+=10;
            painelCad.setPrefHeight(soma);
        }
        
        for(Field f : atributos){
            // CRIA LABEL
            Label lb = new Label();
            lb.setPrefHeight(19);
            lb.setPrefWidth(232);
            lb.setLayoutX(layoutXLabel);
            lb.setLayoutY(layoutY);
            lb.setFont(fonte);
            lb.setText(f.getName());
            // CRIA TEXTFIELD
            TextField tf = new TextField();
            tf.setPrefHeight(25);
            tf.setPrefWidth(249);
            tf.setLayoutX(layoutXText);
            tf.setLayoutY(layoutY);
            tf.setPromptText(f.getName());
            // ADICIONA TF COMO CAPTURADO PELO LABEL
            lb.setLabelFor(tf);
            
            // AUMENTA DISTANCIA VERTICAL
            layoutY+=33;
            
            // ADICIONA LB E TF NO PANE DO SCROLL
            painelCad.getChildren().add(lb);
            painelCad.getChildren().add(tf);
            
            fields.add(tf);
        }
        
        return painelCad;
    }
    
    /**
     * Adquire os dados que estão dentro dos TextFields e logo adiciona à lista de objetos salvos
     */
    public void pegaDados(){
        reflection.novoObjeto();
        for(int i=0; i<atributos.length; i++){
            switch(atributos[i].getType().getName()){
                default :
                    reflection.invokeParaAtributo(atributos[i], Reflection.SET, fields.get(i).getText());
                    break;
                case "int":
                    int t = Integer.parseInt(fields.get(i).getText());
                    reflection.invokeParaAtributo(atributos[i], Reflection.SET, t);
                    break;
                case "float":
                    float f = Float.parseFloat(fields.get(i).getText());
                    reflection.invokeParaAtributo(atributos[i], Reflection.SET, f);
                    break;
                case "double":
                    double d = Double.parseDouble(fields.get(i).getText());
                    reflection.invokeParaAtributo(atributos[i], Reflection.SET, d);
                    break;
                case "boolean":
                    boolean b = Boolean.parseBoolean(fields.get(i).getText());
                    reflection.invokeParaAtributo(atributos[i], Reflection.SET, b);
                    break;
                case "char":
                    char c = fields.get(i).getText().charAt(0);
                    reflection.invokeParaAtributo(atributos[i], Reflection.SET, c);
                    break;
                case "byte":
                    byte by = Byte.parseByte(fields.get(i).getText());
                    reflection.invokeParaAtributo(atributos[i], Reflection.SET, by);
                    break;
                case "short":
                    short s = Short.parseShort(fields.get(i).getText());
                    reflection.invokeParaAtributo(atributos[i], Reflection.SET, s);
                    break;
                case "long":
                    long l = Long.parseLong(fields.get(i).getText());
                    reflection.invokeParaAtributo(atributos[i], Reflection.SET, l);
                    break;
            }
        }
        limpaTextFields();
        lista.add(reflection.getObjeto());
    }
    
    /**
     * Carrega os dados para dentro dos TextFields a partir do objeto recebido
     * @param obj Objeto que possui os dados
     */
    public void carregaDados(Object obj){
        List<String> texto = new ArrayList<String>();
        for(Field f:atributos){
            texto.add(reflection.invokeParaAtributo(f, Reflection.GET, null, obj).toString());
        }
        for(int i=0; i<texto.size(); i++){
            fields.get(i).setText(texto.get(i));
        }
    }
    
    /**
     * Remove objeto da lista
     * @param obj Objeto a ser removido
     */
    public void remover(Object obj){
        lista.remove(obj);
        limpaTextFields();
    }
    
    /**
     * Remove qualquer tipo de dado de dentro dos TextFields
     */
    public void limpaTextFields(){
        for(TextField tf:fields){
            tf.setText("");
        }
    }

    @Override
    public String toString() {
        return "CriadorInterface{" + "reflection=" + reflection + '}';
    }
    
}
