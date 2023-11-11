package com.oop2.assignment4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class EnclosureController {
    public Button viewButton;
    public Button addButton;
    public Button removeButton;
    public Button backButton;
    @FXML
    private ListView<String> aEnclosureView;
    private Enclosure aEnclosure =new Enclosure();
    public void setEnclosure(Enclosure pEnclosure){
        this.aEnclosure = pEnclosure;
        displayContents();
    }
    public void displayContents(){
        aEnclosureView.getItems().setAll(aEnclosure.compositeList());
    }
    @FXML
    protected void onBackButtonClick(){
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        currentStage.close();
    }
    @FXML
    protected void removeAnimalButton(){
        aEnclosure.removeAnimal(aEnclosureView.getSelectionModel().getSelectedIndex());
        displayContents();
    }

    // Open Third window with add button
    public void onAddButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditInformationWindow.fxml"));
        Parent editInfoWindow = fxmlLoader.load();

        Scene editInfoScene = new Scene(editInfoWindow, 400, 300);
        Stage editInfoStage = new Stage();
        editInfoStage.setTitle("Edit Information");
        editInfoStage.initModality(Modality.WINDOW_MODAL);
        editInfoStage.initOwner(addButton.getScene().getWindow());
        editInfoStage.setScene(editInfoScene);
        editInfoStage.showAndWait();
    }

    // Open Third window with View/Edit button
    @FXML
    protected void onViewButtonClick() throws IOException {
        int selectedIndex = aEnclosureView.getSelectionModel().getSelectedIndex();

        if (selectedIndex == -1) {
            System.out.println("Select an animal to view/edit.");
            return;
        }

        Animal selectedAnimal = aEnclosure.getAnimal(selectedIndex);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditInformationWindow.fxml"));
        Parent editInfoWindow = fxmlLoader.load();
        EditInformationController editInfoController = fxmlLoader.getController();
        editInfoController.setAnimal(selectedAnimal);

        Scene editInfoScene = new Scene(editInfoWindow, 400, 300);
        Stage editInfoStage = new Stage();
        editInfoStage.setTitle("Edit Information");
        editInfoStage.initModality(Modality.WINDOW_MODAL);
        editInfoStage.initOwner(viewButton.getScene().getWindow());
        editInfoStage.setScene(editInfoScene);
        editInfoStage.showAndWait();
    }
}
