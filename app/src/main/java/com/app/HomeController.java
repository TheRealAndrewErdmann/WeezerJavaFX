package com.app;

import java.io.IOException;
import javafx.fxml.FXML;

public class HomeController {
    
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }

    @FXML
    private void switchToSignup() throws IOException {
        App.setRoot("signup");
    }
}
