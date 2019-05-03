/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dao.ItemVendaDAO;
import java.util.List;
import referenciaBanco.Venda;

/**
 *
 * @author willg
 */
public class ItemVendaBO implements interfaces.IBO<Venda>{

    @Override
    public boolean inserir(Venda obj) {
        if (existe(obj) != true) {
            ItemVendaDAO objDAO = new ItemVendaDAO();
            return objDAO.inserir(obj);
        }
        return false;
    }

    @Override
    public boolean alterar(Venda obj) {
        ItemVendaDAO objDAO = new ItemVendaDAO();
        return objDAO.alterar(obj);
    }

    @Override
    public boolean excluir(Venda obj) {
        ItemVendaDAO objDAO = new ItemVendaDAO();
        return objDAO.excluir(obj);
    }

    @Override
    public Venda procurarPorCodigo(Venda obj) {
        ItemVendaDAO objDAO = new ItemVendaDAO();
        return objDAO.procurarPorCodigo(obj);
    }

    @Override
    public boolean existe(Venda obj) {
        ItemVendaDAO objDAO = new ItemVendaDAO();
        return objDAO.existe(obj);
    }

    @Override
    public List<Venda> pesquisarTodos() {
        ItemVendaDAO objDAO = new ItemVendaDAO();
        return objDAO.pesquisarTodos();
    }

    
}
