/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGrafica;

import java.util.Date;
import javax.swing.JOptionPane;
import referenciaBanco.Email;
import uteis.Datas;

/**
 *
 * @author willg
 */
public class InterfaceVendedor extends javax.swing.JFrame {

    private String bd;
    private referenciaBanco.Vendedor vendedor;
    private persistencia.Venda vendas;
    private persistencia.Produto produtos;
    private referenciaBanco.Venda venda;
    private persistencia.Cliente clientes;
    private int id;

    ModelTable modelo = new ModelTable();

    /**
     * Creates new form InterfaceVendedor
     */
    public InterfaceVendedor() {
        initComponents();
    }

    public InterfaceVendedor(String bd, referenciaBanco.Vendedor vendedor) {
        this.bd = bd;
        this.vendedor = vendedor;
        initComponents();
        vendas = new persistencia.Venda(bd);
        produtos = new persistencia.Produto(bd);
        venda = new referenciaBanco.Venda();
        clientes = new persistencia.Cliente(bd);
        vendas.obtem();
        produtos.obtem();
        clientes.obtem();
        tbItem.setModel(modelo);

        id = vendas.getVenda().get(vendas.getVenda().size() - 1).getIdvenda() + 1;
        initCombobox();
    }

    public void initCombobox() {
        cbCliente.removeAllItems();
        for (referenciaBanco.Cliente c : clientes.getCliente()) {
            cbCliente.addItem(c.getUsuario());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        tfId = new javax.swing.JTextField();
        btAddVen = new javax.swing.JButton();
        cbCliente = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfDataVen = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        tfDataPag = new javax.swing.JFormattedTextField();
        btFinal = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        tbItem = new javax.swing.JTable();
        btAdd = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bem vindo "+vendedor.getNome());
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));

