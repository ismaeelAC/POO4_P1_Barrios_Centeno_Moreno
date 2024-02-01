/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author angel
 */
public class FXMLConfirmacionCompraController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private Label lbCerrando;

    @FXML
    private Label lbReserva;
    
    @FXML
    private Button btAceptar;
    
    private int contador=4;
    
    public static Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbReserva.setText("Reserva: "+FXMLPagoController.numeroReserva);
        btAceptar.setOnAction(e->{
            try {
                App.setRoot("FXMLOpcionclientes", 600, 400, null, "Bienvenido");
            } catch (IOException ex) {
            }
            stage.close();
        });
        KeyFrame k = new KeyFrame(Duration.seconds(1),event->{
            Platform.runLater(()->{
                lbCerrando.setText("Ventana cerrando en "+contador+" segundos...");
                contador--;
            });
        });
        Timeline lineaTiempo = new Timeline(k);
        lineaTiempo.setCycleCount(6);
        lineaTiempo.setOnFinished(event->{
            try {
                App.setRoot("FXMLOpcionclientes", 600, 400, null, "Bienvenido");
            } catch (IOException ex) {
            }
            stage.close();
        });
        lineaTiempo.play();
    }    
    
}
