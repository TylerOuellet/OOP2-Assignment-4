package com.oop2.assignment4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ZooApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooApplication.class.getResource("Main.fxml"));
        Parent parent = fxmlLoader.load();
        ZooController newZooController = fxmlLoader.getController();
        newZooController.importAnimals();
        Scene scene = new Scene(parent, 600, 400);
        stage.setTitle("ZMS");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}