/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.List;
import referenciaBanco.Cliente;
import dao.ClienteDAO;

/**
 *
 * @author willg
 */
public class ClienteBO implements interfaces.IBO<Cliente> {

    @Override
    public boolean inserir(Cliente obj) {
        if (existe(obj) != true) {
            ClienteDAO clienteDAO = new ClienteDAO();
            return clienteDAO.inserir(obj);
        }
        return false;
    }

    @Override
    public boolean alterar(Cliente obj) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.alterar(obj);
    }

    @Override
    public boolean excluir(Cliente obj) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.excluir(obj);
    }

    @Override
    public Cliente procurarPorCodigo(Cliente obj) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.procurarPorCodigo(obj);
    }

    @Override
    public boolean existe(Cliente obj) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.existe(obj);
    }

    @Override
    public List<Cliente> pesquisarTodos() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.pesquisarTodos();
    }

}
