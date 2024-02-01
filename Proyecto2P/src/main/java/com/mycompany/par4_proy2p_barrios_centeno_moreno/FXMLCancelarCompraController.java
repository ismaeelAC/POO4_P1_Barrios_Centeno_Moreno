/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author grilsemo
 */
public class FXMLCancelarCompraController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    Button btSi;
    
    public static Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btSi.setOnAction(e->{
            stage.close();
            try {
                App.setRoot("FXMLOpcionclientes", 600, 400, null, "Bienvenido");
            } catch (IOException ex) {
            }
        });
    }    
    
}
