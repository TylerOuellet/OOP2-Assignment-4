package com.oop2.assignment4;

import java.util.regex.Pattern;

public class Animal {
    private String aName;
    private Double aAge;
    private Double aWeight;

    public Animal(String pName){
        this.setName(pName);
    }

    // New constructor for name, weight, and age
    public Animal(String pName, Double pWeight, Double pAge) {
        this.setName(pName);
        this.setWeight(pWeight);
        this.setAge(pAge);
    }

    void setName(String pName){
       if (isValidName(pName)) {
           this.aName = pName;
       } else {
           throw new IllegalArgumentException("The name should only have letters!");
       }
    }

    String getName(){
        return aName;
    }

    // If weight is not numebr or empty, set it to 0
    public double getWeight() {
        if (this.aWeight != null) {
            return this.aWeight.doubleValue();
        } else {
            return 0;
        }
    }

    public void setWeight(Double aWeight){
        if (isValidWeight(aWeight) && aWeight >= 0) {
            this.aWeight = aWeight;
        } else {
            throw new IllegalArgumentException("The weight should only have numbers and shouldn't be in the negative");
        }
    }

    // If age is not number or empty, set it to 0
    public double getAge() {
        if (this.aAge != null) {
            return this.aAge.doubleValue();
        } else {
            return 0;
        }
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