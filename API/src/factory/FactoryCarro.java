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

import dto.Carro;

public class FactoryCarro implements Factory<Carro> {

    @Override
    public List<Carro> carrega(String idMarca, String idVeiculo, String idModelo) {
        try {
            URL url = new URL("http://fipeapi.appspot.com/api/1/carros/veiculo/" + idMarca + "/" + idVeiculo + "/" + idModelo + ".json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : " + con.getResponseCode());
            }

            Type listType = new TypeToken<Carro>() {
            }.getType();

            List<Carro> carro = new ArrayList<>();
            InputStreamReader json = new InputStreamReader(url.openStream());
            carro.add(new Gson().fromJson(json, listType));
            return carro;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public List<Carro> limpa() {
        return null;
    }

    @Override
    public boolean salva(List<Carro> lista, File arquivo) {
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
