package com.oop2.assignment4;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditInformationController {
    private EnclosureController enclosureController;
    public void setEnclosureController(EnclosureController enclosureController) {
        this.enclosureController = enclosureController;
    }


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
    private void onSaveButtonClick(ActionEvent event) {
        // Retrieve and update information from your UI elements (text fields, etc.)
        String newName = nameTextField.getText();
        double newWeight = Double.parseDouble(weightTextField.getText());
        double newAge = Double.parseDouble(ageTextField.getText());

        if (selectedAnimal != null) {
            // Update existing animal
            selectedAnimal.setName(newName);
            selectedAnimal.setWeight(newWeight);
            selectedAnimal.setAge(newAge);
        } else {
            // Create a new animal
            Animal newAnimal = new Animal(newName);
            newAnimal.setWeight(newWeight);
            newAnimal.setAge(newAge);

            // Create an instance of Enclosure
            Enclosure enclosure = new Enclosure();

            // Add the new animal to the enclosure
            enclosure.addAnimal(newAnimal);
        }

        showAlert("Animal information updated successfully");

        // Close the window
        closeWindow();
    }


    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void onExitButtonClick(ActionEvent event) {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
