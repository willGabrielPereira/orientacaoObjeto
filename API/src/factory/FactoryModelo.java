package factory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.api.API;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import dto.Modelo;

public class FactoryModelo implements Factory<Modelo> {

    @Override
    public List<Modelo> carrega(String idMarca, String idVeiculo, String idModelo) {
        try {
            URL url = new URL("http://fipeapi.appspot.com/api/1/carros/veiculo/" + idMarca + "/" + idVeiculo + ".json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : " + con.getResponseCode());
            }

            Type listType = new TypeToken<ArrayList<Modelo>>() {
            }.getType();

            List<Modelo> lista = new ArrayList<Modelo>();
            InputStreamReader json = new InputStreamReader(url.openStream());
            lista = new Gson().fromJson(json, listType);
            return lista;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public List<Modelo> limpa() {
        return null;
    }

    @Override
    public boolean salva(List<Modelo> lista, File arquivo) {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            FileWriter writer;
            writer = new FileWriter(arquivo);
            writer.write(gson.toJson(lista));
            writer.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(API.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
