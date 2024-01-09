package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Cliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static String pathachiInput="src/main/resources/com/mycompany/archivos de entrada/";
    public static String pathachiOutput="src/main/resources/com/mycompany/archivos de salida/";
    public static String pathachiImage="src/main/resources/com/mycompany/Images/";
    public static ArrayList<Cliente> cliente;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("FXMLVentanadeInicio"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}