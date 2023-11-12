package com.oop2.assignment4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Enclosure implements AnimalCollection{
    private String aName;

    private final List<Animal> aAnimals= new ArrayList<Animal>();

    @Override
    public String showAllAnimals() {
        StringBuilder allAnimals = new StringBuilder();
        for (Animal currentAnimal : aAnimals) {
            allAnimals.append(currentAnimal.getName()).append("\n");
        }
        return allAnimals.toString();
    }

    public void addAnimal(Animal pAnimal) {
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
    public LinkedList<String> compositeList(){
        LinkedList<String> listed = new LinkedList<>();
        for (Animal currentAnimal :aAnimals) {
            listed.add(currentAnimal.getName());
        }
        return listed;
    }

    public void removeAnimal(int selectedIndex) {
        aAnimals.remove(selectedIndex);
    }

    // select the animal from listview
    public Animal getAnimal(int selectedIndex) {
        return aAnimals.get(selectedIndex);
    }
}