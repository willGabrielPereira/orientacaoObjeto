/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package referenciaBanco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author willg
 */
public class Venda {
    private int idvenda;
    private Date data;
    private int cliente_idcliente;
    private int vendedor_idvendedor;
    private Date dataVencimento;
    private Date dataPagamento;
    protected List<ItemVenda> itemVenda;

    public Venda() {
        itemVenda = new ArrayList<>();
    }
    public Venda(int idvenda, Date data, int cliente_idcliente,
            int vendedor_idvendedor, Date dataVencimento, Date dataPagamento) {
        this.idvenda = idvenda;
        this.data = data;
        this.cliente_idcliente = cliente_idcliente;
        this.vendedor_idvendedor = vendedor_idvendedor;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.itemVenda = new ArrayList<>();
    }

    public int getCliente_idcliente() {
        return cliente_idcliente;
    }
    public Date getData() {
        return data;
    }
    public Date getDataPagamento() {
        return dataPagamento;
    }
    public Date getDataVencimento() {
        return dataVencimento;
    }
    public int getIdvenda() {
        return idvenda;
    }
    public int getVendedor_idvendedor() {
        return vendedor_idvendedor;
    }
    public List<ItemVenda> getItemVenda(){
        return itemVenda;
    }

    public void setCliente_idcliente(int cliente_idcliente) {
        this.cliente_idcliente = cliente_idcliente;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }
    public void setVendedor_idvendedor(int vendedor_idvendedor) {
        this.vendedor_idvendedor = vendedor_idvendedor;
    }
    
    public void addItemVenda(ItemVenda... itemVenda){
        for(ItemVenda p : itemVenda){
            this.itemVenda.add(p);
        }
    }

    public void addItemVenda(List<ItemVenda> itemVenda) {
        this.itemVenda.addAll(itemVenda);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(" id: "+idvenda);
        s.append(" data: "+data);
        s.append(" dataPag: "+dataPagamento);
        s.append(" dataVenc: "+dataVencimento);
        s.append(" idCliente: "+cliente_idcliente);
        s.append(" idVendedor: "+vendedor_idvendedor);
        s.append(" itemVenda: "+itemVenda+"\n");
        return s.toString();
    }
    
    
}
