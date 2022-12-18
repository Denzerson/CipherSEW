package com.example.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        URL myurl = Main.class.getResource("hello-view.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(myurl);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Kural's World best Decryption/Encryption");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}