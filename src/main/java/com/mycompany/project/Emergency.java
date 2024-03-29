/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fahim
 */
public class Emergency extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form Home
     */
     
    public Emergency() {
        
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        loadDatatoTable();
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
        combo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        pictureBox1 = new com.raven.swing.PictureBox();

        setPreferredSize(new java.awt.Dimension(800, 445));

        jPanel1.setBackground(new java.awt.Color(225, 220, 255));

        combo.setBackground(new java.awt.Color(122, 72, 221));
        combo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Special", "Hospital", "Police", "Railway", " ", " " }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        table.setBackground(new java.awt.Color(150, 135, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Place Name", "Contact No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        pictureBox1.setImage(new javax.swing.ImageIcon("C:\\Users\\Fahim\\Documents\\NetBeansProjects\\Project\\Project Only Home Issue\\Project\\src\\main\\java\\com\\mycompany\\project\\logo\\Emergency banner.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 160, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        loadDatatoTable();
    }//GEN-LAST:event_comboActionPerformed

private void loadDatatoTable(){
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsrilankadb?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            Statement st =con.createStatement();
            String item = combo.getSelectedItem().toString();
            
            DefaultTableModel dm = (DefaultTableModel)table.getModel();
                while(dm.getRowCount() > 0)   
                {
                    dm.removeRow(0);
                }
            if(item.equals("All")){
                String query = "SELECT * FROM data";
                ResultSet re = st.executeQuery(query);
                
                while (re.next()) {
                //String place = String.valueOf(re.getString("Place"));
                String place = re.getString("Place");
                String type = re.getString("Type");
                String phoneNo = re.getString("PhoneNo");
                
                String tbData[]={place,phoneNo};
                DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
                
                tblModel.addRow(tbData);
                
                }
            }
            
            if(item.equals("Special")){
                String query = "SELECT * FROM data WHERE Type='Special'";
                ResultSet re = st.executeQuery(query);
                
                while (re.next()) {
                //String place = String.valueOf(re.getString("Place"));
                String place = re.getString("Place");
                String type = re.getString("Type");
                String phoneNo = re.getString("PhoneNo");
                
                String tbData[]={place,phoneNo};
                DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
                
                tblModel.addRow(tbData);
                
                }
              
               
                //con.close();
                
                
            }
            if(item.equals("Hospital")){
                String query = "SELECT * FROM data WHERE Type='Hospital'";
                ResultSet re = st.executeQuery(query);
                
                while (re.next()) {
                //String place = String.valueOf(re.getString("Place"));
                String place = re.getString("Place");
                String type = re.getString("Type");
                String phoneNo = re.getString("PhoneNo");
                
                String tbData[]={place,phoneNo};
                DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
                
                tblModel.addRow(tbData);
                }
                
            }
            if(item.equals("Police")){
                String query = "SELECT * FROM data WHERE Type='Police'";
                ResultSet re = st.executeQuery(query);
                
                while (re.next()) {
                //String place = String.valueOf(re.getString("Place"));
                String place = re.getString("Place");
                String type = re.getString("Type");
                String phoneNo = re.getString("PhoneNo");
                
                String tbData[]={place,phoneNo};
                DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
                
                tblModel.addRow(tbData);
                }
                
            }
            if(item.equals("Railway")){
                String query = "SELECT * FROM data WHERE Type='Railway'";
                ResultSet re = st.executeQuery(query);
                
                while (re.next()) {
                //String place = String.valueOf(re.getString("Place"));
                String place = re.getString("Place");
                String type = re.getString("Type");
                String phoneNo = re.getString("PhoneNo");
                
                String tbData[]={place,phoneNo};
                DefaultTableModel tblModel =(DefaultTableModel)table.getModel();
                
                tblModel.addRow(tbData);
                }
                
            }
            con.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.PictureBox pictureBox1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
