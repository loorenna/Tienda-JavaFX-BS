module org.example.tareafxconbs {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    opens org.example.tareafxconbs to javafx.fxml;
    exports org.example.tareafxconbs;
}