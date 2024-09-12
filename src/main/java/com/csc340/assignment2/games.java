package com.csc340.assignment2;

public class games {


    private String displayName;
    private int storeID;
    private double salePrice;
    private double regularPrice;

    public games(String name, int id, double salePrice, double regularPrice){
        this.displayName = name;
        this.storeID = id;
        this.salePrice = salePrice;
        this.regularPrice = regularPrice;

    }

    public String getDisplayName() {
        return displayName;
    }

    public int getStoreID() {
        return storeID;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public void setDisplayName(String name) {
        this.displayName = name;
    }

    public void setStoreID(int id) {
        this.storeID = id;
    }

    public void setSalePrice(int price) {
        this.salePrice = price;
    }

    public void setRegularPrice(int price) {
        this.regularPrice = price;
    }
}
