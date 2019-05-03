/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.List;
import referenciaBanco.Produto;
import dao.ProdutoDAO;

/**
 *
 * @author willg
 */
public class ProdutoBO implements interfaces.IBO<Produto>{

    @Override
    public boolean inserir(Produto obj) {
        if (existe(obj) != true) {
            ProdutoDAO objDAO = new ProdutoDAO();
            return objDAO.inserir(obj);
        }
        return false;
    }

    @Override
    public boolean alterar(Produto obj) {
        ProdutoDAO objDAO = new ProdutoDAO();
        return objDAO.alterar(obj);
    }

    @Override
    public boolean excluir(Produto obj) {
        ProdutoDAO objDAO = new ProdutoDAO();
        return objDAO.excluir(obj);
    }

    @Override
    public Produto procurarPorCodigo(Produto obj) {
        ProdutoDAO objDAO = new ProdutoDAO();
        return objDAO.procurarPorCodigo(obj);
    }

    @Override
    public boolean existe(Produto obj) {
        ProdutoDAO objDAO = new ProdutoDAO();
        return objDAO.existe(obj);
    }

    @Override
    public List<Produto> pesquisarTodos() {
        ProdutoDAO objDAO = new ProdutoDAO();
        return objDAO.pesquisarTodos();
    }

    
    
}
