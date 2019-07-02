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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import reflection.Reflection;
/**
 *
 * @author willg
 */
public class CriadorPanel {
    private Reflection reflection;
    private Field[] atributos;
    private Scene cena;
    private List<TextField> fields;
    
    public CriadorPanel(Reflection reflection){
        this.atributos = reflection.getAtributos();
        this.reflection = reflection;
        fields = new ArrayList<TextField>();
    }
    
    public Scene getCena(){
        return cena;
    }
    
    public boolean criaCena(){
        // CRIA ANCHORPANE(AP)
        AnchorPane ap = new AnchorPane();
        ap.setMinHeight(400);
        ap.setMinWidth(600);
        ap.setMaxHeight(400);
        ap.setMaxWidth(600);
        ap.setPrefHeight(400);
        ap.setPrefWidth(600);
        // CRIA SCROLLPANE(SP)
        ScrollPane sp = new ScrollPane();
        sp.setPrefHeight(350);
        sp.setPrefWidth(600);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        // ADICIONA SP DENTRO DE AP
        ap.getChildren().add(sp);
        // CRIA PANE INTERNO DO SCROLL
        Pane ap2 = new Pane();
        ap2.setPrefWidth(600);
        ap2.setMinHeight(0);
        ap2.setMinWidth(590);
        ap2.setMaxWidth(600);
        // ADICIONA AP2 EM SP
        sp.setContent(ap2);
        
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
            ap2.setPrefHeight(soma);
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
            ap2.getChildren().add(lb);
            ap2.getChildren().add(tf);
            
            fields.add(tf);
        }
        
        // BOTÃO
        Button bt = new Button("Salvar");
        bt.setLayoutX(500);
        bt.setLayoutY(360);
        bt.setPrefHeight(25);
        bt.setPrefWidth(75);
        // AÇÃO CLIQUE DO MOUSE
        bt.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent e){
                pegaDados();
            }
        });
        
        // ADICIONA BOTÃO NA TELA PRIMARIA
        ap.getChildren().add(bt);
        cena = new Scene(ap, 600, 400);
        
        return true;
    }
    
    public Object pegaDados(){
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
        
        return null;
    }
}
