package com.ulises.MuseumAtHome.entity;

import com.ulises.MuseumAtHome.Exceptions.InsufficientStock;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "T_WORK")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int height;
    private int width;
    private double price;
    private int stock;
    private String url;

    public Work(){}

    public Work(Long id, String name, String description, int height, int width, double price, int stock, String url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.height = height;
        this.width = width;
        this.price = price;
        this.stock = stock;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getUrl() {
        return url;
    }

    public int Area(){
        return width * height;
    }

    public int Perimeter(){
        return width * 2 + height * 2;
    }

    public void reduceStock(int minus) throws InsufficientStock {
        if (stock > minus){
            stock = stock - minus;
            return;
        }
        throw new InsufficientStock();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Work work)) return false;
        return height == work.height && width == work.width && Double.compare(price, work.price) == 0 && Objects.equals(id, work.id) && Objects.equals(name, work.name) && Objects.equals(description, work.description);
    }

}
