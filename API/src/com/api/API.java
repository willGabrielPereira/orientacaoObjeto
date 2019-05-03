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
    
    /**
     * API de conexão e comunicação com WebService da tabela Fipe
     * 
     * Para diminuir erros, busque Marca, Veículo, Modelo e Carro respectivamente
     * 
     * Cada função carregar ou limpa retorna valores,
     * porém não é necessário recebê-las pois fica salvo na própria API
     * 
     * Para pular até o carro(veículo final) basta setar as IDs que deseja
     */
    public API() {}

    /**
     * Testa a conexão com o webservice
     * @return null caso não houver conexão, true caso houver
     */
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

    /**
     * Adquire as marcas da webService
     * @return List Marca  (não é necessário recebê-la)
     */
    public List<Marca> carregaMarcas() {
        if (testeConexao()) {
            f = new FactoryMarca();
            marcas = f.carrega(null, null, null);
            return marcas;
        } else {
            return null;
        }
    }

    /**
     * Limpa a lista de marcas
     * @return List Marca (não é necessário recebê-la)
     */
    public List<Marca> limpaMarcas() {
        f = new FactoryMarca();
        marcas = f.limpa();
        return marcas;
    }

    /**
     * Adquire os veículos da webService
     * @param marca necessário para saber qual marca é dona dos veículos em questão
     * @return List Veiculo  (não é necessário recebê-la)
     */
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

    /**
     * Limpa a lista de veículos
     * @return List Veiculo  (não é necessário recebê-la)
     */
    public List<Veiculo> limparVeiculos() {
        f = new FactoryVeiculo();
        veiculos = f.limpa();
        return veiculos;
    }

    /**
     * Adquire os modelos da webService
     * @param veiculo necessário para saber de qual veículo os modelos são baseados
     * @return List Modelo  (não é necessário recebê-la)
     */
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

    /**
     * Limpa a lista de modelos
     * @return List Modelo  (não é necessário recebê-la)
     */
    public List<Modelo> limpaModelos() {
        f = new FactoryModelo();
        modelos = f.limpa();
        return modelos;
    }

    /**
     * Adquire o carro da webService
     * @param modelo necessário para saber sobre qual modelo o Carro foi produzido
     * @return Carro (é necessário recebê-lo)
     */
    public Carro carregaCarro(Modelo modelo) {
        if (testeConexao() && modelo != null) {
            f = new FactoryCarro();
            idModelo = modelo.getId();
            return (Carro) f.carrega(idMarca, idVeiculo, idModelo).get(0);
        } else {
            return null;
        }
    }

    /**
     * gera um Json das marcas salvas na API
     * @param localArquivo File que contenha o local e nome do arquivo para salvar
     * @return false caso tenha falhado, true caso seja completado
     */
    public boolean salvaMarca(File localArquivo) {
        f = new FactoryMarca();
        return f.salva(marcas, localArquivo);
    }

    /**
     * gera um Json dos veículos salvos na API
     * @param localArquivo File que contenha o local e nome do arquivo para salvar
     * @return false caso tenha falhado, true caso seja completado
     */
    public boolean salvaVeiculo(File localArquivo) {
        f = new FactoryVeiculo();
        return f.salva(veiculos, localArquivo);
    }

    /**
     * gera um Json dos modelos salvos na API
     * @param localArquivo File que contenha o local e nome do arquivo para salvar
     * @return false caso tenha falhado, true caso seja completado
     */
    public boolean salvaModelo(File localArquivo) {
        f = new FactoryModelo();
        return f.salva(modelos, localArquivo);
    }
    
    /**
     * gera um Json do carro
     * @param carro Objeto tipo Carro que deverá ser salvo
     * @param localArquivo File que contenha o local e nome do arquivo para salvar
     * @return false caso tenha falhado, true caso seja completado
     */
    public boolean salvaCarro(Carro carro, File localArquivo){
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
