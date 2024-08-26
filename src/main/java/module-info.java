module com.mycompany.lab {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.lab to javafx.fxml;
    exports com.mycompany.lab;
}
