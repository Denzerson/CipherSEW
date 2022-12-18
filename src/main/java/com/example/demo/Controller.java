package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable{

    MonoAlphabeticCipher mac = new MonoAlphabeticCipher();
    ShiftCipher sc;

    private Stage stage;
    private Scene scene;
    private Parent root;

    String options[] =
            { "Substitution Cipher", "Shift Cipher" };

    @FXML
    ComboBox comboBox = new ComboBox(FXCollections.observableArrayList(options));

    @FXML
    private Button button;

    @FXML
    private TextField SecretAlphabetTextField;
    @FXML
    private TextField EncryptedTextFieldSubst;
    @FXML
    private TextField DecryptedTextFieldSubst;

    @FXML
    private TextField ShiftValue;
    @FXML
    private TextField EncryptedTextFieldShift;
    @FXML
    private TextField DecryptedTextFieldShift;

    public void switchToSceneShift(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToSceneSubst(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToMainScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void load(ActionEvent event) throws IOException {
        String data = comboBox.getSelectionModel().getSelectedItem().toString();
        if(data != null) {
            if(data.equals("Shift Cipher")) {
                switchToSceneShift(event);
            } else if (data.equals("Substitution Cipher")) {
                switchToSceneSubst(event);
            } else {
                System.out.println("No Method selected!");
            }
        }
    }

    public void decryptSubst(ActionEvent event) {
        mac.setSecretAlphabet(SecretAlphabetTextField.getText());
        String decrypted = mac.decrypt(EncryptedTextFieldSubst.getText());

        DecryptedTextFieldShift.setText(decrypted);
    }

    public void encryptSubst(ActionEvent event) {
        mac.setSecretAlphabet(SecretAlphabetTextField.getText());
        String encrypted = mac.encrypt(DecryptedTextFieldSubst.getText());

        EncryptedTextFieldShift.setText(encrypted);
    }

    public void decryptShift(ActionEvent event) {
        sc = new ShiftCipher(Integer.parseInt(ShiftValue.getText()));

        String decrypted = sc.encrypt(EncryptedTextFieldShift.getText());

        DecryptedTextFieldShift.setText(decrypted);
    }

    public void encryptShift(ActionEvent event) {
        sc = new ShiftCipher(Integer.parseInt(ShiftValue.getText()));

        String encrypted = sc.decrypt(DecryptedTextFieldShift.getText());

        EncryptedTextFieldShift.setText(encrypted);
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] items = {"Substitution Cipher","Shift Cipher"};
        comboBox.getItems().addAll(items);
    }
}