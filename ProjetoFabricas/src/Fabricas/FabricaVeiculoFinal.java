/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabricas;

import DTOs.VeiculoFinal;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodriguh
 */
public class FabricaVeiculoFinal implements IFabrica {

    @Override
    public List<VeiculoFinal> criarLista(String url) {
        InputStream is = null;
        try {
            is = new URL(url).openStream();
        } catch (IOException ex) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        Type listType = new TypeToken<VeiculoFinal>() {
        }.getType();
        VeiculoFinal vf;
        List<VeiculoFinal> lista = new ArrayList<>();

        vf = new Gson().fromJson(bufferedReader, listType);
        lista.add(vf);
        return lista;
    }

}
