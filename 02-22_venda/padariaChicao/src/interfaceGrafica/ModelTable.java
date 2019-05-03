/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGrafica;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author willg
 */
public class ModelTable extends AbstractTableModel {

    private class Obj {

        public int id;
        public String desc;
        public float valor;
        public int quant;
        public JButton alterar;
        public JButton remover;

        public Obj(int id, String desc, float valor, int quant) {
            this.id = id;
            this.desc = desc;
            this.valor = valor;
            this.quant = quant;
        }

    }

    private List<Obj> dados = new ArrayList<>();
    private String[] colunas = {"id", "descrição", "valor", "quantidade"};

    @Override
    public String getColumnName(int i) {
        return colunas[i];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).id;
            case 1:
                return dados.get(linha).desc;
            case 2:
                return dados.get(linha).valor;
            case 3:
                return dados.get(linha).quant;
        }
        return null;
    }

    public void addRow(referenciaBanco.ItemVenda itemVenda) {
        Obj obj = new Obj(itemVenda.getIdproduto(), itemVenda.getDescricao(), 
                itemVenda.getValor(), itemVenda.getQuantidade());
        
        this.dados.add(obj);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    public void removeAll(){
        this.dados.clear();
        this.fireTableRowsDeleted(0, getRowCount());
    }
}
