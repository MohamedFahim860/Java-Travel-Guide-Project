/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.project;


import com.raven.swing.ModernScrollBarUI;
import com.raven.swing.ScrollBar;

public class TravelTile extends javax.swing.JPanel {

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }
    
    /*
    public ScaleImage(){
        initComponents();
        scaleImage();
    
    }
    
    
    private void scaleImage(){
        ImageIcon icon = new ImageIcon("C:\\Users\\Fahim\\Downloads\\Sigiriya.jpg");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel3.setIcon(scaledIcon);

    }
    
    */

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    private boolean selected;
  
    public TravelTile(TravelDataModel item1) {
        initComponents();
        setData(item1);
        
        
        //Creating an object of ModernScrollBarUI to customize the default scrollpane
        ModernScrollBarUI customScrollBarUI=new ModernScrollBarUI();
        javax.swing.JScrollPane scrollPane=jScrollPane1;
        ScrollBar CustomScrollBar = new ScrollBar();
        scrollPane.setVerticalScrollBar(CustomScrollBar);
        
    }
    
    public void setData(TravelDataModel data)
    {
        
        placePic.setImage(data.getImage());
        placeDescription.setText(data.getDescription());
        placeCategory.setText(data.getPlaceCategory());
        placeName.setText(data.getPlaceName());
        placeLocation.setText(data.getPlaceLocation());
        
    }
    
    //@Override
    /*public void paint(Graphics g) {
         Graphics2D g2 = (Graphics2D) g.create();
         g2.setRenderingHint(RenderringHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIASING_ON);
         g2.setColor(new Color(242,242,242));
         g2.fileRoundRect(0,0,getWidth(),getHeight(),20,20);
         g2.dispose();
         super.paint(g);
         
         
        
    }
    */
    
   
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        placeName = new javax.swing.JLabel();
        placeCategory = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        placeDescription = new javax.swing.JTextArea();
        placePic = new com.raven.swing.PictureBox();
        placeLocation = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(758, 276));

        placeName.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        placeName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        placeName.setText("Name");

        placeCategory.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        placeCategory.setForeground(new java.awt.Color(102, 102, 102));
        placeCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        placeCategory.setText("Category");

        placeDescription.setEditable(false);
        placeDescription.setColumns(20);
        placeDescription.setLineWrap(true);
        placeDescription.setRows(5);
        placeDescription.setWrapStyleWord(true);
        jScrollPane1.setViewportView(placeDescription);

        placePic.setImage(new javax.swing.ImageIcon("C:\\Users\\Fahim\\Documents\\NetBeansProjects\\Project\\Project\\src\\main\\java\\Travel_Places_Photos\\Sigiriya.jpg")); // NOI18N

        placeLocation.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        placeLocation.setForeground(new java.awt.Color(102, 102, 102));
        placeLocation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        placeLocation.setText("Location");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(placePic, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(placeLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(271, 271, 271))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(placeCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(255, 255, 255))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(placeName, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(placeName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(placeLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(placeCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(placePic, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel placeCategory;
    private javax.swing.JTextArea placeDescription;
    private javax.swing.JLabel placeLocation;
    private javax.swing.JLabel placeName;
    private com.raven.swing.PictureBox placePic;
    // End of variables declaration//GEN-END:variables
}
