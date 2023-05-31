/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import database.Connection;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author faidfadjri
 */
public final class Transaction extends javax.swing.JInternalFrame {

    /**
     * Creates new form Transaction
     */
    public Transaction() {
        initComponents();
        setTable();
    }
    
    
     public void setTable(){
        // -- Ambil data dari database
        Connection database = new Connection();
        
        // -- Define Table and add column header
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("No");
        tableModel.addColumn("Barang");
        tableModel.addColumn("Harga");
        tableModel.addColumn("Jumlah");
        
        int rowHeight = 35;
        Font headerFont = new Font("Sans Serif", Font.PLAIN, 20);
        transactionTable.getTableHeader().setFont(headerFont);
        transactionTable.getTableHeader().setOpaque(false);
        transactionTable.getTableHeader().setBackground(new Color(227,240,243));
        transactionTable.getTableHeader().setForeground(new Color(16,118,171));
        transactionTable.setRowHeight(rowHeight);
        

        JTableHeader header = transactionTable.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), rowHeight));

        transactionTable.setModel(tableModel);
        
        ResultSet res = database.runQueries("SELECT * FROM transaksi");
        try {
            while(res.next()){
                tableModel.addRow(new Object[] {
                    res.getString("id"),
                    res.getString("jenis"),
                    res.getString("barang"),
                    res.getString("harga")
                });
            }
        } catch(SQLException e){
            System.out.print(e.getErrorCode());
        }
        
        
        // -- set font size
        transactionTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Set the font size and font family for the specific row
                int fontSize = 18; // Customize the font size as needed
                String fontFamily = "Sans Serif"; // Customize the font family as needed
                Font font = new Font(fontFamily, Font.PLAIN, fontSize);
                component.setFont(font);

                // Center align the rows
                ((DefaultTableCellRenderer) component).setHorizontalAlignment(SwingConstants.CENTER);

                return component;
            }
        });
        
        // -- List selection listener
        ListSelectionModel selectionModel = transactionTable.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && !selectionModel.isSelectionEmpty()) {
                    int selectedRow = selectionModel.getMinSelectionIndex();

                    // Retrieve data from the selected row
                    Object id = transactionTable.getValueAt(selectedRow, 0); // Assuming you want to retrieve data from the first column
                    Object item = transactionTable.getValueAt(selectedRow, 1); // Assuming you want to retrieve data from the first column
                    Object harga = transactionTable.getValueAt(selectedRow, 2); // Assuming you want to retrieve data from the first column
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sayHello1 = new javax.swing.JLabel();
        sayHello = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        backToStok = new javax.swing.JButton();
        addTransaksi = new javax.swing.JButton();

        sayHello1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        sayHello1.setForeground(new java.awt.Color(153, 153, 153));
        sayHello1.setText("Enjoy the easiest way of manage your own business. Good Luck!");

        sayHello.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        sayHello.setForeground(new java.awt.Color(16, 118, 171));
        sayHello.setText("Welcome fellas!");

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1366, 737));
        setPreferredSize(new java.awt.Dimension(1366, 737));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(16, 118, 171));
        jLabel1.setText("Transaction");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Manage your business income and outcome easily");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/wallet.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(16, 118, 171));
        jLabel4.setText("Rp. 500.000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(transactionTable);

        backToStok.setBackground(new java.awt.Color(204, 204, 204));
        backToStok.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        backToStok.setText("Kembali");
        backToStok.setFocusable(false);
        backToStok.setRolloverEnabled(false);
        backToStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToStokActionPerformed(evt);
            }
        });

        addTransaksi.setBackground(new java.awt.Color(102, 204, 255));
        addTransaksi.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        addTransaksi.setText("Tambah Transaksi");
        addTransaksi.setFocusable(false);
        addTransaksi.setRolloverEnabled(false);
        addTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTransaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(addTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 531, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(backToStok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backToStok, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backToStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToStokActionPerformed
        Menu pages = new Menu();
        pages.setVisible(true);
        this.getDesktopPane().add(pages);
        this.dispose();
    }//GEN-LAST:event_backToStokActionPerformed

    private void addTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addTransaksiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTransaksi;
    private javax.swing.JButton backToStok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel sayHello;
    private javax.swing.JLabel sayHello1;
    private javax.swing.JTable transactionTable;
    // End of variables declaration//GEN-END:variables
}
