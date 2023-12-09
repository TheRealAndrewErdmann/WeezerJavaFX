package com.app;

import java.io.IOException;
import javafx.fxml.FXML;

public class HomeController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("home");
    }
}
