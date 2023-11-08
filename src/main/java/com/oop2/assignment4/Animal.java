package com.oop2.assignment4;

public class Animal {
    private String aName;

    public Animal(String pName){
        this.setName(pName);
    }

    void setName(String pName){
        this.aName = pName;
    }

    String getaName(){
        return aName;
    }
}