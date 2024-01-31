/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Promocion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author grilsemo
 */
public class FXMLVentanaPromocionesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane conMapa;
    
    public static int contador=5;
    
    private ArrayList<Promocion> promociones = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        leerDatosPromociones();

        Thread hilo = new Thread(() -> {
            for(Promocion promo: promociones){
                Image i = new Image(App.class.getResource("/com/mycompany/Images/pin.png").toString());
                ImageView pin = new ImageView(i);
                pin.setFitHeight(50);
                pin.setFitWidth(50);
                pin.setEffect(new DropShadow());
                pin.setLayoutX(promo.getCoordenadaX());
                pin.setLayoutY(promo.getCoordenadaY());
                
                pin.setOnMouseClicked(e -> {
                    Stage stage = new Stage();
                    HBox root = new Popup().createPopup(promo, stage);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    Label id = (Label)root.lookup("#lbCerrando");
                    Timeline t = new Timeline(new KeyFrame(Duration.seconds(1),event ->{
                        id.setText("Cerrando en "+contador+" segundos...");
                        contador--;
                    }));
                    t.setCycleCount(6);
                    t.setOnFinished(event -> {
                        stage.close();
                        contador=5;
                    });
                    t.play();
                    
                });
                
                Platform.runLater(() -> {
                    conMapa.getChildren().add(pin);
                });
                
                int factor = (int) (Math.random() * 10);
                try {
                    Thread.sleep(factor*1000);
                } catch (InterruptedException ex) {
                }
                
            }
        });
        hilo.start();
    }
    
    private void leerDatosPromociones(){
        try(BufferedReader br = new BufferedReader(new FileReader("promociones.txt"))){
            br.readLine();
            String linea;
            
            while((linea = br.readLine())!=null){
                String[] datos = linea.trim().split(",");
                promociones.add(new Promocion(Double.parseDouble(datos[0]),Double.parseDouble(datos[1]),datos[3],datos[2],Double.parseDouble(datos[4])));
            }
        }catch(IOException e){}
    }
    
}
