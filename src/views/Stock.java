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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

/**
 *
 * @author faidfadjri
 */
public final class Stock extends javax.swing.JInternalFrame{

    /**
     * Creates new form Homepage
     */
    public Stock() {
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
        stokTable.getTableHeader().setFont(headerFont);
        stokTable.getTableHeader().setOpaque(false);
        stokTable.getTableHeader().setBackground(new Color(227,240,243));
        stokTable.getTableHeader().setForeground(new Color(16,118,171));
        stokTable.setRowHeight(rowHeight);
        

        JTableHeader header = stokTable.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), rowHeight));

        stokTable.setModel(tableModel);
        
        ResultSet res = database.runQueries("SELECT * FROM stok");
        try {
            while(res.next()){
                tableModel.addRow(new Object[] {
                    res.getString("id"),
                    res.getString("item"),
                    res.getString("price"),
                    res.getString("quantity")
                });
            }
        } catch(SQLException e){
            System.out.print(e.getErrorCode());
        }
        
        
        // -- set font size
        stokTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
        ListSelectionModel selectionModel = stokTable.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && !selectionModel.isSelectionEmpty()) {
                    int selectedRow = selectionModel.getMinSelectionIndex();

                    // Retrieve data from the selected row
                    Object id = stokTable.getValueAt(selectedRow, 0); // Assuming you want to retrieve data from the first column
                    Object item = stokTable.getValueAt(selectedRow, 1); // Assuming you want to retrieve data from the first column
                    Object harga = stokTable.getValueAt(selectedRow, 2); // Assuming you want to retrieve data from the first column
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        desc = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        stokTable = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        transaksiButton = new javax.swing.JToggleButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Tambahkan Transaksi");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setText("Point of Sales");

        desc.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        desc.setForeground(new java.awt.Color(102, 102, 102));
        desc.setText("Manage your transactional histories");

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1366, 737));
        setPreferredSize(new java.awt.Dimension(1366, 737));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(61, 164, 225));
        jLabel2.setText("Inventory Management");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Manage your transaction histories");

        stokTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        stokTable.setFocusable(false);
        stokTable.setSelectionBackground(new java.awt.Color(227, 240, 243));
        stokTable.setShowHorizontalLines(true);
        stokTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(stokTable);

        jToggleButton1.setBackground(new java.awt.Color(61, 164, 225));
        jToggleButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("Tambah Stok");
        jToggleButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        jToggleButton1.setBorderPainted(false);
        jToggleButton1.setFocusPainted(false);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        transaksiButton.setBackground(new java.awt.Color(254, 254, 254));
        transaksiButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        transaksiButton.setForeground(new java.awt.Color(49, 157, 212));
        transaksiButton.setText("Kembali");
        transaksiButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(49, 157, 212), 2, true));
        transaksiButton.setFocusPainted(false);
        transaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transaksiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(340, 340, 340)
                        .addComponent(transaksiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(transaksiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
       AddStock dialog = new AddStock(null, closable);
       dialog.setVisible(true);
       
       
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                setTable();
            }
        });
       
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void transaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaksiButtonActionPerformed
        Menu pages = new Menu();
        pages.setVisible(true);
        this.getDesktopPane().add(pages);
        this.dispose();
    }//GEN-LAST:event_transaksiButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel desc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable stokTable;
    private javax.swing.JToggleButton transaksiButton;
    // End of variables declaration//GEN-END:variables

}