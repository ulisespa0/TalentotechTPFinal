package com.ulises.MuseumAtHome.entity;

import java.util.ArrayList;

public class Cart {

    private long id;
    private ArrayList<Work> works;

    public Cart(long id){
        this.id = id;
        works = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public ArrayList<Work> getWorks() {
        return works;
    }

    public Double totalPrice(){
        Double total = 0.0;
        for(Work w : works){
            total+=w.getPrice();
        }
        return total;
    }

}
