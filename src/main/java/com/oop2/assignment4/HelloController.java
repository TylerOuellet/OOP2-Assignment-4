package com.oop2.assignment4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class HelloController {
    @FXML
    private ListView<String> aAnimalCollectionView;

    private CompositeAnimal aCompositeAnimal = new CompositeAnimal();

    public void importAnimals() {
        Enclosure lions = new Enclosure();
        lions.setName("Lions");
        lions.addAnimal(new Lion("Simba"));
        lions.addAnimal(new Lion("Mufasa"));
        lions.addAnimal(new Lion("Nala"));

        Enclosure tigerHabitat = new Enclosure();
        tigerHabitat.setName("Tigers Habitat");
        tigerHabitat.addAnimal(new Tiger("Rajah"));
        tigerHabitat.addAnimal(new Tiger("Shere Khan"));

        Enclosure tigerCubs = new Enclosure();
        tigerCubs.setName("Tiger Cubs");
        tigerCubs.addAnimal(new Tiger("Tala (Mother)"));
        tigerCubs.addAnimal(new Tiger("Ravi"));
        tigerCubs.addAnimal(new Tiger("Kali"));
        tigerCubs.addAnimal(new Tiger("Indra"));

        CompositeAnimal tigers = new CompositeAnimal();
        tigers.setName("Tigers");
        tigers.addCollection(tigerHabitat);
        tigers.addCollection(tigerCubs);

        Enclosure cougarMedical = new Enclosure();
        cougarMedical.setName("Cougar Medical Care");
        cougarMedical.addAnimal(new Cougar("Sierra"));

        Enclosure cougarHabitat = new Enclosure();
        cougarHabitat.setName("Cougars Habitat");
        cougarHabitat.addAnimal(new Cougar("Rocky"));
        cougarHabitat.addAnimal(new Cougar("Luna"));
        cougarHabitat.addAnimal(new Cougar("Lenny"));

        CompositeAnimal cougars = new CompositeAnimal();
        cougars.setName("Cougars");
        cougars.addCollection(cougarHabitat);
        cougars.addCollection(cougarMedical);

        CompositeAnimal myCollection = new CompositeAnimal();
        myCollection.setName("Big Cats");
        myCollection.addCollection(lions);
        myCollection.addCollection(tigers);
        myCollection.addCollection(cougars);

        this.aCompositeAnimal.addCollection(myCollection);
    }



}