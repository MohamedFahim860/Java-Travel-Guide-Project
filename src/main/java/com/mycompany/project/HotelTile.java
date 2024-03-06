/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.project;


import com.raven.swing.ModernScrollBarUI;
import com.raven.swing.ScrollBar;



public class HotelTile extends javax.swing.JPanel {

    /**
     * Creates new form Tile
     */
    public HotelTile(HotelDataModel hotel1) {
        initComponents();
        
        setData(hotel1);
        
        ModernScrollBarUI customScrollBarUI=new ModernScrollBarUI();
        javax.swing.JScrollPane scrollPane=jScrollPane1;
        ScrollBar CustomScrollBar = new ScrollBar();
        scrollPane.setVerticalScrollBar(CustomScrollBar);
    }
    
    private HotelDataModel storeData;
    public void setData(HotelDataModel storeData){
        this.storeData = storeData;
        hotelImage.setImage(storeData.getImage());
        hotelName.setText(storeData.getHotelName());
        hotelDistrict.setText(storeData.getDistrict());
        hotelPrice.setText("LKR "+storeData.getHotelPrice());
        hotelStar.setText(storeData.getHotelStar());
        hotelDescription.setText(storeData.getHotelDescription());
        //hotelAcCondition.setText(storeData.getAcContion());
       // hotelPoolAvailability.setText(storeData.getPoolAvailability());
        //phoneNum.setText(storeData.getPhoneNum());
        
        
        
        //set pool availability
        if(storeData.getPoolAvailability().equals("yes")){
            poolCheckBox.setSelected(true);
        }
        else{
            poolCheckBox.setSelected(false);
        }
        
        //set ac condition
        if(storeData.getPoolAvailability().equals("yes")){
            acCheckBox.setSelected(true);
        }
        else{
            acCheckBox.setSelected(false);
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

        hotelImage = new com.raven.swing.PictureBox();
        hotelName = new javax.swing.JLabel();
        hotelDistrict = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hotelDescription = new javax.swing.JTextArea();
        hotelPrice = new javax.swing.JLabel();
        pictureBox1 = new com.raven.swing.PictureBox();
        pictureBox2 = new com.raven.swing.PictureBox();
        poolCheckBox = new javax.swing.JCheckBox();
        acCheckBox = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        pictureBox3 = new com.raven.swing.PictureBox();
        hotelStar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(780, 260));

        hotelName.setBackground(new java.awt.Color(255, 255, 255));
        hotelName.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        hotelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hotelName.setText("Hotel Name");
        hotelName.setOpaque(true);

        hotelDistrict.setBackground(new java.awt.Color(153, 102, 255));
        hotelDistrict.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hotelDistrict.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hotelDistrict.setOpaque(true);

        hotelDescription.setEditable(false);
        hotelDescription.setBackground(new java.awt.Color(255, 255, 255));
        hotelDescription.setColumns(20);
        hotelDescription.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        hotelDescription.setLineWrap(true);
        hotelDescription.setRows(5);
        hotelDescription.setWrapStyleWord(true);
        hotelDescription.setBorder(null);
        hotelDescription.setSelectionStart(2);
        jScrollPane1.setViewportView(hotelDescription);

        hotelPrice.setBackground(new java.awt.Color(204, 153, 255));
        hotelPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hotelPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hotelPrice.setOpaque(true);

        pictureBox1.setImage(new javax.swing.ImageIcon("C:\\Users\\Fahim\\Documents\\NetBeansProjects\\Project\\Project Only Home Issue\\Project\\src\\main\\java\\com\\mycompany\\project\\logo\\Pool Icon.png")); // NOI18N

        pictureBox2.setImage(new javax.swing.ImageIcon("C:\\Users\\Fahim\\Documents\\NetBeansProjects\\Project\\Project Only Home Issue\\Project\\src\\main\\java\\com\\mycompany\\project\\logo\\AC Icon.png")); // NOI18N

        poolCheckBox.setSelected(true);
        poolCheckBox.setText("Pool");
        poolCheckBox.setBorder(null);
        poolCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poolCheckBoxActionPerformed(evt);
            }
        });

        acCheckBox.setText("Air conditioner");
        acCheckBox.setBorder(null);
        acCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acCheckBoxActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        pictureBox3.setBackground(new java.awt.Color(255, 204, 255));
        pictureBox3.setImage(new javax.swing.ImageIcon("C:\\Users\\Fahim\\Documents\\NetBeansProjects\\Project\\Project Only Home Issue\\Project\\src\\main\\java\\com\\mycompany\\project\\logo\\StarRating Icon.png")); // NOI18N
        pictureBox3.setOpaque(true);

        hotelStar.setBackground(new java.awt.Color(255, 204, 255));
        hotelStar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hotelStar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hotelStar.setText("5");
        hotelStar.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pictureBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hotelStar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(hotelStar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(hotelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hotelName, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(poolCheckBox)
                                .addGap(41, 41, 41)
                                .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(acCheckBox))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hotelPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(hotelDistrict, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(37, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hotelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(hotelName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hotelDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(hotelPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(acCheckBox, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(poolCheckBox))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void poolCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poolCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_poolCheckBoxActionPerformed

    private void acCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acCheckBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox acCheckBox;
    private javax.swing.JTextArea hotelDescription;
    private javax.swing.JLabel hotelDistrict;
    private com.raven.swing.PictureBox hotelImage;
    private javax.swing.JLabel hotelName;
    private javax.swing.JLabel hotelPrice;
    private javax.swing.JLabel hotelStar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.PictureBox pictureBox1;
    private com.raven.swing.PictureBox pictureBox2;
    private com.raven.swing.PictureBox pictureBox3;
    private javax.swing.JCheckBox poolCheckBox;
    // End of variables declaration//GEN-END:variables
}
