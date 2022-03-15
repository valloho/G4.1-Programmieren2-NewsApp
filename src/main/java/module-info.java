module SimpleMavenApplication {
    requires javafx.controls;
    requires javafx.fxml;
    opens at.ac.fhcampuswien to javafx.fxml;
    exports at.ac.fhcampuswien;
}