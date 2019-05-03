/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.List;
import referenciaBanco.Venda;
import dao.VendaDAO;

/**
 *
 * @author willg
 */
public class VendaBO implements interfaces.IBO<Venda> {

    @Override
    public boolean inserir(Venda obj) {
        if (existe(obj) != true) {
            VendaDAO objDAO = new VendaDAO();
            return objDAO.inserir(obj);
        }
        return false;
    }

    @Override
    public boolean alterar(Venda obj) {
        VendaDAO objDAO = new VendaDAO();
        return objDAO.alterar(obj);
    }

    @Override
    public boolean excluir(Venda obj) {
        VendaDAO objDAO = new VendaDAO();
        return objDAO.excluir(obj);
    }

    @Override
    public Venda procurarPorCodigo(Venda obj) {
        VendaDAO objDAO = new VendaDAO();
        return objDAO.procurarPorCodigo(obj);
    }

    @Override
    public boolean existe(Venda obj) {
        VendaDAO objDAO = new VendaDAO();
        return objDAO.existe(obj);
    }

    @Override
    public List<Venda> pesquisarTodos() {
        VendaDAO objDAO = new VendaDAO();
        return objDAO.pesquisarTodos();
    }

}
