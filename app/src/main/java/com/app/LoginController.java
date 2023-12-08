package com.app;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {
    
    @FXML
    private void switchToProjects() throws IOException {
        App.setRoot("projects");
    }
}
