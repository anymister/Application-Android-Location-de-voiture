package com.anisapp.locationdevoiture.models;

public class HighTech {
    //attributs
    private String name;
    private String memoning;
    private int price;

    //contruct
    public HighTech(String name, String memoning, int price){
        this.name=name;
        this.price=price;
        this.memoning=memoning;
    }
    //methodes
    public String getMemoning(){
        return memoning;
    }
    public String getName(){ return name;}

    public int getPrice() {
        return price;
    }
}
