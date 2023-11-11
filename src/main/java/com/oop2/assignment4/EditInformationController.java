package com.oop2.assignment4;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditInformationController {
    @FXML
    private TextField nameTextField;

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField weightTextField;

    @FXML
    private Button saveButton;

    @FXML
    private Button exitButton;

    private Animal selectedAnimal;

    public void setAnimal(Animal animal) {
        this.selectedAnimal = animal;
        displayAnimalInfo();
    }

    private void displayAnimalInfo() {
        if (selectedAnimal != null) {
            nameTextField.setText(selectedAnimal.getName());
            // Assuming Animal class has methods like getAge() and getWeight()
            ageTextField.setText(String.valueOf(selectedAnimal.getAge()));
            weightTextField.setText(String.valueOf(selectedAnimal.getWeight()));
        }
    }

    @FXML
    private void onSaveButtonClicked() {
        // Implement logic to save or update animal information
        // For example, you can update the selectedAnimal object with the new values.
        // Then close the window or perform any other necessary actions.

        closeWindow();
    }

    @FXML
    private void onExitButtonClicked() {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
