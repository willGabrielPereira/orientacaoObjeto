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

import static com.google.gson.internal.bind.TypeAdapters.URL;

public class
API {
    private Factory f;

    private List<Marca> marcas;
    private List<Veiculo> veiculos;
    private List<Modelo> modelos;

    private String idMarca;
    private String idVeiculo;
    private String idModelo;
    
    /**
     * API de conex�o e comunica��o com WebService da tabela Fipe
     * 
     * Para diminuir erros, busque Marca, Ve�culo, Modelo e Carro respectivamente
     * 
     * Cada fun��o carregar ou limpa retorna valores,
     * por�m n�o � necess�rio receb�-las pois fica salvo na pr�pria API
     * 
     * Para pular at� o carro(ve�culo final) basta setar as IDs que deseja
     */
    public API() {}

    /**
     * Testa a conex�o com o webservice
     * @return null caso n�o houver conex�o, true caso houver
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
     * @return List Marca  (n�o � necess�rio receb�-la)
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
     * @return List Marca (n�o � necess�rio receb�-la)
     */
    public List<Marca> limpaMarcas() {
        f = new FactoryMarca();
        marcas = f.limpa();
        return marcas;
    }

    /**
     * Adquire os ve�culos da webService
     * @param marca necess�rio para saber qual marca � dona dos ve�culos em quest�o
     * @return List Veiculo  (n�o � necess�rio receb�-la)
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
     * Limpa a lista de ve�culos
     * @return List Veiculo  (n�o � necess�rio receb�-la)
     */
    public List<Veiculo> limparVeiculos() {
        f = new FactoryVeiculo();
        veiculos = f.limpa();
        return veiculos;
    }

    /**
     * Adquire os modelos da webService
     * @param veiculo necess�rio para saber de qual ve�culo os modelos s�o baseados
     * @return List Modelo  (n�o � necess�rio receb�-la)
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
     * @return List Modelo  (n�o � necess�rio receb�-la)
     */
    public List<Modelo> limpaModelos() {
        f = new FactoryModelo();
        modelos = f.limpa();
        return modelos;
    }

    /**
     * Adquire o carro da webService
     * @param modelo necess�rio para saber sobre qual modelo o Carro foi produzido
     * @return Carro (� necess�rio receb�-lo)
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
     * gera um Json dos ve�culos salvos na API
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
     * @param carro Objeto tipo Carro que dever� ser salvo
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
