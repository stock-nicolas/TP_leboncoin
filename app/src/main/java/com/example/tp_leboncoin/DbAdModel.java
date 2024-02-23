package com.example.tp_leboncoin;

public class DbAdModel {
    private String title;
    private String address;
    private String image;
    private String Desc;

    public DbAdModel(String title, String address, String image, String Desc){
        this.address=address;
        this.title=title;
        this.image=image;
        this.Desc=Desc;

    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getImage(){
        return image;
    }
    public void setImage(String image){
        this.image=image;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }

    public String getDesc(){
        return Desc;
    }
    public void setDesc(String Desc){
        this.Desc=Desc;
    }
}
