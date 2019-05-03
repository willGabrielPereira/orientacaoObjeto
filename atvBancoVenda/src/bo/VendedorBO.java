/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.List;
import referenciaBanco.Vendedor;
import dao.VendedorDAO;

/**
 *
 * @author willg
 */
public class VendedorBO implements interfaces.IBO<Vendedor>{

    @Override
    public boolean inserir(Vendedor obj) {
        if (existe(obj) != true) {
            VendedorDAO objDAO = new VendedorDAO();
            return objDAO.inserir(obj);
        }
        return false;
    }

    @Override
    public boolean alterar(Vendedor obj) {
        VendedorDAO objDAO = new VendedorDAO();
        return objDAO.alterar(obj);
    }

    @Override
    public boolean excluir(Vendedor obj) {
        VendedorDAO objDAO = new VendedorDAO();
        return objDAO.excluir(obj);
    }

    @Override
    public Vendedor procurarPorCodigo(Vendedor obj) {
        VendedorDAO objDAO = new VendedorDAO();
        return objDAO.procurarPorCodigo(obj);
    }

    @Override
    public boolean existe(Vendedor obj) {
        VendedorDAO objDAO = new VendedorDAO();
        return objDAO.existe(obj);
    }

    @Override
    public List<Vendedor> pesquisarTodos() {
        VendedorDAO objDAO = new VendedorDAO();
        return objDAO.pesquisarTodos();
    }
    
}
