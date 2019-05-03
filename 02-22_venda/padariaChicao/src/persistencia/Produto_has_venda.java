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
public class Produto_has_venda {

    private class Prod_vend {

        private int idVenda;
        private int idProduto;
        private int qnt;

        public void setIdProduto(int idProduto) {
            this.idProduto = idProduto;
        }

        public void setIdVenda(int idVenda) {
            this.idVenda = idVenda;
        }

        public void setQnt(int qnt) {
            this.qnt = qnt;
        }

        public int getIdProduto() {
            return idProduto;
        }

        public int getIdVenda() {
            return idVenda;
        }

        public int getQnt() {
            return qnt;
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            s.append(" venda: " + idVenda);
            s.append(" prod: " + idProduto);
            s.append(" qnt: " + qnt + "\n");
            return s.toString();
        }
    }

    protected List<Prod_vend> prod_vend;
    private String tipo;

    public Produto_has_venda(String tipo) {
        prod_vend = new ArrayList<>();
        this.tipo = tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setProdVenda(List<referenciaBanco.Venda> venda) {
        for (referenciaBanco.Venda v : venda) {
            Prod_vend p = new Prod_vend();
            for (referenciaBanco.ItemVenda i : v.getItemVenda()) {
                p = new Prod_vend();
                p.setIdVenda(v.getIdvenda());
                p.setIdProduto(i.getIdproduto());
                p.setQnt(i.getQuantidade());

                prod_vend.add(p);
            }
        }
    }

    public void setProdVenda(referenciaBanco.Venda venda) {
        Prod_vend p = new Prod_vend();
        for (referenciaBanco.ItemVenda i : venda.getItemVenda()) {
            p = new Prod_vend();
            p.setIdVenda(venda.getIdvenda());
            p.setIdProduto(i.getIdproduto());
            p.setQnt(i.getQuantidade());

            prod_vend.add(p);

        }
    }

    public List<referenciaBanco.Venda> getItemVenda(List<referenciaBanco.Venda> vendas) {
        persistencia.Produto p = new persistencia.Produto(tipo);
        p.obtem();
        List<referenciaBanco.ItemVenda> itemVenda;

        referenciaBanco.ItemVenda item;

        for (Prod_vend pv : prod_vend) {
            itemVenda = new ArrayList<>();
            for (referenciaBanco.Produto prod : p.getProduto()) {
                if (pv.getIdProduto() == prod.getIdproduto()) {
                    item = new referenciaBanco.ItemVenda();
                    item.setSuper(prod);
                    item.setQuantidade(pv.getQnt());
                    itemVenda.add(item);
                }
            }
            for (referenciaBanco.Venda v : vendas) {
                if (v.getIdvenda() == pv.getIdVenda()) {
                    v.addItemVenda(itemVenda);
                }
            }
        }
        return vendas;
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
    }

    protected void gravaJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {
            FileWriter writer = new FileWriter("produto_has_venda.json");
            writer.write(gson.toJson(prod_vend));
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
            prod_vend.clear();
            prod_vend.addAll(lista);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    protected void gravaXml() {
        Element config = new Element("Produto_has_venda");
        Document documento = new Document(config);
        Element titulo = new Element("titulo");
        titulo.setText("produto_has_venda");
        Element data = new Element("data");
        data.setText(Datas.dataToString((new Date())));
        config.addContent(titulo);
        config.addContent(data);

        for (int x = 0; x < prod_vend.size(); x++) {
            Element pro = new Element("prod_has_vend");
            pro.setAttribute("idVenda", String.valueOf(prod_vend.get(x).getIdVenda()));
            pro.setAttribute("idProduto", String.valueOf(prod_vend.get(x).getIdProduto()));
            Element qnt = new Element("qnt");
            qnt.setText(prod_vend.get(x).getQnt() + "");

            pro.addContent(qnt);
            config.addContent(pro);
        }

        XMLOutputter xout = new XMLOutputter();
        try {
            BufferedWriter arquivo = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("produto_has_venda.xml"), "UTF-8"));
            xout.output(documento, arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void obtemXml() {
        prod_vend.clear();
        Element config = new Element("Produto_has_venda");
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        try {
            doc = builder.build("produto_has_venda.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        config = doc.getRootElement();
        List ls = config.getChildren("prod_has_vend");

        for (Iterator iter = ls.iterator(); iter.hasNext();) {
            Element element = (Element) iter.next();
            Prod_vend pes = new Prod_vend();
            pes.setIdVenda(Integer.parseInt(element.getAttributeValue("idVenda")));
            pes.setIdProduto(Integer.parseInt(element.getAttributeValue("idProduto")));
            pes.setQnt(Integer.parseInt(element.getChildText("qnt")));
            prod_vend.add(pes);

        }
    }
}
