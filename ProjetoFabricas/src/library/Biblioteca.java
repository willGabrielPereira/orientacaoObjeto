package library;

import Fabricas.FabricaMarca;
import Fabricas.FabricaAnoModelo;
import Fabricas.FabricaVeiculo;
import Fabricas.FabricaVeiculoFinal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rodriguh
 */
public class Biblioteca {

    public List<?> fabricaLista(String tipo, String url) {
        if ("MARCA".equalsIgnoreCase(tipo)) {
            FabricaMarca laFabrica = new FabricaMarca();
            return laFabrica.criarLista(url);
        } else if ("VEICULO".equalsIgnoreCase(tipo)) {
            FabricaVeiculo laFabrica = new FabricaVeiculo();
            return laFabrica.criarLista(url);
        } else if ("ANOMODELO".equalsIgnoreCase(tipo)) {
            FabricaAnoModelo laFabrica = new FabricaAnoModelo();
            return laFabrica.criarLista(url);
        } else if ("VEICULOFINAL".equalsIgnoreCase(tipo)) {
            FabricaVeiculoFinal laFabrica = new FabricaVeiculoFinal();
            return laFabrica.criarLista(url);
        }
        return null;
    }

    public <T> void exportaLista(List<T> lista, String tipoLista) {

        GsonBuilder gBuilder = new GsonBuilder();
        Gson gson = gBuilder.create();
        FileWriter writer;
        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File(tipoLista + ".json")); // added this line
        fc.setCurrentDirectory(new File("src/JSONFiles"));
        int returnVal = fc.showSaveDialog(null);
        File file = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
        }
        try {
            writer = new FileWriter(file.getAbsolutePath());
            writer.write(gson.toJson(lista));
            writer.close();
        } catch (IOException e1) {
            System.err.println(e1.getMessage());
        }

    }

    public <T> List<T> limpaLista(List<T> lista) {
        lista = null;
        return lista;
    }

    public boolean verificaConexao(String strURL) {

        try {
            URL url = new URL(strURL);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.connect();

            if (HttpURLConnection.HTTP_OK == urlConn.getResponseCode()) {
                System.out.println("");
                return true;
            }

        } catch (IOException e) {
            return false;
        }
        return false;
    }
}
