/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author willg
 */
public interface IDAO<classe> {
    public boolean inserir(classe obj);
    public boolean alterar(classe obj);
    public boolean excluir(classe obj);
    public classe procurarPorCodigo(classe obj);
    public boolean existe(classe obj);
    public List<classe> pesquisarTodos();
    public List<classe> montarLista(ResultSet rs);
    
}