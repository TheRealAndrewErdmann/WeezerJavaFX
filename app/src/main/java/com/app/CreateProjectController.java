package com.app;

import java.io.IOException;
import javafx.fxml.FXML;

public class CreateProjectController {
    
    @FXML
    private void switchToProjects2() throws IOException {
        App.setRoot("projects2");
    }

    @FXML
    private void switchToProjects() throws IOException {
        App.setRoot("projects");
    }
}
