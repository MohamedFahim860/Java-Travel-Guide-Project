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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Fahim
 */
public class Hotels extends javax.swing.JInternalFrame {

    private Hotels home;

    public Hotels() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();

        //Creating an object of ModernScrollBarUI to customize the default scrollpane
        //ModernScrollBarUI customScrollBarUI = new ModernScrollBarUI();
        //JScrollPane ScrollPane;
        javax.swing.JScrollPane scrollPane = jScrollPane1;
        //scrollPane.

        ScrollBar CustomScrollBar = new ScrollBar();
        //scrollPane.getVerticalScrollBar().setUI(customScrollBarUI);
        // scrollPane.getVerticalScrollBar().setUI(customScrollBarUI);
        scrollPane.setVerticalScrollBar(CustomScrollBar);

        ui.setNorthPane(null);

        testData();
    }

    
    private void testData() {
        //javax.swing.JPanel jpanel1 = panelOnScrollPane;

        try {

            //Set database connectivity
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsrilankadb", "root", null);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT Hotel_Name,Hotel_District,Hotel_Price,Hotel_Review,Hotel_Description, Pool_Availability,Ac_Condition,Phone_Number,Hotel_Image FROM hotel_data");

            int i = 0;
            //Create a HotelDataModel type array to store HotelDataModel type objects
            HotelDataModel[] hotels = new HotelDataModel[20];
            while (rs.next()) {
                //Set the object values retrive from the data base to the relevant variables in the HotelDataModel class
                hotels[i] = new HotelDataModel();
                hotels[i].setHotelName(rs.getString("Hotel_Name"));
                hotels[i].setDistrict(rs.getString("Hotel_District"));
                hotels[i].setHotelPrice(rs.getString("Hotel_Price"));
                hotels[i].setHotelStar(rs.getString("Hotel_Review"));
                hotels[i].setHotelDescription(rs.getString("Hotel_Description"));
                hotels[i].setPoolAvailability(rs.getString("Pool_Availability"));
                hotels[i].setAcContion(rs.getString("Ac_Condition"));
                hotels[i].setPhoneNum(rs.getString("Phone_Number"));

                //Store the image in to the HotelDataModel class relavant variable 
                Blob blob = rs.getBlob("Hotel_Image");
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                ImageIcon imageIcon = new ImageIcon(imageBytes);
                //item[i].setImage(imageIcon);

                hotels[i].setImage(imageIcon);
                //itemtile[i]=new Item(modelItem[i]);

                //Add the created object in to the Scroll pane ---> jpanel
                JpanelOnScrollPanel.add(new HotelTile(hotels[i]));
                i++;
            }
            conn.close();
            stmt.close();
            rs.close();
            
            lblNumOfResult.setText(Integer.toString(i));//printing the number of results in the Label of NO_of_Results_label

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Cannot be retrieved from databse");
        }
        
    }
    
    
    //filtering location
    /*
    private void filter(){
        //javax.swing.JPanel jpanel1=panelOnScrollPane;
        JpanelOnScrollPanel.removeAll();
        
        int i=0;
        HotelDataModel[] hotels = new HotelDataModel[20];
        
        try{
            String selectedLocation = locationDropDown.getSelectedItem().toString();
            String mins = minPrice.getText().toString();
            String maxs = maxPrice.getText().toString();
            int min = Integer.parseInt(mins);
            int max = Integer.parseInt(maxs);
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsrilankadb", "root", null);
            System.out.println(min + max);
            PreparedStatement pstmt;
            
            if(selectedLocation.equals("All")){
                pstmt = conn.prepareStatement("SELECT Hotel_Name,Hotel_District,Hotel_Price,Hotel_Review,Hotel_Description, Pool_Availability,Ac_Condition,Phone_Number,Hotel_Image FROM hotel_data");
            }
            else{
               pstmt = conn.prepareStatement("SELECT Hotel_Name,Hotel_District,Hotel_Price,Hotel_Review,Hotel_Description, Pool_Availability,Ac_Condition,Phone_Number,Hotel_Image FROM hotel_data where Hotel_District=?");
               pstmt.setString(1,selectedLocation);
            }
            
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                
 
                //Set the object values retrive from the data base to the relevant variables in the HotelDataModel class
                hotels[i] = new HotelDataModel();
                hotels[i].setHotelName(rs.getString("Hotel_Name"));
                hotels[i].setDistrict(rs.getString("Hotel_District"));
                hotels[i].setHotelPrice(rs.getString("Hotel_Price"));
                hotels[i].setHotelStar(rs.getString("Hotel_Review"));
                hotels[i].setHotelDescription(rs.getString("Hotel_Description"));
                hotels[i].setPoolAvailability(rs.getString("Pool_Availability"));
                hotels[i].setAcContion(rs.getString("Ac_Condition"));
                hotels[i].setPhoneNum(rs.getString("Phone_Number"));

                //Store the image in to the HotelDataModel class relavant variable 
                Blob blob = rs.getBlob("Hotel_Image");
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                ImageIcon imageIcon = new ImageIcon(imageBytes);
                //item[i].setImage(imageIcon);

                hotels[i].setImage(imageIcon);
                //itemtile[i]=new Item(modelItem[i]);

                //Add the created object in to the Scroll pane ---> jpanel
                
                String sprice = (hotels[i].getHotelPrice());
                float iprice = Float.parseFloat(sprice);
                if((min == 0 && max ==0) || (min <= iprice  && iprice <= max)){
                    JpanelOnScrollPanel.add(new HotelTile(hotels[i]));
                }    
                else{
                    JOptionPane.showMessageDialog(rootPane,"Not Available");
                }
                i++;
            }
            
            searchText.setText(""); //make searchbar empty
            conn.close();
            pstmt.close();
            rs.close();
            
            lblNumOfResult.setText(Integer.toString(i));//printing the number of results in the Label of NO_of_Results_label
        }
        catch(SQLException e)
        {
        
            System.out.println("Cannot retrieve from Database");
        }
    }
    */
    
    private void filter(){
        //javax.swing.JPanel jpanel1=panelOnScrollPane;
        JpanelOnScrollPanel.removeAll();
        
        int i=0;
        HotelDataModel[] hotels = new HotelDataModel[20];
        
        try{
            String selectedLocation = locationDropDown.getSelectedItem().toString();
            String mins = minPrice.getText().toString();
            String maxs = maxPrice.getText().toString();
            int min = Integer.parseInt(mins);
            int max = Integer.parseInt(maxs);
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsrilankadb", "root", null);
            System.out.println(min + max);
            PreparedStatement pstmt;
            
            if((selectedLocation.equals("All")) && (min==0 && max==0)){
               pstmt = conn.prepareStatement("SELECT Hotel_Name,Hotel_District,Hotel_Price,Hotel_Review,Hotel_Description, Pool_Availability,Ac_Condition,Phone_Number,Hotel_Image FROM hotel_data");
            }
            else if(min==0 && max ==0){
               pstmt = conn.prepareStatement("SELECT Hotel_Name,Hotel_District,Hotel_Price,Hotel_Review,Hotel_Description, Pool_Availability,Ac_Condition,Phone_Number,Hotel_Image FROM hotel_data where Hotel_District=?");
               pstmt.setString(1,selectedLocation);
                
            }
            else if((selectedLocation.equals("All")) && (0!=min && max!=0)){
               pstmt = conn.prepareStatement("SELECT Hotel_Name,Hotel_District,Hotel_Price,Hotel_Review,Hotel_Description, Pool_Availability,Ac_Condition,Phone_Number,Hotel_Image FROM hotel_data where Hotel_Price between ? and ?");
               pstmt.setString(1,mins);
               pstmt.setString(2,maxs);
                
            }
            else{
               pstmt = conn.prepareStatement("SELECT Hotel_Name,Hotel_District,Hotel_Price,Hotel_Review,Hotel_Description, Pool_Availability,Ac_Condition,Phone_Number,Hotel_Image FROM hotel_data where Hotel_District=? AND Hotel_Price between ? and ?");
               pstmt.setString(1,selectedLocation);
               pstmt.setString(2,mins);
               pstmt.setString(3,maxs);
             
            }
            
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                
 
                //Set the object values retrive from the data base to the relevant variables in the HotelDataModel class
                hotels[i] = new HotelDataModel();
                hotels[i].setHotelName(rs.getString("Hotel_Name"));
                hotels[i].setDistrict(rs.getString("Hotel_District"));
                hotels[i].setHotelPrice(rs.getString("Hotel_Price"));
                hotels[i].setHotelStar(rs.getString("Hotel_Review"));
                hotels[i].setHotelDescription(rs.getString("Hotel_Description"));
                hotels[i].setPoolAvailability(rs.getString("Pool_Availability"));
                hotels[i].setAcContion(rs.getString("Ac_Condition"));
                hotels[i].setPhoneNum(rs.getString("Phone_Number"));

                //Store the image in to the HotelDataModel class relavant variable 
                Blob blob = rs.getBlob("Hotel_Image");
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                ImageIcon imageIcon = new ImageIcon(imageBytes);
                //item[i].setImage(imageIcon);

                hotels[i].setImage(imageIcon);
                //itemtile[i]=new Item(modelItem[i]);

                //Add the created object in to the Scroll pane ---> jpanel
                
                String sprice = (hotels[i].getHotelPrice());
                float iprice = Float.parseFloat(sprice);
                if((min == 0 && max ==0) || (min <= iprice  && iprice <= max)){
                    JpanelOnScrollPanel.add(new HotelTile(hotels[i]));
                }    
                else{
                    JOptionPane.showMessageDialog(rootPane,"Not Available");
                }
                i++;
            }
            
            searchText.setText(""); //make searchbar empty
            JpanelOnScrollPanel.repaint();
            JpanelOnScrollPanel.revalidate();
            conn.close();
            pstmt.close();
            rs.close();
            
            lblNumOfResult.setText(Integer.toString(i));//printing the number of results in the Label of NO_of_Results_label
        }
        catch(SQLException e)
        {
        
            System.out.println("Cannot retrieve from Database");
        }
    }
    
    
    
    
    //Searching
    
    private void search(){
        
        //javax.swing.JPanel jpanel1=panelOnScrollPane;
        JpanelOnScrollPanel.removeAll();
        String search_text= searchText.getText();
        System.out.println(search_text);
       
        int i=0;
        HotelDataModel[] hotels=new HotelDataModel[20];
            
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsrilankadb", "root", null);
            String sql = "SELECT Hotel_Name,Hotel_District,Hotel_Price,Hotel_Review,Hotel_Description, Pool_Availability,Ac_Condition,Phone_Number,Hotel_Image FROM hotel_data WHERE LOWER(Hotel_District) LIKE ?";
            PreparedStatement pstmt1 = conn.prepareStatement(sql);
            pstmt1.setString(1, "%" + search_text + "%");
            
            
            ResultSet rs = pstmt1.executeQuery();
            
            while (rs.next()) {
                //Set the object values retrive from the data base to the relevant variables in the HotelDataModel class
                hotels[i] = new HotelDataModel();
                hotels[i].setHotelName(rs.getString("Hotel_Name"));
                hotels[i].setDistrict(rs.getString("Hotel_District"));
                hotels[i].setHotelPrice(rs.getString("Hotel_Price"));
                hotels[i].setHotelStar(rs.getString("Hotel_Review"));
                hotels[i].setHotelDescription(rs.getString("Hotel_Description"));
                hotels[i].setPoolAvailability(rs.getString("Pool_Availability"));
                hotels[i].setAcContion(rs.getString("Ac_Condition"));
                hotels[i].setPhoneNum(rs.getString("Phone_Number"));

                //Store the image in to the HotelDataModel class relavant variable 
                Blob blob = rs.getBlob("Hotel_Image");
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                ImageIcon imageIcon = new ImageIcon(imageBytes);
              

                hotels[i].setImage(imageIcon);
                

                //Add the created object in to the Scroll pane ---> jpanel
                System.out.println("before add");
                JpanelOnScrollPanel.add(new HotelTile(hotels[i]));
                System.out.println("after add");
                minPrice.setText("0");
                maxPrice.setText("0");
                System.out.println("Searching is happening");
                i++;
            }
            
            conn.close();
            pstmt1.close();
            rs.close();
            
            lblNumOfResult.setText(Integer.toString(i));//printing the number of results in the Label of NO_of_Results_label
        }
        catch (SQLException ex) {
        }
        locationDropDown.setSelectedItem("All");
        JpanelOnScrollPanel.repaint();
        JpanelOnScrollPanel.revalidate();
    }
    
    /*
    private void searchRecords() {
        
        javax.swing.JPanel jpanel1=JpanelOnScrollPanel;
        jpanel1.removeAll();
        String searchtext= searchText.getText();
       
        int i=0;
        HotelDataModel[] hotels=new HotelDataModel[20];
        
        
        try {
            Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsrilankadb", "root", null);
            String sql = "SELECT Hotel_Name,Hotel_District,Hotel_Price,Hotel_Review,Hotel_Description, Pool_Availability,Ac_Condition,Phone_Number,Hotel_Image FROM hotel_data WHERE LOWER(Hotel_District) LIKE ?";
            PreparedStatement pstmt1 = conn.prepareStatement(sql);
            pstmt1.setString(1, "%" + searchtext + "%");

            ResultSet rs = pstmt1.executeQuery();


            while (rs.next()) {
                //Set the object values retrive from the data base to the relevant variables in the HotelDataModel class
                hotels[i] = new HotelDataModel();
                hotels[i].setHotelName(rs.getString("Hotel_Name"));
                hotels[i].setDistrict(rs.getString("Hotel_District"));
                hotels[i].setHotelPrice(rs.getString("Hotel_Price"));
                hotels[i].setHotelStar(rs.getString("Hotel_Review"));
                hotels[i].setHotelDescription(rs.getString("Hotel_Description"));
                hotels[i].setPoolAvailability(rs.getString("Pool_Availability"));
                hotels[i].setAcContion(rs.getString("Ac_Condition"));
                hotels[i].setPhoneNum(rs.getString("Phone_Number"));

                //Store the image in to the HotelDataModel class relavant variable 
                Blob blob = rs.getBlob("Hotel_Image");
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());
                ImageIcon imageIcon = new ImageIcon(imageBytes);
                //item[i].setImage(imageIcon);

                hotels[i].setImage(imageIcon);
                //itemtile[i]=new Item(modelItem[i]);

                //Add the created object in to the Scroll pane ---> jpanel
                JpanelOnScrollPanel.add(new HotelTile(hotels[i]));
                System.out.println("Searching is happening");
                i++;
            }

            conn.close();
            rs.close();
            pstmt1.close();
        } catch (SQLException ex) {
            System.out.println("Data cannot be retrieved by database");
            ex.printStackTrace();
        }
        
        lblNumOfResult.setText(Integer.toString(i));//printing the number of results in the Label of NO_of_Results_label

        locationDropDown.setSelectedItem("All");

        jpanel1.repaint();
        jpanel1.revalidate();
    }
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        locationDropDown = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        searchText = new javax.swing.JTextField();
        minPrice = new javax.swing.JTextField();
        maxPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        priceButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblNumOfResult = new javax.swing.JLabel();
        lblSearchName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JpanelOnScrollPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(true);

        background.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(180, 153, 255));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Location");

        locationDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Ambalangoda", "Anuradhapura", "Badulla", "Bandarawela", "Balangoda", "Colombo", "Dambulla", "Galle", "Kandy", "Jaffna", "Matara", " " }));
        locationDropDown.setBorder(null);
        locationDropDown.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        locationDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationDropDownActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Price Range");

        searchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextActionPerformed(evt);
            }
        });
        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextKeyPressed(evt);
            }
        });

        minPrice.setText("0");

        maxPrice.setText("0");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Minimum");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Maximum");

        priceButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        priceButton.setText("Filter");
        priceButton.setBorder(null);
        priceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceButtonActionPerformed(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("No. of Results   :");

        lblNumOfResult.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblNumOfResult.setText("no");

        lblSearchName.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblSearchName.setForeground(new java.awt.Color(51, 51, 51));
        lblSearchName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearchName.setText("Search by name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locationDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(maxPrice))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(minPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(searchButton)
                                        .addGap(109, 109, 109))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(priceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNumOfResult, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblSearchName))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(locationDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(minPrice)
                            .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(lblNumOfResult))
                    .addComponent(priceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JpanelOnScrollPanel.setBackground(new java.awt.Color(255, 255, 255));
        JpanelOnScrollPanel.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(JpanelOnScrollPanel);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void locationDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationDropDownActionPerformed
        filter();
    }//GEN-LAST:event_locationDropDownActionPerformed

    private void searchTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyPressed

    }//GEN-LAST:event_searchTextKeyPressed

    private void priceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceButtonActionPerformed
        filter();
    }//GEN-LAST:event_priceButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
       search();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpanelOnScrollPanel;
    private javax.swing.JPanel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumOfResult;
    private javax.swing.JLabel lblSearchName;
    private javax.swing.JComboBox<String> locationDropDown;
    private javax.swing.JTextField maxPrice;
    private javax.swing.JTextField minPrice;
    private javax.swing.JButton priceButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchText;
    // End of variables declaration//GEN-END:variables
}
