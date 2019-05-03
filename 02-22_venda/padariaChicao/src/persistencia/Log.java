/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
import uteis.Datas;

/**
 *
 * @author willg
 */
public class Log {

    private class logs {

        public String texto;
        public String data;
        public String usuario;
        public String tipo_usuario;
    }

    private List<logs> log;

    public Log() {
        log = new ArrayList<>();
        
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("log.json"));
            Type listType = new TypeToken<ArrayList<referenciaBanco.Produto>>() {
            }.getType();

            List lista = new ArrayList<>();
            lista = new Gson().fromJson(bufferedReader, listType);
            log.addAll(lista);

        } catch (IOException e) {
            printStackTrace(e);
        }
    }
    
    /**
     * Adicionar linha ao Log
     * @param crud enviar uma das letrar CRUD
     * @param apelido_usuario
     * @param tipoUsuario c->cliente v->vendedor
     * @param tabela tabela modificada
     */
    public void adicionaLinha(char crud, String apelido_usuario, char tipoUsuario, String tabela){
        Date d = new Date();
        logs l = new logs();
        l.data = Datas.dataCompletaToString(d);
        switch(tipoUsuario){
            case 'c':
                l.tipo_usuario = "Cliente";
                break;
            case 'v':
                l.tipo_usuario = "Vendedor";
                break;
        }
        
        l.usuario = apelido_usuario;
        
        switch(crud){
            case 'c':
                l.texto = "Criou em ";
                break;
            case 'r':
                l.texto = "Leu/pesquisou em ";
                break;
            case 'u':
                l.texto = "Modificou em ";
                break;
            case 'd':
                l.texto = "Deletou em ";
        }
        l.texto += tabela;
        
        log.add(l);
    }
    
    public void salvaLog(){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {
            FileWriter writer = new FileWriter("log.json");
            writer.write(gson.toJson(log));
            writer.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
