package com.example.tp_leboncoin;

public class AdModel {
    private String title;
    private String address;
    private int image;

    public AdModel(String title,String address, int image){
        this.address=address;
        this.title=title;
        this.image=image;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

}
