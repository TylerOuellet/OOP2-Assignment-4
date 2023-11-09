package com.oop2.assignment4;

public class Animal {
    private String aName;
    private Double aAge;
    private Double aWeight;

    public Animal(String pName){
        this.setName(pName);
    }

    void setName(String pName){
        this.aName = pName;
    }

    String getaName(){
        return aName;
    }

    public double getWeight() {
        return aWeight;
    }

    public void setWeight(Double aWeight){
        this.aWeight = aWeight;
    }

    public double getAge(){
        return aAge;
    }

    public void setAge(Double aAge){
        this.aAge = aAge;
    }
}