        tfId.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        tfId.setText("ID");
        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });
        tfId.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tfIdPropertyChange(evt);
            }
        });
        tfId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfIdKeyPressed(evt);
            }
        });

        btAddVen.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btAddVen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceGrafica/plus.png"))); // NOI18N
        btAddVen.setDisabledSelectedIcon(null);
        btAddVen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddVenActionPerformed(evt);
            }
        });

        cbCliente.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        cbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCliente.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Cliente");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("Data Vencimento");

        tfDataVen.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        tfDataVen.setEnabled(false);
        tfDataVen.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setText("Data Pagamento");

        tfDataPag.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        tfDataPag.setEnabled(false);
        tfDataPag.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        btFinal.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btFinal.setText("Finalizar");
        btFinal.setEnabled(false);
        btFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalActionPerformed(evt);
            }
        });

        tbItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scroll.setViewportView(tbItem);

        btAdd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceGrafica/plus.png"))); // NOI18N
        btAdd.setText("Produto");
        btAdd.setEnabled(false);
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btDelete.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceGrafica/delete.png"))); // NOI18N
        btDelete.setText("Produto");
        btDelete.setEnabled(false);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceGrafica/reload.png"))); // NOI18N
        jButton1.setText("Produto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAddVen, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDataPag)
                            .addComponent(tfDataVen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btFinal)))
                .addGap(0, 38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfId)
                    .addComponent(btAddVen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(tfDataVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfDataPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btFinal)
                        .addComponent(btDelete)
                        .addComponent(jButton1))
                    .addComponent(btAdd))
                .addGap(15, 15, 15))
        );

        jMenu1.setText("Produto");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMenuItem1.setText("Cadastrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Alterar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setText("Pesquisar");
        jMenu1.add(jMenuItem4);

        jMenuItem3.setText("Excluir");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Venda");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMenuItem6.setText("Pesquisar");
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Dados");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMenuItem7.setText("Sincronizar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddVenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddVenActionPerformed
        tfId.setEnabled(false);
        tfDataPag.setEnabled(true);
        tfDataVen.setEnabled(true);
        btAdd.setEnabled(true);
        btFinal.setEnabled(true);
        btDelete.setEnabled(true);
        cbCliente.setEnabled(true);
        tfId.setText(id + "");
        venda.setIdvenda(id);
    }//GEN-LAST:event_btAddVenActionPerformed

    private void btFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalActionPerformed
        
        venda.setDataPagamento(Datas.stringToDate(tfDataPag.getText(), "/"));
        venda.setDataVencimento(Datas.stringToDate(tfDataVen.getText(), "/"));
        
        referenciaBanco.Cliente cli = new referenciaBanco.Cliente();
        for(referenciaBanco.Cliente c : clientes.getCliente()){
            if(c.getUsuario().equals(cbCliente.getSelectedItem())){
                venda.setCliente_idcliente(c.getIdcliente());
                cli = c;
                break;
            }
        }
        
        boolean igual = false;
        for(referenciaBanco.Venda v : vendas.getVenda()){
            if(v.getIdvenda() == venda.getIdvenda()){
                v = venda;
                igual = true;
                break;
            }
        }
        venda.setData(new Date());
        if(igual){
            vendas.grava();
        }else{
            vendas.setVenda(venda);
            vendas.grava();
        }
        
        Email e = new Email("Compra", "Você acabou de adiquirir os produtos listados na venda de ID: "+id, cli.getEmail());
        e.enviaEmail();
        
        InterfaceVendedor in = new InterfaceVendedor(bd, vendedor);
        in.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btFinalActionPerformed

    private void tfIdPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tfIdPropertyChange

    }//GEN-LAST:event_tfIdPropertyChange

    private void tfIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIdKeyPressed

    }//GEN-LAST:event_tfIdKeyPressed

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        tfDataPag.setEnabled(true);
        tfDataVen.setEnabled(true);
        btAdd.setEnabled(true);
        btFinal.setEnabled(true);
        btDelete.setEnabled(true);
        btAddVen.setEnabled(false);
        cbCliente.setEnabled(true);
        modelo.removeAll();
        for (referenciaBanco.Venda v : vendas.getVenda()) {
            if (v.getIdvenda() == Integer.parseInt(tfId.getText())) {
                venda = v;
                break;
            }
        }
        for (referenciaBanco.ItemVenda i : venda.getItemVenda()) {
            modelo.addRow(i);
        }
        for (referenciaBanco.Cliente c : clientes.getCliente()) {
            if (venda.getCliente_idcliente() == c.getIdcliente()) {
                cbCliente.setSelectedItem(c.getUsuario());
                break;
            }
        }
        tfDataVen.setText(Datas.pegaDia(venda.getDataVencimento())+"/"
                +Datas.pegaMes(venda.getDataVencimento())+"/"
                +Datas.pegaAno(venda.getDataVencimento()));
        
        tfDataPag.setText(Datas.pegaDia(venda.getDataPagamento())+"/"
                +Datas.pegaMes(venda.getDataPagamento())+"/"
                +Datas.pegaAno(venda.getDataPagamento()));
        
    }//GEN-LAST:event_tfIdActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        String idProduto = JOptionPane.showInputDialog("Código do Produto");
        boolean existe = false;
        referenciaBanco.Produto pro = new referenciaBanco.Produto();
        for(referenciaBanco.Produto p : produtos.getProduto()){
            if(Integer.parseInt(idProduto) == p.getIdproduto()){
                pro = p;
                existe = true;
            }
        }
        
        if(existe){
            String quantidade = JOptionPane.showInputDialog("Quantidade");
            if(Integer.parseInt(quantidade)>pro.getEstoque()){
            JOptionPane.showMessageDialog(null,
                                "Não temos estoque suficiente", "Erro de validação",
                                JOptionPane.ERROR_MESSAGE);
            }else{
                referenciaBanco.ItemVenda i = new referenciaBanco.ItemVenda();
                i.setSuper(pro);
                i.setQuantidade(Integer.parseInt(quantidade));
                venda.addItemVenda(i);
                modelo.addRow(i);
            }
        }else{
            JOptionPane.showMessageDialog(null,
                                "Produto não encontrado", "Erro de validação",
                                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btAddActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        if(tbItem.getSelectedRow() != -1){
            int qnt = (int)modelo.getValueAt(tbItem.getSelectedRow(), 3);
            int del = (int)modelo.getValueAt(tbItem.getSelectedRow(), 0);
            for(referenciaBanco.Produto p : produtos.getProduto()){
                if(p.getIdproduto() == del){
                    p.setEstoque(p.getEstoque()+qnt);
                    break;
                }
            }
            produtos.grava();
            for(referenciaBanco.ItemVenda i : venda.getItemVenda()){
                if(i.getIdproduto() == del){
                    venda.getItemVenda().remove(i);
                    break;
                }
            }
            
            modelo.removeRow(tbItem.getSelectedRow());
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        EditProduto e = new EditProduto("add", bd);
        e.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        EditProduto e = new EditProduto("edit", bd);
        e.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if(bd.equals("xml")){
            persistencia.Vendedor vendedores = new persistencia.Vendedor(bd);
            vendedores.obtem();
            String bd2 = "json";
            vendedores.setTipo(bd2);
            clientes.setTipo(bd2);
            produtos.setTipo(bd2);
            vendas.setTipo(bd2);
            clientes.grava();
            produtos.grava();
            vendas.grava();
            vendedores.grava();
        }else{
            persistencia.Vendedor vendedores = new persistencia.Vendedor(bd);
            vendedores.obtem();
            String bd2 = "xml";
            vendedores.setTipo(bd2);
            clientes.setTipo(bd2);
            produtos.setTipo(bd2);
            vendas.setTipo(bd2);
            clientes.grava();
            produtos.grava();
            vendas.grava();
            vendedores.grava();
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        produtos = new persistencia.Produto(bd);
        produtos.obtem();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceVendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btAddVen;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btFinal;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tbItem;
    private javax.swing.JFormattedTextField tfDataPag;
    private javax.swing.JFormattedTextField tfDataVen;
    private javax.swing.JTextField tfId;
    // End of variables declaration//GEN-END:variables
}
