package com.oop2.assignment4;

import java.util.ArrayList;
import java.util.List;

public class Enclosure implements AnimalCollection{
    private String aName;

    private final List<Animal> aAnimals= new ArrayList<Animal>();

    @Override
    public String showAllAnimals() {
        StringBuilder allAnimals = new StringBuilder();
        for (Animal currenAnimal : aAnimals){
            allAnimals.append(currenAnimal.toString());
        }
        return allAnimals.toString();
    }

    public void addAnimal(Animal pAnimal){
        this.aAnimals.add(pAnimal);
    }

    public void removeAnimal(Animal pAnimal){
        this.aAnimals.remove(pAnimal);
    }

    @Override
    public void setName(String pName) {
        this.aName = pName;
    }

    @Override
    public String getName() {
        return this.aName;
    }
}