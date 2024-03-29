/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.project;


import com.raven.swing.ModernScrollBarUI;
import com.raven.swing.ScrollBar;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;

import javax.swing.plaf.basic.BasicInternalFrameUI;
//import java.util.ArrayList;




/**
 *
 * @author Fahim
 */
public class Travel extends javax.swing.JInternalFrame {

    /**
     * Creates new form Home
     */
    private String uName;
    private Travel home;
    public Travel(){
        //this.uName=username;
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        
        //Creating an object of ModernScrollBarUI to customize the default scrollpane
        ModernScrollBarUI customScrollBarUI=new ModernScrollBarUI();
        javax.swing.JScrollPane scrollPane=jScrollPane1;
        
        ScrollBar CustomScrollBar = new ScrollBar();
        //scrollPane.getVerticalScrollBar().setUI(customScrollBarUI);
       // scrollPane.getVerticalScrollBar().setUI(customScrollBarUI);
        scrollPane.setVerticalScrollBar(CustomScrollBar);
        
        ui.setNorthPane(null);
        
        
        getData();
        //addItemToDropDown();
        
        
        //scroll.setVerticalScrollBar(new ScrollBar());
        
    }
    
    private void init()
    {
        home = new Travel();
        //mainPanel.add()
        
        
        
    
    }
    
    private void getData()
    {

        try{
        //Setp 1: Load the JDBC Driver
        Class.forName("com.mysql.jdbc.Driver");
        
        //create a connection to the database
        Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsrilankadb", "root", null);
      
        //create a statement to execute the query
        Statement stmt=conn.createStatement();

       ResultSet rs=stmt.executeQuery("SELECT PlaceName,PlaceLocation,PlaceCategory,Description,ImgIcon FROM travelplace");
   
        int i=0;
        TravelDataModel[] modelItem=new TravelDataModel[20];//instantiating the array of objects of TravelDataModel class
        //ArrayList<ModelItem> list=new ArrayList<ModelItem>();

        while(rs.next()){
            modelItem[i]=new TravelDataModel();
            modelItem[i].setPlaceName(rs.getString("PlaceName"));
            modelItem[i].setDescription(rs.getString("Description"));
            modelItem[i].setPlaceCategory(rs.getString("PlaceCategory"));
            modelItem[i].setPlaceLocation(rs.getString("placeLocation"));
            
            
            Blob blob = rs.getBlob("ImgIcon");
            byte[] imageBytes = blob.getBytes(1, (int) blob.length());
            ImageIcon imageIcon = new ImageIcon(imageBytes);
            //Conversion of Blob data type to ImageIcon datatype 
            
            modelItem[i].setImage(imageIcon);
            
            JpanelOnScrollPanel.add(new TravelTile(modelItem[i]));
            i++;//to get the number of results which are being shown

        }
       
        No_of_Results_label.setText(Integer.toString(i));//printing the number of results in the Label of NO_of_Results_label
        
        
        
        conn.close();
        stmt.close();
        rs.close();

        
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Cannot be retrieved from databse");
        }
        
        /*
        //to update the list of items instantly when a selection is made in the dropdown menu
        CategoryDropDown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                filter();
                //jpanel1.repaint();
            }
        });
        
        LocationDropDown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                filter();
                //jpanel1.repaint();
            }
        });
        */
        
        
        
            
}
        
        

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    /*
    //Adding Categories and locations into the dropdown list from the database 
    void addItemToDropDown throws ClassNotFoundException
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsrilankadb", "root", null);
        Statement stmt2=conn.createStatement();
         ResultSet rs2=stmt2.executeQuery("SELECT DISTINCT PlaceLocation,PlaceCategory FROM travelplace");
         
         
         //Adding Location and Category Lists to the combobox for selection
            String location=rs2.getString("PlaceLocation");
            String category=rs2.getString("PlaceCategory");
            
            CategoryDropDown.addItem(location);
            LocationDropDown.addItem(category);
         
         rs2.close();
         stmt2.close();
        }
        catch(SQLException e)
        {
            System.out.println("Data cannot be retrieved from database to the drop down menu!!");
        }
    }

`*/
    
