/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGrafica;

import com.api.API;
import dto.Carro;
import dto.Marca;
import dto.Modelo;
import dto.Veiculo;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author willg
 */
public class interfaceGrafica extends javax.swing.JFrame {
    
    private API api;
    private List<Marca> marcas;
    private List<Veiculo> veiculos;
    private List<Modelo> modelos;
    private int letra = 18;

    /**
     * Creates new form interfaceGrafica
     */
    public interfaceGrafica() {
        api = new API();
        if (api.testeConexao()) {
            //System.out.println("abriu");
            initComponents();
            initComboMarca();
            limpaComboVeiculo();
            limpaComboModelo();
        } else {
            JOptionPane.showMessageDialog(null,
                                "Sem conexão! Saindo....", "Erro",
                                JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public void limpaComboModelo() {
        comboModelo.removeAllItems();
        comboModelo.setEnabled(false);
    }
    
    public void limpaComboVeiculo() {
        comboVeiculo.removeAllItems();
        comboVeiculo.setEnabled(false);
    }
    
    public void limpaCarro() {
        carro.setText(null);
    }
    
    public Marca achaMarca(String marca) {
        //marcas = api.carregaMarcas();
        for (Marca m : marcas) {
            if (m.getFipe_name().equals(marca)) {
                return m;
            }
        }
        return null;
    }
    
    public Veiculo achaVeiculo(String veiculo) {
        //veiculos = api.carregaVeiculos(achaMarca((String) comboMarca.getSelectedItem()));
        for (Veiculo v : veiculos) {
            if (v.getFipe_name().equals(veiculo)) {
                return v;
            }
        }
        return null;
    }
    
    public Modelo achaModelo(String modelo) {
        //modelos = api.carregaModelos(achaVeiculo((String) comboMarca.getSelectedItem()));
        for (Modelo m : modelos) {
            if (m.getName().equals(modelo)) {
                return m;
            }
        }
        return null;
    }
    
    public void initComboMarca() {
        comboMarca.removeAllItems();
        //System.out.println(api.testeConexao());
        marcas = api.carregaMarcas();
        for (Marca m : marcas) {
            comboMarca.addItem(m.getFipe_name());
        }
    }
    
    public void initComboVeiculo() {
        limpaComboVeiculo();
        veiculos = api.carregaVeiculos(achaMarca((String) comboMarca.getSelectedItem()));
        for (Veiculo v : veiculos) {
            comboVeiculo.addItem(v.getFipe_name());
        }
        comboVeiculo.setEnabled(true);
    }
    
    public void initComboModelo() {
        limpaComboModelo();
        modelos = api.carregaModelos(achaVeiculo((String) comboVeiculo.getSelectedItem()));
        for (Modelo m : modelos) {
            comboModelo.addItem(m.getName());
        }
        comboModelo.setEnabled(true);
    }
    
    public void initCarro() {
        limpaCarro();
        Carro carro = api.carregaCarro(achaModelo((String) comboModelo.getSelectedItem()));
        
        StringBuilder builder = new StringBuilder();
        builder.append("id: ");
        builder.append(carro.getId());
        builder.append("\nano_modelo: ");
        builder.append(carro.getAno_modelo());
        builder.append("\nmarca: ");
        builder.append(carro.getMarca());
        builder.append("\nname: ");
        builder.append(carro.getName());
        builder.append("\nveiculo: ");
        builder.append(carro.getVeiculo());
        builder.append("\npreco: ");
        builder.append(carro.getPreco());
        builder.append("\ncombustivel: ");
        builder.append(carro.getCombustivel());
        builder.append("\nreferencia: ");
        builder.append(carro.getReferencia());
        builder.append("\nfipe_codigo: ");
        builder.append(carro.getFipe_codigo());
        builder.append("\nkey: ");
        builder.append(carro.getKey());
        
        this.carro.setText(builder.toString());
    }
    
    public void salvarTexto() {
        try {
            FileWriter arq = new FileWriter("carro.txt");            
            PrintWriter gravarArq = new PrintWriter(arq);
            String texto = carro.getText();
            for (String t : texto.split("\n")) {
                gravarArq.println(t);
            }
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(interfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboMarca = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboVeiculo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboModelo = new javax.swing.JComboBox<>();
        salvarMarca = new javax.swing.JButton();
        salvarVeiculo = new javax.swing.JButton();
        SalvarModelo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        carro = new javax.swing.JTextArea();
        carregaMarca = new javax.swing.JButton();
        carregaVeiculo = new javax.swing.JButton();
        carregaModelo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FIPE");

        jLabel1.setText("Marca");

        comboMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboMarca.setMaximumSize(new java.awt.Dimension(78, 26));

        jLabel2.setText("Veículo");

        comboVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboVeiculo.setMaximumSize(new java.awt.Dimension(78, 26));
        comboVeiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboVeiculoItemStateChanged(evt);
            }
        });
        comboVeiculo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboVeiculoFocusLost(evt);
            }
        });
        comboVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVeiculoActionPerformed(evt);
            }
        });

        jLabel3.setText("Modelo");

        comboModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboModelo.setMaximumSize(new java.awt.Dimension(78, 26));

        salvarMarca.setText("Salvar Marcas");
        salvarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarMarcaActionPerformed(evt);
            }
        });

        salvarVeiculo.setText("Salvar Veículos");
        salvarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarVeiculoActionPerformed(evt);
            }
        });

        SalvarModelo.setText("Salvar Modelos");
        SalvarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarModeloActionPerformed(evt);
            }
        });

        carro.setColumns(20);
        carro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        carro.setRows(5);
        jScrollPane1.setViewportView(carro);

        carregaMarca.setText("carregar");
        carregaMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregaMarcaActionPerformed(evt);
            }
        });

        carregaVeiculo.setText("carregar");
        carregaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregaVeiculoActionPerformed(evt);
            }
        });

        carregaModelo.setText("carregar");
        carregaModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregaModeloActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceGrafica/plus.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaceGrafica/negative.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Salvar Resultado");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SalvarModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salvarVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salvarMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(148, 148, 148)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboModelo, 0, 225, Short.MAX_VALUE)
                            .addComponent(comboVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(carregaMarca)
                                .addComponent(carregaVeiculo))
                            .addComponent(carregaModelo, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carregaMarca))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carregaVeiculo))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carregaModelo))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(salvarMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salvarVeiculo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SalvarModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboVeiculoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboVeiculoFocusLost

    }//GEN-LAST:event_comboVeiculoFocusLost

    private void comboVeiculoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboVeiculoItemStateChanged
        //initComboVeiculo();
    }//GEN-LAST:event_comboVeiculoItemStateChanged

    private void carregaMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregaMarcaActionPerformed
        initComboVeiculo();
    }//GEN-LAST:event_carregaMarcaActionPerformed

    private void comboVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboVeiculoActionPerformed

    private void carregaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregaVeiculoActionPerformed
        initComboModelo();
    }//GEN-LAST:event_carregaVeiculoActionPerformed

    private void carregaModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregaModeloActionPerformed
        initCarro();
    }//GEN-LAST:event_carregaModeloActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //System.out.println(letra);
        if (letra < 38) {
            letra += 2;
            carro.setFont(new Font("Times New Roman", Font.PLAIN, letra));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //System.out.println(letra);
        if (letra > 8) {
            letra -= 2;
            carro.setFont(new Font("Times New Roman", Font.PLAIN, letra));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void salvarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarMarcaActionPerformed
        api.salvaMarca(new File("marca.json"));
    }//GEN-LAST:event_salvarMarcaActionPerformed

    private void salvarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarVeiculoActionPerformed
        api.salvaVeiculo(new File("veiculo.json"));
    }//GEN-LAST:event_salvarVeiculoActionPerformed

    private void SalvarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarModeloActionPerformed
        api.salvaModelo(new File("modelo.json"));
    }//GEN-LAST:event_SalvarModeloActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        salvarTexto();
    }//GEN-LAST:event_jButton3ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfaceGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaceGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaceGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaceGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaceGrafica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SalvarModelo;
    private javax.swing.JButton carregaMarca;
    private javax.swing.JButton carregaModelo;
    private javax.swing.JButton carregaVeiculo;
    private javax.swing.JTextArea carro;
    private javax.swing.JComboBox<String> comboMarca;
    private javax.swing.JComboBox<String> comboModelo;
    private javax.swing.JComboBox<String> comboVeiculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salvarMarca;
    private javax.swing.JButton salvarVeiculo;
    // End of variables declaration//GEN-END:variables
}
