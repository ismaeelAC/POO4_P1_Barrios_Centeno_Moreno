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
    
    
    public static ArrayList<Promocion> promociones = new ArrayList<>();
    
    private static int contador = 5;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        leerDatosPromociones();

        Thread hilo = new Thread(() -> {
            for(Promocion promo: promociones){
                Image i = new Image(App.class.getResource("/com/mycompany/Images/pin.png").toString());
                ImageView pin = new ImageView(i);
                pin.setFitHeight(50);
                pin.setFitWidth(50);
                pin.setEffect(new DropShadow());//efecto de sombra al pin
                pin.setLayoutX(promo.getCoordenadaX());
                pin.setLayoutY(promo.getCoordenadaY());
                
                
                
                pin.setOnMouseClicked(e -> {
                    Stage ventanaPopUp = new Stage();
                    HBox root = new Popup().createPopup(promo, ventanaPopUp);
                    Scene escena = new Scene(root);
                    ventanaPopUp.setScene(escena);
                    ventanaPopUp.show();
                    //KeyFrame objeto que permite definir eventos controlados por tiempo
                
                    KeyFrame k = new KeyFrame(Duration.seconds(1),event->{

                        //se intento usar Thread.sleep para manejar tiempo pero lastimosamente su uso causa
                        //que el FX Application Thread se bloquee lo cual ocaciona que la ventana este en blanco
                        //y no muestre los nodos
                        Label cerrandoEn = (Label)root.lookup("#lbCerrando");
                        Platform.runLater(()->{
                                cerrandoEn.setText("Cerrando en "+FXMLVentanaPromocionesController.contador+ " segundos...");
                            });
                        FXMLVentanaPromocionesController.contador--;
                    });
                    //Timeline: linea de tiempo donde se sincroniza los keyFrames
                    Timeline lineaDeTiempo = new Timeline(k);
                    lineaDeTiempo.setCycleCount(6); //veces que el KeyFrame se ejecutara en la linea del tiempo
                    lineaDeTiempo.setOnFinished(event->{ //cuando la linea de tiempo llegue a su final
                        ventanaPopUp.close(); 
                        FXMLVentanaPromocionesController.contador=5;
                    });
                    
                    lineaDeTiempo.play();
                    
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
