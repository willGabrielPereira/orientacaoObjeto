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
public class Venda {

    private List<referenciaBanco.Venda> vendas;
    private String tipo;

    public Venda(String tipo) {
        vendas = new ArrayList<>();
        this.tipo = tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVenda(List<referenciaBanco.Venda> vendas) {
        this.vendas.addAll(vendas);
    }

    public void setVenda(referenciaBanco.Venda vendas) {
        this.vendas.add(vendas);
    }

    public List<referenciaBanco.Venda> getVenda() {
        return this.vendas;
    }

    public void grava() {
        if (tipo.equals("xml")) {
            gravaXml();
        } else {
            gravaJson();
        }
        Produto_has_venda p = new Produto_has_venda(tipo);
        p.setProdVenda(vendas);
        p.grava();
    }

    public void obtem() {
        if (tipo.equals("xml")) {
            obtemXml();
        } else {
            obtemJson();
        }
        Collections.sort(vendas, (Object vend1, Object vend2) -> {
            referenciaBanco.Venda ve1 = (referenciaBanco.Venda) vend1;
            referenciaBanco.Venda ve2 = (referenciaBanco.Venda) vend2;
            return ve1.getIdvenda() < ve2.getIdvenda() ? -1 : (ve1.getIdvenda() > ve2.getIdvenda() ? +1 : 0);
        });
    }

    protected void gravaJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {
            FileWriter writer = new FileWriter("vendas.json");
            writer.write(gson.toJson(vendas));
            writer.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    protected void obtemJson() {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("vendas.json"));
            Type listType = new TypeToken<ArrayList<referenciaBanco.Venda>>() {
            }.getType();

            List lista = new ArrayList<referenciaBanco.Venda>();
            lista = new Gson().fromJson(bufferedReader, listType);
            vendas.clear();
            vendas.addAll(lista);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    protected void gravaXml() {
        Element config = new Element("Venda");
        Document documento = new Document(config);
        Element titulo = new Element("titulo");
        titulo.setText("Vendas");
        Element data = new Element("data");
        data.setText(Datas.dataToString((new Date())));
        config.addContent(titulo);
        config.addContent(data);

        for (int x = 0; x < vendas.size(); x++) {
            Element pro = new Element("venda");
            pro.setAttribute("idVenda", String.valueOf(vendas.get(x).getIdvenda()));
            Element dataM = new Element("data");
            dataM.setText(Datas.pegaDia(vendas.get(x).getData()) + "/"
                    + "" + Datas.pegaMes(vendas.get(x).getData()) + "/"
                    + "" + Datas.pegaAno(vendas.get(x).getData()));
            Element idCliente = new Element("cliente");
            idCliente.setAttribute("idcliente", vendas.get(x).getCliente_idcliente() + "");
            Element idVendedor = new Element("vendedor");
            idVendedor.setAttribute("idvendedor", vendas.get(x).getVendedor_idvendedor() + "");
            Element dataV = new Element("dataVencimento");
            dataV.setText(Datas.pegaDia(vendas.get(x).getDataVencimento()) + "/"
                    + "" + Datas.pegaMes(vendas.get(x).getDataVencimento()) + "/"
                    + "" + Datas.pegaAno(vendas.get(x).getDataVencimento()));
            Element dataP = new Element("dataPagamento");
            dataP.setText(Datas.pegaDia(vendas.get(x).getDataPagamento()) + "/"
                    + "" + Datas.pegaMes(vendas.get(x).getDataPagamento()) + "/"
                    + "" + Datas.pegaAno(vendas.get(x).getDataPagamento()));

            pro.addContent(dataM);
            pro.addContent(idCliente);
            pro.addContent(idVendedor);
            pro.addContent(dataV);
            pro.addContent(dataP);

            config.addContent(pro);
        }

        XMLOutputter xout = new XMLOutputter();
        try {
            BufferedWriter arquivo = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("vendas.xml"), "UTF-8"));
            xout.output(documento, arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void obtemXml() {
        vendas.clear();
        Element config = new Element("Venda");
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        try {
            doc = builder.build("vendas.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        config = doc.getRootElement();
        List ls = config.getChildren("venda");

        for (Iterator iter = ls.iterator(); iter.hasNext();) {
            Element element = (Element) iter.next();
            referenciaBanco.Venda pes = new referenciaBanco.Venda();
            pes.setIdvenda(Integer.parseInt(element.getAttributeValue("idVenda")));
            pes.setData(Datas.stringToDate(element.getChildText("data"), "/"));
            pes.setCliente_idcliente(Integer.parseInt(element.getChild("cliente").getAttributeValue("idcliente")));
            pes.setVendedor_idvendedor(Integer.parseInt(element.getChild("vendedor").getAttributeValue("idvendedor")));
            pes.setDataVencimento(Datas.stringToDate(element.getChildText("dataVencimento"), "/"));
            pes.setDataPagamento(Datas.stringToDate(element.getChildText("dataPagamento"), "/"));

            vendas.add(pes);

        }

        Produto_has_venda prod = new Produto_has_venda(tipo);
        prod.obtem();

        vendas = prod.getItemVenda(vendas);
    }
}
