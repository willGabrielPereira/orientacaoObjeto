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
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import uteis.Datas;

/**
 *
 * @author willg
 */
public class Vendedor {

    private List<referenciaBanco.Vendedor> vendedores;
    private String tipo;

    public Vendedor(String tipo) {
        vendedores = new ArrayList<>();
        this.tipo = tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setVendedor(List<referenciaBanco.Vendedor> vendedores) {
        this.vendedores.addAll(vendedores);
    }

    public void setVendedor(referenciaBanco.Vendedor vendedores) {
        this.vendedores.add(vendedores);
    }

    public List<referenciaBanco.Vendedor> getVendedor() {
        return this.vendedores;
    }

    public void grava() {
        if (tipo.equals("xml")) {
            gravaXml();
        } else {
            gravaJson();
        }
    }

    public void obtem() {
        if (tipo.equals("xml")) {
            obtemXml();
        } else {
            obtemJson();
        }
        
        Collections.sort(vendedores, (Object vend1, Object vend2) -> {
            referenciaBanco.Vendedor ve1 = (referenciaBanco.Vendedor) vend1;
            referenciaBanco.Vendedor ve2 = (referenciaBanco.Vendedor) vend2;
            return ve1.getIdvendedor() < ve2.getIdvendedor() ? -1 : (ve1.getIdvendedor() > ve2.getIdvendedor() ? +1 : 0);
        });
    }

    protected void gravaJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {
            FileWriter writer = new FileWriter("vendedores.json");
            writer.write(gson.toJson(vendedores));
            writer.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    protected void obtemJson() {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("vendedores.json"));
            Type listType = new TypeToken<ArrayList<referenciaBanco.Vendedor>>() {
            }.getType();

            List lista = new ArrayList<referenciaBanco.Vendedor>();
            lista = new Gson().fromJson(bufferedReader, listType);
            vendedores.clear();
            vendedores.addAll(lista);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    protected void gravaXml() {
        Element config = new Element("Vendedor");
        Document documento = new Document(config);
        Element titulo = new Element("titulo");
        titulo.setText("Vendedores");
        Element data = new Element("data");
        data.setText(Datas.dataToString((new Date())));
        config.addContent(titulo);
        config.addContent(data);

        for (int x = 0; x < vendedores.size(); x++) {
            Element pro = new Element("vendedor");
            pro.setAttribute("idVendedor", String.valueOf(vendedores.get(x).getIdvendedor()));
            Element nome = new Element("nome");
            nome.setText(vendedores.get(x).getNome());
            Element usuario = new Element("usuario");
            usuario.setText(vendedores.get(x).getUsuario());
            Element senha = new Element("senha");
            senha.setText(vendedores.get(x).getSenha());

            pro.addContent(nome);
            pro.addContent(usuario);
            pro.addContent(senha);

            config.addContent(pro);
        }

        XMLOutputter xout = new XMLOutputter();
        try {
            BufferedWriter arquivo = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("vendedores.xml"), "UTF-8"));
            xout.output(documento, arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void obtemXml() {
        vendedores.clear();
        Element config = new Element("Vendedor");
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        try {
            doc = builder.build("vendedores.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        config = doc.getRootElement();
        List ls = config.getChildren("vendedor");

        for (Iterator iter = ls.iterator(); iter.hasNext();) {
            Element element = (Element) iter.next();
            referenciaBanco.Vendedor pes = new referenciaBanco.Vendedor();
            pes.setIdvendedor(Integer.parseInt(element.getAttributeValue("idVendedor")));
            pes.setNome(element.getChildText("nome"));
            pes.setUsuario(element.getChildText("usuario"));
            pes.setSenha(element.getChildText("senha"), false);

            vendedores.add(pes);

        }
    }
}
