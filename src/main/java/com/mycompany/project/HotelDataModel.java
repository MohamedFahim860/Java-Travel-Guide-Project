/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import javax.swing.Icon;

/**
 *
 * @author Hansapani
 */
public class HotelDataModel{
    
    private int hotelId;
    private String district;
    private String hotelName;
    private String hotelPrice;
    private String hotelStar;
    private String hotelDescription;
    private String poolAvailability;
    private String AcContion;
    private String phoneNum;
    private String bookLink;
    private Icon image;
    

    public HotelDataModel(int hotelId,String district, String hotelName, String hotelPrice, String hotelStar, String hotelDescription, String poolAvailability, String AcContion, String phoneNum, String bookLink, Icon image) {
        this.hotelId = hotelId;
        this.district=district;
        this.hotelName = hotelName;
        this.hotelPrice = hotelPrice;
        this.hotelStar = hotelStar;
        this.hotelDescription = hotelDescription;
        this.poolAvailability = poolAvailability;
        this.AcContion = AcContion;
        this.phoneNum = phoneNum;
        this.bookLink = bookLink;
        this.image = image;
    }

    public HotelDataModel() {
        
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getDistrict() {
        return district;
    }
 
    public String getHotelName() {
        return hotelName;
    }

    public String getHotelPrice() {
        return hotelPrice;
    }

    public String getHotelStar() {
        return hotelStar;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public String getPoolAvailability() {
        return poolAvailability;
    }

    public String getAcContion() {
        return AcContion;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getBookLink() {
        return bookLink;
    }

    public Icon getImage() {
        return image;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setHotelPrice(String hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public void setHotelStar(String hotelStar) {
        this.hotelStar = hotelStar;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public void setPoolAvailability(String poolAvailability) {
        this.poolAvailability = poolAvailability;
    }

    public void setAcContion(String AcContion) {
        this.AcContion = AcContion;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setBookLink(String bookLink) {
        this.bookLink = bookLink;
    }

    public void setImage(Icon image) {
        this.image = image;
    }
    
    
   
}
