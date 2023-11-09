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
<<<<<<< HEAD
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
=======
        this.aAge = aAge;
>>>>>>> parent of 9ebc0b6 (Added input validation for the animals)
    }
}