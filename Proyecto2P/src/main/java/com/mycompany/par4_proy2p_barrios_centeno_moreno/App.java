package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Cliente;
import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Pago;
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
    public static ArrayList<Pago> pagos = new ArrayList<>();
    private static Stage Primarystage;

    @Override
    public void start(Stage stage) throws IOException {

        Primarystage = stage;
        setRoot("FXMLVentanadeInicio",600,400,null, "VentanaReserva1");

        Primarystage.show();
        
    }

    static void setRoot(String fxml, int width, int height, String cssFile, String title) throws IOException {
        //scene.setRoot(loadFXML(fxml));
        Parent root = loadFXML(fxml);
        Scene s = new Scene(root,width,height);
        
        if (cssFile != null && !cssFile.isEmpty()){
            s.getStylesheets().add(App.class.getResource(cssFile).toExternalForm());
        }
        Primarystage.setScene(s);
        Primarystage.setTitle(title);
        Primarystage.show();
        
        
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
