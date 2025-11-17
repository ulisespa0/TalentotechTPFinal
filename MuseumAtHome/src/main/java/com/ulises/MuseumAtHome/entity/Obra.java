package com.ulises.MuseumAtHome.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int height;
    private int width;
    private double price;
    private int stock;

    public Obra(Long id, String name, String description, int height, int width, double price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.height = height;
        this.width = width;
        this.price = price;
        this.stock = stock;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Obra obra)) return false;
        return height == obra.height && width == obra.width && Double.compare(price, obra.price) == 0 && Objects.equals(id, obra.id) && Objects.equals(name, obra.name) && Objects.equals(description, obra.description);
    }

}
