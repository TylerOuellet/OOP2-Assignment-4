package com.oop2.assignment4;

import java.util.regex.Pattern;

public class Animal {
    private String aName;
    private Double aAge;
    private Double aWeight;

    public Animal(String pName){
        this.setName(pName);
    }

    void setName(String pName){
       if (isValidName(pName)) {
           this.aName = pName;
       } else {
           throw new IllegalArgumentException("The name should only have letters!");
       }
    }

    String getaName(){
        return aName;
    }

    public double getWeight() {
        return aWeight;
    }

    public void setWeight(Double aWeight){
        if (isValidWeight(aWeight) && aWeight >= 0) {
            this.aWeight = aWeight;
        } else {
            throw new IllegalArgumentException("The weight should only have numbers and shouldn't be in the negative");
        }
    }

    public double getAge(){
        return aAge;
    }

    public void setAge(Double aAge){
        if (isValidAge(aAge) && aAge >= 0) {
            this.aAge = aAge;
        } else {
            throw new IllegalArgumentException("The age should only have numbers and shouldn't be in the negative");
        }
    }

    //Validate the information
    private boolean isValidName(String name){
        return Pattern.matches("^[a-zA-Z ()]+$", name);
    }

    private boolean isValidWeight(double weight){
        String weightStr = String.valueOf(weight);
        return Pattern.matches("^[0-9]+(\\.[0-9]+)?$", weightStr);
    }
    private boolean isValidAge(double age) {
        String ageSTR = String.valueOf(age);
        return Pattern.matches("^[0-9]+(\\.[0-9]+)?$", ageSTR);
    }
}