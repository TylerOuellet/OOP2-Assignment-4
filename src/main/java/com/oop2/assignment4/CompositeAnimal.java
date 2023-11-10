package com.oop2.assignment4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompositeAnimal implements  AnimalCollection{
    private final List<AnimalCollection> aCollections = new ArrayList<AnimalCollection>();
    String compositeAnimal;

    public void addCollection(AnimalCollection pCollection){
        this.aCollections.add(pCollection);
    }
    public void removeCollection(AnimalCollection pCollection){
        this.aCollections.remove(pCollection);
    }

    @Override
    public String showAllAnimals() {
        StringBuilder allAnimals = new StringBuilder();
        for (AnimalCollection currentCollection : aCollections){
            allAnimals.append(currentCollection.toString());
        }
        return allAnimals.toString();
    }

    @Override
    public void setName(String pName) {
        compositeAnimal = pName;
    }

    @Override
    public String getName() {
        return compositeAnimal;
    }
    public AnimalCollection getIndex(int selectedIndex){
        return this.aCollections.get(selectedIndex);
    }
    public LinkedList<String> compositeList(){
        LinkedList<String> listed = new LinkedList<>();
        for (AnimalCollection currentAnimal :aCollections) {
            listed.add(currentAnimal.getName());
        }
        return listed;
    }
}