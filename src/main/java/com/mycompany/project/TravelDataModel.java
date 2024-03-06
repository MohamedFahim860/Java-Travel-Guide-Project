/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
import javax.swing.Icon;

/**
 *
 * @author Fahim
 */
public class TravelDataModel {

    /**
     * @return the itemID
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * @param itemID the itemID to set
     */
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    /**
     * @return the placeName
     */
    public String getPlaceName() {
        return placeName;
    }

    /**
     * @param placeName the placeName to set
     */
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    /**
     * @return the placeLocation
     */
    public String getPlaceLocation() {
        return placeLocation;
    }

    /**
     * @param placeLocation the placeLocation to set
     */
    public void setPlaceLocation(String placeLocation) {
        this.placeLocation = placeLocation;
    }

    /**
     * @return the placeCategory
     */
    public String getPlaceCategory() {
        return placeCategory;
    }

    /**
     * @param placeCategory the placeCategory to set
     */
    public void setPlaceCategory(String placeCategory) {
        this.placeCategory = placeCategory;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the image
     */
    public Icon getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Icon image) {
        this.image = image;
    }

    public TravelDataModel(int itemID, String placeName, String placeLocation, String placeCategory, String description, Icon image) {
        this.itemID = itemID;
        this.placeName = placeName;
        this.placeLocation = placeLocation;
        this.placeCategory = placeCategory;
        this.description = description;
        this.image = image;
    }

    
    public TravelDataModel() {
    }
  
    
    private int itemID;
    private String placeName;
    private String placeLocation;
    private String placeCategory;
    private String description;
    private Icon image;
    
    
    
    
}
