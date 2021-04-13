package com.example.testrecyclerview;

public class Donnee {

    private String planet;
    private String description;

    private int imgPlanet;

    Donnee (String planet, String description, int imgPlanet){
        this.planet = planet;
        this.description = description;
        this.imgPlanet = imgPlanet;
    }

    public String getPrincipal() {
        return planet;
    }

    public String getAuxiliaire() {
        return description;
    }

    public int getImgPlanet() {
        return imgPlanet;
    }
}
