package com.oop2.assignment4;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ZooController {
    @FXML
    public Button backButton;
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
        displayContents();
    }

    private String aEnclosure;
    private String pEnclosure;


    public void setEnclosure(String selectedEnclosure){
        this.aEnclosure = pEnclosure;
        this.displayContents();
    }

    public String getSelectedEnclosure(){
        return pEnclosure;
    }
    @FXML
    protected void onBackButtonClick(){
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        currentStage.close();
    }


    @FXML
    protected void onViewButtonClick(ActionEvent pEvent) throws IOException {


        if(aAnimalCollectionView.getSelectionModel().getSelectedIndex() == -1) {
            System.out.println("Select something");
        }
            AnimalCollection aAnimalCollection = aCompositeAnimal.getIndex(aAnimalCollectionView.getSelectionModel().getSelectedIndex());


        if (aAnimalCollection instanceof Enclosure) {
            Enclosure currentEnclosure = (Enclosure) aAnimalCollection;
            FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("Enclosure.fxml"));
            Parent view = fxmlLoader.load();
            EnclosureController newEnclosureCont = fxmlLoader.getController();
            newEnclosureCont.setEnclosure(currentEnclosure);
            Scene nextScene = new Scene(view, 600, 400);
            Stage nextStage = new Stage();
            nextStage.setScene(nextScene);
            nextStage.setTitle("ZMS");
            nextStage.initModality(Modality.WINDOW_MODAL);
            nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
            nextStage.showAndWait();

        } else if (aAnimalCollection instanceof CompositeAnimal) {
            CompositeAnimal currentCompositeAnimal = (CompositeAnimal) aAnimalCollection;
            FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("Main.fxml"));
            Parent parent = fxmlLoader.load();
            ZooController newZooController = fxmlLoader.getController();
            newZooController.setComposite(currentCompositeAnimal);
            Scene scene = new Scene(parent, 600, 400);
            Stage stage = new Stage();
            stage.setTitle("ZMS");
            stage.setScene(scene);
            stage.show();

        }
        else{
            System.out.println("Undefined error");
        }
    }
    public void setComposite(CompositeAnimal compositeAnimal){
        aCompositeAnimal = compositeAnimal;
        displayContents();
    }

    public void displayContents(){
        aAnimalCollectionView.getItems().setAll(aCompositeAnimal.compositeList());


    }
protected void checkComposite(ActionEvent pEvent) throws IOException{


    }
    }
