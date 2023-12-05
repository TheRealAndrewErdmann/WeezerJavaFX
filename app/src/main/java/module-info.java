module com.app {
    //com.app = library 

    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens com.app to javafx.fxml;
    exports com.app;

    opens controllers to javafx.fxml;
    exports controllers;

    opens model to javafx.fxml;
    exports model;
}
