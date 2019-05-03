package com.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import dto.*;
import factory.Factory;
import factory.FactoryCarro;
import factory.FactoryMarca;
import factory.FactoryModelo;
import factory.FactoryVeiculo;
import java.io.File;
import java.util.ArrayList;

public class API {
    private Factory f;

    private List<Marca> marcas;
    private List<Veiculo> veiculos;
    private List<Modelo> modelos;

    private String idMarca;
    private String idVeiculo;
    private String idModelo;

    public boolean testeConexao() {
        try {
            URL url = new URL("http://fipeapi.appspot.com/api/1/carros/marcas.json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.connect();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public List<Marca> carregaMarcas() {
        if (testeConexao()) {
            f = new FactoryMarca();
            marcas = f.carrega(null, null, null);
            return marcas;
        } else {
            return null;
        }
    }

    public List<Marca> limpaMarcas() {
        f = new FactoryMarca();
        marcas = f.limpa();
        return marcas;
    }

    public List<Veiculo> carregaVeiculos(Marca marca) {
        if (testeConexao() && marca != null) {
            f = new FactoryVeiculo();
            idMarca = marca.getId() + "";
            veiculos = f.carrega(idMarca, null, null);
            return veiculos;
        } else {
            return null;
        }
    }

    public List<Veiculo> limparVeiculos() {
        f = new FactoryVeiculo();
        veiculos = f.limpa();
        return veiculos;
    }

    public List<Modelo> carregaModelos(Veiculo veiculo) {
        if (testeConexao() && veiculo != null) {
            f = new FactoryModelo();
            idVeiculo = veiculo.getId();
            modelos = f.carrega(idMarca, idVeiculo, null);
            return modelos;
        } else {
            return null;
        }
    }

    public List<Modelo> limpaModelos() {
        f = new FactoryModelo();
        modelos = f.limpa();
        return modelos;
    }

    public Carro carregaCarro(Modelo modelo) {
        if (testeConexao() && modelo != null) {
            f = new FactoryCarro();
            idModelo = modelo.getId();
            return (Carro) f.carrega(idMarca, idVeiculo, idModelo).get(0);
        } else {
            return null;
        }
    }

    public boolean salvaMarca() {
        f = new FactoryMarca();
        return f.salva(marcas, new File("marcas.json"));
    }

    public boolean salvaVeiculo() {
        f = new FactoryVeiculo();
        return f.salva(veiculos, new File("veiculos.json"));
    }

    public boolean salvaModelo() {
        f = new FactoryModelo();
        return f.salva(modelos, new File("modelos.json"));
    }
    public boolean salvaCarro(Carro carro){
        f = new FactoryCarro();
        List<Carro> c = new ArrayList<>();
        c.add(carro);
        return f.salva(c, new File("carro.json"));
    }
    
    
    
    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public String getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(String idMarca) {
        this.idMarca = idMarca;
    }

    public String getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(String idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(String idModelo) {
        this.idModelo = idModelo;
    }
}
