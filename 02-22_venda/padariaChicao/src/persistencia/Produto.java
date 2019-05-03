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
public class Produto {

    private List<referenciaBanco.Produto> produtos;
    private String tipo;

    public Produto(String tipo) {
        produtos = new ArrayList<>();
        this.tipo = tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setProduto(List<referenciaBanco.Produto> produtos) {
        this.produtos.addAll(produtos);
    }

    public void setProduto(referenciaBanco.Produto produtos) {
        this.produtos.add(produtos);
    }

    public List<referenciaBanco.Produto> getProduto() {
        return this.produtos;
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
        Collections.sort(produtos, (Object vend1, Object vend2) -> {
            referenciaBanco.Produto ve1 = (referenciaBanco.Produto) vend1;
            referenciaBanco.Produto ve2 = (referenciaBanco.Produto) vend2;
            return ve1.getIdproduto() < ve2.getIdproduto() ? -1 : (ve1.getIdproduto() > ve2.getIdproduto() ? +1 : 0);
        });
    }

    protected void gravaJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {
            FileWriter writer = new FileWriter("produtos.json");
            writer.write(gson.toJson(produtos));
            writer.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    protected void obtemJson() {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("produtos.json"));
            Type listType = new TypeToken<ArrayList<referenciaBanco.Produto>>() {
            }.getType();

            List lista = new ArrayList<referenciaBanco.Produto>();
            lista = new Gson().fromJson(bufferedReader, listType);
            produtos.clear();
            produtos.addAll(lista);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    protected void gravaXml() {
        Element config = new Element("Produto");
        Document documento = new Document(config);
        Element titulo = new Element("titulo");
        titulo.setText("Produtos");
        Element data = new Element("data");
        data.setText(Datas.dataToString((new Date())));
        config.addContent(titulo);
        config.addContent(data);

        for (int x = 0; x < produtos.size(); x++) {
            Element pro = new Element("produto");
            pro.setAttribute("idProduto", String.valueOf(produtos.get(x).getIdproduto()));
            Element descricao = new Element("descricao");
            descricao.setText(produtos.get(x).getDescricao());
            Element valor = new Element("valor");
            valor.setText(produtos.get(x).getValor() + "");
            Element estoque = new Element("estoque");
            estoque.setText(produtos.get(x).getEstoque() + "");
            Element imagem = new Element("imagem");
            imagem.setText(produtos.get(x).getImagem());

            pro.addContent(descricao);
            pro.addContent(valor);
            pro.addContent(estoque);
            pro.addContent(imagem);

            config.addContent(pro);
        }

        XMLOutputter xout = new XMLOutputter();
        try {
            BufferedWriter arquivo = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("produtos.xml"), "UTF-8"));
            xout.output(documento, arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void obtemXml() {
        produtos.clear();
        Element config = new Element("Produto");
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        try {
            doc = builder.build("produtos.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        config = doc.getRootElement();
        List ls = config.getChildren("produto");

        for (Iterator iter = ls.iterator(); iter.hasNext();) {
            Element element = (Element) iter.next();
            referenciaBanco.Produto pes = new referenciaBanco.Produto();
            pes.setIdproduto(Integer.parseInt(element.getAttributeValue("idProduto")));
            pes.setDescricao(element.getChildText("descricao"));
            pes.setImagem(element.getChildText("imagem"));
            pes.setEstoque(Integer.parseInt(element.getChildText("estoque")));
            pes.setValor(Float.parseFloat(element.getChildText("valor")));

            produtos.add(pes);

        }
    }
}