    private void filter() {
        
        javax.swing.JPanel jpanel1=JpanelOnScrollPanel;
        jpanel1.removeAll();
       
        int i=0;
        TravelDataModel[] modelItem=new TravelDataModel[20];
                
        
        
       try{
       String selectedCategory = CategoryDropDown.getSelectedItem().toString();
       String selectedLocation = LocationDropDown.getSelectedItem().toString();
        
       Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsrilankadb", "root", null);
       
       PreparedStatement pstmt;
       /*
       PreparedStatement gives the option to use parameters within the sql query statement, and we can pass values from variables to
       those parameters which allows for filtering and more, and at the same time it increases the security by avoiding SQL injection
       attacks, where malicious users can inject SWL code into the query and gain unauthorized access to the database.
       
       Note that using a PreparedStatement can provide performance benefits over using a Statement especially when executing the same
       query multiple times with different parameter values.
       */
       //PreparedStatement pstmt1;
       if(selectedCategory.equals("All") && selectedLocation.equals("All"))
       {
       
            pstmt=conn.prepareStatement("SELECT PlaceName,PlaceLocation,PlaceCategory,Description,ImgIcon FROM travelplace");
       
       }
       else if(selectedCategory.equals("All") )
       {
            pstmt=conn.prepareStatement("SELECT PlaceName,PlaceLocation,PlaceCategory,Description,ImgIcon FROM travelplace WHERE PlaceLocation=?");
            pstmt.setString(1,selectedLocation);

       }
       else if(selectedLocation.equals("All"))
       {
           pstmt=conn.prepareStatement("SELECT PlaceName,PlaceLocation,PlaceCategory,Description,ImgIcon FROM travelplace WHERE PlaceCategory=?");
           pstmt.setString(1,selectedCategory);

       }
       else{
           
       pstmt=conn.prepareStatement("SELECT PlaceName,PlaceLocation,PlaceCategory,Description,ImgIcon FROM travelplace WHERE PlaceLocation=? AND PlaceCategory=? ");
   
       pstmt.setString(1,selectedLocation);
       pstmt.setString(2,selectedCategory);
       
       }
       
       ResultSet rs = pstmt.executeQuery();
       
       while(rs.next()){
            modelItem[i]=new TravelDataModel();//
            modelItem[i].setPlaceName(rs.getString("PlaceName"));
            modelItem[i].setDescription(rs.getString("Description"));
            modelItem[i].setPlaceCategory(rs.getString("PlaceCategory"));
            modelItem[i].setPlaceLocation(rs.getString("placeLocation"));
            
            Blob blob = rs.getBlob("ImgIcon");
            byte[] imageBytes = blob.getBytes(1, (int) blob.length());
            ImageIcon imageIcon = new ImageIcon(imageBytes);
            //item[i].setImage(imageIcon);
            
            modelItem[i].setImage(imageIcon);
            //itemtile[i]=new TravelTile(modelItem[i]);
            jpanel1.add(new TravelTile(modelItem[i]));
            i++;
            
        }
       

        No_of_Results_label.setText(Integer.toString(i));//printing the number of results in the Label of NO_of_Results_label
        SearchBar.setText("");/*When user filters items, it doesn't consider about user's searching keyword, and this program
        does not provide the facility to search within the filtered results, so to make that obvious/convey to user, whenever the 
        the filters are added the search bar has to be emptied/*
        */
        System.out.println("Filtered");
        conn.close();
        pstmt.close();
        pstmt.close();
        rs.close();
        }
        catch(SQLException e)
        {
        
            System.out.println("Cannot retrieve from Database");
        }
        jpanel1.repaint();
        jpanel1.revalidate();
        
        
    }
    
