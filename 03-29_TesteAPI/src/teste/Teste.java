package teste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import javax.xml.bind.JAXBContext;


public class Teste {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://fipeapi.appspot.com/api/1/carros/marcas.json");
			//URL url = new URL("http://fipeapi.appspot.com/api/1/carros/veiculo/21/4828.json");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			if(con.getResponseCode() != 200) {
				throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
			}
			
		    Type listType = new TypeToken<ArrayList<Carro>>(){}.getType();
		    
		    List lista = new ArrayList<Carro>();
		    InputStreamReader json = new InputStreamReader(url.openStream());
		    lista = new Gson().fromJson(json, listType);
		    
		    System.out.println(lista);
			
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
