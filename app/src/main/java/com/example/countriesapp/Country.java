package com.example.countriesapp;

import java.io.Serializable;

public class Country implements Serializable {
    private String Name;
    private String Area;
    private String Capitol;
    private int cFlag;
    private int cSymbol;
    private int cAnthem;
    private String Link;

    public Country(String name, String area, String capitol, int cFlag, int cSymbol, int cAnthem, String link) {
        Name = name;
        Area = area;
        Capitol = capitol;
        this.cFlag = cFlag;
        this.cSymbol = cSymbol;
        this.cAnthem = cAnthem;
        Link = link;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getCapitol() {
        return Capitol;
    }

    public void setCapitol(String capitol) {
        Capitol = capitol;
    }

    public int getcFlag() {
        return cFlag;
    }

    public void setcFlag(int cFlag) {
        this.cFlag = cFlag;
    }

    public int getcSymbol() {
        return cSymbol;
    }

    public void setcSymbol(int cSymbol) {
        this.cSymbol = cSymbol;
    }

    public int getcAnthem() {
        return cAnthem;
    }

    public void setcAnthem(int cAnthem) {
        this.cAnthem = cAnthem;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    @Override
    public String toString() {
        return "Country{" +
                "Name='" + Name + '\'' +
                ", Area='" + Area + '\'' +
                ", Capitol='" + Capitol + '\'' +
                ", cFlag=" + cFlag +
                ", cSymbol=" + cSymbol +
                ", cAnthem=" + cAnthem +
                ", Link='" + Link + '\'' +
                '}';
    }
}
