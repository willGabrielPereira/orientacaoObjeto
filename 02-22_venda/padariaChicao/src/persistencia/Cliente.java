/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Date;
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
public class Cliente {

    private List<referenciaBanco.Cliente> clientes;
    private String tipo;

    public Cliente(String tipo) {
        clientes = new ArrayList<>();
        this.tipo = tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public void setCliente(List<referenciaBanco.Cliente> clientes) {
        this.clientes.addAll(clientes);
    }

    public void setCliente(referenciaBanco.Cliente clientes) {
        this.clientes.add(clientes);
    }

    public List<referenciaBanco.Cliente> getCliente() {
        return this.clientes;
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
        
        Collections.sort(clientes, (Object vend1, Object vend2) -> {
            referenciaBanco.Cliente ve1 = (referenciaBanco.Cliente) vend1;
            referenciaBanco.Cliente ve2 = (referenciaBanco.Cliente) vend2;
            return ve1.getIdcliente()< ve2.getIdcliente()? -1 : (ve1.getIdcliente()> ve2.getIdcliente()? +1 : 0);
        });
    }

    protected void gravaJson() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {
            FileWriter writer = new FileWriter("clientes.json");
            writer.write(gson.toJson(clientes));
            writer.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    protected void obtemJson() {
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new FileReader("clientes.json"));
                Type listType = new TypeToken<ArrayList<referenciaBanco.Cliente>>() {
                }.getType();

                List lista = new ArrayList<referenciaBanco.Cliente>();
                lista = new Gson().fromJson(bufferedReader, listType);
                clientes.clear();
                clientes.addAll(lista);

            } catch (IOException e) {
                System.out.println(e);
            }
    }

    protected void gravaXml() {
        Element config = new Element("Cliente");
        Document documento = new Document(config);
        Element titulo = new Element("titulo");
        titulo.setText("Clientes");
        Element data = new Element("data");
        data.setText(Datas.dataToString((new Date())));
        config.addContent(titulo);
        config.addContent(data);

        for (int x = 0; x < clientes.size(); x++) {
            Element pessoa = new Element("cliente");
            pessoa.setAttribute("idCliente", String.valueOf(clientes.get(x).getIdcliente()));
            Element nome = new Element("nome");
            nome.setText(clientes.get(x).getNome());
            Element cpf = new Element("cpf");
            cpf.setText(clientes.get(x).getCpf());
            Element rg = new Element("rg");
            rg.setText(clientes.get(x).getRg());
            Element fone = new Element("fone");
            fone.setText(clientes.get(x).getFone());
            Element email = new Element("email");
            email.setText(clientes.get(x).getEmail());
            Element usuario = new Element("usuario");
            usuario.setText(clientes.get(x).getUsuario());
            Element senha = new Element("senha");
            senha.setText(clientes.get(x).getSenha());
            Element endereco = new Element("endereco");
            endereco.setText(clientes.get(x).getEndereco());
            Element numero = new Element("numero");
            numero.setText(clientes.get(x).getNumero() + "");
            Element bairro = new Element("bairro");
            bairro.setText(clientes.get(x).getBairro());
            Element cidade = new Element("cidade");
            cidade.setText(clientes.get(x).getCidade());
            Element estado = new Element("estado");
            estado.setText(clientes.get(x).getEstado());

            pessoa.addContent(nome);
            pessoa.addContent(cpf);
            pessoa.addContent(rg);
            pessoa.addContent(fone);
            pessoa.addContent(email);
            pessoa.addContent(usuario);
            pessoa.addContent(senha);
            pessoa.addContent(endereco);
            pessoa.addContent(numero);
            pessoa.addContent(bairro);
            pessoa.addContent(cidade);
            pessoa.addContent(estado);

            config.addContent(pessoa);
        }

        XMLOutputter xout = new XMLOutputter();
        try {
            BufferedWriter arquivo = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("clientes.xml"), "UTF-8"));
            xout.output(documento, arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void obtemXml() {
        clientes.clear();
        Element config = new Element("Cliente");
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        try {
            doc = builder.build("clientes.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        config = doc.getRootElement();
        List ls = config.getChildren("cliente");

        for (Iterator iter = ls.iterator(); iter.hasNext();) {
            Element element = (Element) iter.next();
            referenciaBanco.Cliente pes = new referenciaBanco.Cliente();
            pes.setIdcliente(Integer.parseInt(element.getAttributeValue("idCliente")));
            pes.setNome(element.getChildText("nome"));
            pes.setCpf(element.getChildText("cpf"));
            pes.setRg(element.getChildText("rg"));
            pes.setFone(element.getChildText("fone"));
            pes.setEmail(element.getChildText("email"));
            pes.setUsuario(element.getChildText("usuario"));
            pes.setSenha(element.getChildText("senha"), false);
            pes.setEndereco(element.getChildText("endereco"));
            pes.setNumero(Integer.parseInt(element.getChildText("numero")));
            pes.setBairro(element.getChildText("bairro"));
            pes.setCidade(element.getChildText("cidade"));
            pes.setEstado(element.getChildText("estado"));
            clientes.add(pes);

        }
    }
}
