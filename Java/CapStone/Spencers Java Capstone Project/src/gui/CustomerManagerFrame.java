/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import buisiness.Customer;
import db.CustomerDB;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author sdant
 */
public class CustomerManagerFrame extends javax.swing.JFrame {

   private static JTable customerTable;
   private static CustomerTableModel customerTableModel;
    public CustomerManagerFrame() {
        //Set up look and feel
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }        
        setTitle("Customer Manager"); 
        setLocationByPlatform(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        customerTableModel = new CustomerTableModel();
        /*JTable customerTable = new JTable();
        customerTable.setModel(customerTableModel);
        jScrollPane.add(customerTable);
        customerTable.setVisible(true);*/
        jTable1.setModel(customerTableModel);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        helpBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 200));

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        delBtn.setText("Delete");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        Edit.setText("Edit");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

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
        jScrollPane2.setViewportView(jTable1);

        helpBTN.setText("Help");
        helpBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(helpBTN)
                        .addGap(35, 35, 35)
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addBtn)
                            .addComponent(delBtn)
                            .addComponent(Edit)
                            .addComponent(exitBtn))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(helpBTN))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
       CustomerForm form = new CustomerForm(this,true);
       form.show();
       CustomerDB.add(CustomerForm.transfer);
       //customerTableModel.addRow(new Object[]{CustomerForm.transfer.getEmail(),
        //   CustomerForm.transfer.getFirst(), CustomerForm.transfer.getLast()});
       customerTableModel.insertRow(customerTableModel.getRowCount(), new Object[]{CustomerForm.transfer.getEmail(),
           CustomerForm.transfer.getFirst(), CustomerForm.transfer.getLast()});
       customerTableModel.updateTable();
       CustomerForm.transfer = null;
    }//GEN-LAST:event_addBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        if(jTable1.getSelectionModel().isSelectionEmpty()){
           JOptionPane.showMessageDialog(getParent(),
                   "No customer selected","Customer selection error",JOptionPane.ERROR_MESSAGE);
       }
        else {
        int i = jTable1.getSelectedRow();
        CustomerDB.delete(i);
        customerTableModel.removeRow(i);
        customerTableModel.updateTable();
        }
    }//GEN-LAST:event_delBtnActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
       if(jTable1.getSelectionModel().isSelectionEmpty()){
           JOptionPane.showMessageDialog(getParent(),
                   "No customer selected","Customer selection error",JOptionPane.ERROR_MESSAGE);
       }
       else {
       int i = jTable1.getSelectedRow();
       ArrayList<Customer> list = CustomerDB.list();
       CustomerForm form = new CustomerForm(this,true,list.get(i).getEmail(),
       list.get(i).getFirst(),list.get(i).getLast());
       form.show();
       customerTableModel.setValueAt(CustomerForm.transfer.getFirst(),i,1);
       customerTableModel.setValueAt(CustomerForm.transfer.getLast(),i,2);
       CustomerDB.update(CustomerForm.transfer);
       customerTableModel.updateTable();
       }
    }//GEN-LAST:event_EditActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitBtnActionPerformed

    private void helpBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpBTNActionPerformed
    JOptionPane.showMessageDialog(getParent(), "Click the Add button to add new customer\n"
    + "Select a customer and press Delete to delete an entry\n"
    + "Select a customer and press Edit to update their entry\n"
            + "Press Exit to close applitcation", 
            "Help menu",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_helpBTNActionPerformed

    //Simple method to create a new table
    private JTable buildCustomerTable(){
        customerTableModel = new CustomerTableModel();
        JTable table = new JTable(customerTableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setBorder(null);
        return table;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Edit;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton delBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton helpBTN;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
