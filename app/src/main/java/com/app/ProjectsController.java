package com.app;

import java.io.IOException;
import javafx.fxml.FXML;

public class ProjectsController {

    @FXML
    private void switchToScrumBoard() throws IOException {
        App.setRoot("home");
    }
}