    private void searchRecords() {
        
        javax.swing.JPanel jpanel1=JpanelOnScrollPanel;
        jpanel1.removeAll();
        String searchText= SearchBar.getText();
       
        int i=0;
        TravelDataModel[] modelItem=new TravelDataModel[20];
        
        
        try {
            Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsrilankadb", "root", null);
            String sql = "Select PlaceName,PlaceLocation,PlaceCategory,Description,ImgIcon FROM travelplace WHERE LOWER(PlaceName) LIKE ?";
            PreparedStatement pstmt1 = conn.prepareStatement(sql);
            pstmt1.setString(1, "%" + searchText + "%");

            ResultSet rs = pstmt1.executeQuery();


            while (rs.next()) {
                
            modelItem[i]=new TravelDataModel();//
            modelItem[i].setPlaceName(rs.getString("PlaceName"));
            modelItem[i].setDescription(rs.getString("Description"));
            modelItem[i].setPlaceCategory(rs.getString("PlaceCategory"));
            modelItem[i].setPlaceLocation(rs.getString("placeLocation"));
            
            Blob blob = rs.getBlob("ImgIcon");
            byte[] imageBytes = blob.getBytes(1, (int) blob.length());
            ImageIcon imageIcon = new ImageIcon(imageBytes);
            //item[i].setImage(imageIcon);
            
            modelItem[i].setImage(imageIcon);
            //itemtile[i]=new TravelTile(modelItem[i]);
            jpanel1.add(new TravelTile(modelItem[i]));
            
            i++;
            }

            conn.close();
            rs.close();
            pstmt1.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        No_of_Results_label.setText(Integer.toString(i));//printing the number of results in the Label of NO_of_Results_label
        
        /*when user searches a place, it is searched from all the places, because this program does not facilitate to search within
        the filtered list, hence it needs to indicated by making the selected item values of drop down menus to "All" */
        CategoryDropDown.setSelectedItem("All");
        LocationDropDown.setSelectedItem("All");
        jpanel1.repaint();
        jpanel1.revalidate();
    }

 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JpanelOnScrollPanel = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        CategoryDropDown = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LocationDropDown = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        No_of_Results_label = new javax.swing.JLabel();
        SearchBar = new javax.swing.JTextField();
        FIlterButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        lblSearchName = new javax.swing.JLabel();

        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(800, 445));

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setPreferredSize(new java.awt.Dimension(800, 445));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JpanelOnScrollPanel.setBackground(new java.awt.Color(255, 255, 255));
        JpanelOnScrollPanel.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(JpanelOnScrollPanel);

        header.setBackground(new java.awt.Color(225, 220, 255));

        CategoryDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Wild life park", "Bridge", "Rain Forest", "Waterfall", "Plain landscape", "Antient Fortress", "Temple", "Lake" }));
        CategoryDropDown.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CategoryDropDownItemStateChanged(evt);
            }
        });
        CategoryDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryDropDownActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel1.setText("FIlters");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Category");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Loaction");

        LocationDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Badulla", "Dambulla", "Ella", "Deniyaya", "Ratnapura", "Nuwara Eliya", "Thissa" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("No. of Results   :");

        No_of_Results_label.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        No_of_Results_label.setText("no");

        SearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBarActionPerformed(evt);
            }
        });

        FIlterButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Fahim\\Documents\\NetBeansProjects\\Project\\Project\\src\\main\\java\\com\\mycompany\\project\\logo\\Filter small.png")); // NOI18N
        FIlterButton.setText("Filter");
        FIlterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FIlterButtonMouseClicked(evt);
            }
        });

        SearchButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\Fahim\\Documents\\NetBeansProjects\\Project\\Project\\src\\main\\java\\com\\mycompany\\project\\logo\\Search Icon small.png")); // NOI18N
        SearchButton.setText("Search");
        SearchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchButtonMouseClicked(evt);
            }
        });

        lblSearchName.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblSearchName.setForeground(new java.awt.Color(51, 51, 51));
        lblSearchName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearchName.setText("Search by name");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CategoryDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(LocationDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FIlterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(No_of_Results_label, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addComponent(SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SearchButton))
                    .addComponent(lblSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(427, 427, 427))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CategoryDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LocationDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FIlterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(No_of_Results_label)
                        .addComponent(lblSearchName)))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CategoryDropDownItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CategoryDropDownItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CategoryDropDownItemStateChanged

    private void CategoryDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryDropDownActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CategoryDropDownActionPerformed

    private void SearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBarActionPerformed

    private void FIlterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FIlterButtonMouseClicked
        // TODO add your handling code here:
        filter();
        
    }//GEN-LAST:event_FIlterButtonMouseClicked

    private void SearchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchButtonMouseClicked
        // TODO add your handling code here:
        searchRecords();
    }//GEN-LAST:event_SearchButtonMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JComboBox<String> CategoryDropDown;
    private javax.swing.JButton FIlterButton;
    private javax.swing.JPanel JpanelOnScrollPanel;
    private javax.swing.JComboBox<String> LocationDropDown;
    private javax.swing.JLabel No_of_Results_label;
    private javax.swing.JTextField SearchBar;
    private javax.swing.JButton SearchButton;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearchName;
    // End of variables declaration//GEN-END:variables
}
