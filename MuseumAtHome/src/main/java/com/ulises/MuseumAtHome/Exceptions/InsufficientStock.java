package com.ulises.MuseumAtHome.Exceptions;

public class InsufficientStock extends Exception {

    public InsufficientStock(){}

    @Override
    public String getMessage() {
        return "Stock insuficiente";
    }

}
