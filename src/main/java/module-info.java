module com.mycompany.robotgui {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.robotgui to javafx.fxml;
    exports com.mycompany.robotgui;
}