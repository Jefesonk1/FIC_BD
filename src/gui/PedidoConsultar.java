package gui;

import dao.PedidoDao;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Pedido;


/**
 *
 * @author Jefeson
 */
public class PedidoConsultar extends javax.swing.JFrame {

    private long codigoVendedor;

    public long getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(long codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    /**
     * Creates new form PedidoConsultar
     */
    public PedidoConsultar() {
        initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPedidos = new javax.swing.JTable();
        txtPedidos = new javax.swing.JTextField();
        btnPedidos = new javax.swing.JButton();
        cboxCriterio = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        tbPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Data Pedido", "Nome Vendedor", "Nome Cliente", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPedidos);

        btnPedidos.setText("Buscar");
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });

        cboxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Por Nome Cliente", "Por Minhas Vendas", "Por Nome Vendedor" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboxCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(774, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboxCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPedidos)
                    .addComponent(btnPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        try {
            // TODO add your handling code here:

            List<Pedido> pedidos = null;

            if (cboxCriterio.getSelectedIndex() == 0 && txtPedidos.getText().length()>0) {
                pedidos=PedidoDao.readByNomeCliente(txtPedidos.getText() + "");
            }
            if (cboxCriterio.getSelectedIndex() == 1) {
                pedidos=PedidoDao.readByCodigoVendedor(codigoVendedor + "");
            }
            if (cboxCriterio.getSelectedIndex() == 2 &&txtPedidos.getText().length()>0) {
                pedidos =PedidoDao.readByNomeVendedor(txtPedidos.getText() + "");
            }

        DefaultTableModel modeloTable = (DefaultTableModel) tbPedidos.getModel();
        modeloTable.setNumRows(0);

        for (Pedido p : pedidos) {
            modeloTable.addRow(new Object[]{
                p.getCodigo(),
                p.getDtpedido(),
                p.getVendedor().getPrimeiroNome()+" "+p.getVendedor().getNomeDoMeio()+" "+p.getVendedor().getSobrenome(),
                p.getCliente().getPrimeiroNome()+" "+p.getCliente().getNomeDoMeio()+" "+p.getCliente().getSobrenome()
                
                
            });
        }
    }
    catch (SQLException ex

    
        ) {
            Logger.getLogger(PedidoConsultar.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnPedidosActionPerformed

    private void tbPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPedidosMouseClicked
        // TODO add your handling code here:
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int column = source.columnAtPoint(evt.getPoint());
        String s = source.getModel().getValueAt(row, 0) + "";
        if (evt.getClickCount() == 2) {
            JOptionPane.showMessageDialog(null, s + evt.getClickCount());
            PedidoConsultarSub pcs = new PedidoConsultarSub(Long.parseLong(s),codigoVendedor);
            pcs.setVisible(true);

        }
    }//GEN-LAST:event_tbPedidosMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPedidos;
    private javax.swing.JComboBox<String> cboxCriterio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPedidos;
    private javax.swing.JTextField txtPedidos;
    // End of variables declaration//GEN-END:variables
}
