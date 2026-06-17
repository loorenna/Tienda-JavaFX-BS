package org.example.tareafxconbs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("produc.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 464, 479);
        scene.getStylesheets().add(HelloApplication.class.getResource("/Estilos/estilos.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
