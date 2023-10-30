package com.oop2.assignment4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        Enclosure lions = new Enclosure();
        lions.setName("Lions");
        lions.addAnimal(new Animal("Simba"));
        lions.addAnimal(new Animal("Mufasa"));
        lions.addAnimal(new Animal("Nala"));

        Enclosure tigerHabitat = new Enclosure();
        tigerHabitat.setName("Tigers Habitat");
        tigerHabitat.addAnimal(new Animal("Rajah"));
        tigerHabitat.addAnimal(new Animal("Shere Khan"));

        Enclosure tigerCubs = new Enclosure();
        tigerCubs.setName("Tiger Cubs");
        tigerCubs.addAnimal(new Animal("Tala"));

        CompositeAnimal tigers = new CompositeAnimal();
        tigers.setName("Tigers");
        tigers.addCollection(tigerHabitat);
        tigers.addCollection(cubs);

        CompositeAnimal cougars = new CompositeAnimal();
        cougars.setName("Cougars");

        CompositeAnimal myCollection = new CompositeAnimal();
        myCollection.setName("Big Cats");
        myCollection.addCollection(lions);
        myCollection.addCollection(tigers);
        myCollection.addCollection(cougars);
    }



}