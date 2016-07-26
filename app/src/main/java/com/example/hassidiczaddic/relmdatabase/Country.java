package com.example.hassidiczaddic.relmdatabase;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by HassidicZaddic on 7/26/2016.
 */
public  class Country extends RealmObject {

    @PrimaryKey
    private String Code;

    private String name;
    private int population;



    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "Code='" + Code + '\'' +
                ", name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}
