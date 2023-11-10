package com.oop2.assignment4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

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
}
