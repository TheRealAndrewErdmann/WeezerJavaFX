module com.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens com.app to javafx.fxml;
    exports com.app;

    opens model to javafx.fxml;
    exports model;
}
