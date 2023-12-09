package com.app;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.User;

public class SignupController {

    @FXML private TextField firstname;
    @FXML private TextField lastname;
    @FXML private TextField email;
    @FXML private TextField phonenum;
    @FXML private TextField username;
    @FXML private TextField password;
    
    @FXML
    private void switchToProjects() throws IOException {
        User newUser = new User(firstname.getText(), lastname.getText(), username.getText(), password.getText(), email.getText(), phonenum.getText());
        App.setRoot("projects");
    }

}