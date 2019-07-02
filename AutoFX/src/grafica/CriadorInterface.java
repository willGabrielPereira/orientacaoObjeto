/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafica;

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
import reflection.Reflection;

/**
 *
 * @author willg
 */
public class CriadorInterface{
    private static CriadorInterface ci;
    private static Reflection reflection;
    private List lista;
    private Field[] atributos;
    private Scene cena;
    private List<TextField> fields;
    
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
    
    public void iniciaCena(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/tela.fxml"));
            cena = new Scene(root);
        } catch (IOException ex) {
            Logger.getLogger(CriadorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Scene getCena(){
        return cena;
    }

    public CriadorInterface getCi() {
        return ci;
    }

    public List getLista() {
        return lista;
    }
    
    
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
    
    public void carregaDados(Object obj){
        List<String> texto = new ArrayList<String>();
        for(Field f:atributos){
            texto.add(reflection.invokeParaAtributo(f, Reflection.GET, null, obj).toString());
        }
        for(int i=0; i<texto.size(); i++){
            fields.get(i).setText(texto.get(i));
        }
    }
    
    public void remover(Object obj){
        lista.remove(obj);
        limpaTextFields();
    }
    
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
