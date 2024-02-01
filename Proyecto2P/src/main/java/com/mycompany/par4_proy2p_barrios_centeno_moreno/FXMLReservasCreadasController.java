/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rb122
 */
public class FXMLReservasCreadasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    GridPane g1;
    
    @FXML
    VBox vbox1;
    
    static String codigo1;
    String codigoReserva = FXMLPagoController.numeroReserva;
    public static Stage stage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarReservas();
        
        mostrarReservas();
        Thread actualizarReservasThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000); // Esperar 5 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Platform.runLater(() -> {

                    vbox1.getChildren().clear();
                    mostrarReservas(); 
                });
            }
        });

        actualizarReservasThread.start();
    

        
        ScrollPane sp = new ScrollPane();
        sp.setContent(vbox1);
        sp.setFitToWidth(true);
        
        g1.add(sp, 0, 1);
    }    
    
    /**
     * Muestra el nombre del usuario que ya hizo una reserva.
     */
    public void mostrarReservas() {
    for (Cliente c : App.cliente) {
        if (codigo1 != null && !codigo1.isEmpty()) {
            HBox h1 = new HBox();
            h1.prefHeight(30);
            h1.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-border-padding: 20px;");
            h1.setAlignment(Pos.CENTER);
            Label la1 = new Label();
            la1.setText(codigo1 + " - " + c.getNombre() + " " + c.getApellido());
            la1.setFont(new Font("Britannic bold", 18));
            h1.getChildren().add(la1);
            vbox1.getChildren().add(h1);
        }
    }
}
}
