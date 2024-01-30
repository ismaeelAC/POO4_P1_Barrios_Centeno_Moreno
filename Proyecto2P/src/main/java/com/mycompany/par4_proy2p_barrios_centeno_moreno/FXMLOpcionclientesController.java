/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author LNV
 */
public class FXMLOpcionclientesController implements Initializable {


    /**
     * Initializes the controller class.
     * 
     */
 
     @FXML
     private Label ltitulo;
     
     @FXML
     private Button b1;
     
     @FXML
     private Button b2;
 
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ltitulo.setText("¡Hola " + App.cliente.get(0).getNombre()+ "!");
          ltitulo.setFont(new Font("Britannic bold",45));
          ltitulo.setTextFill(Color.WHITE);

        
        }    
    
    @FXML
    public void abrirReserva() throws IOException{
        App.setRoot("FXMLVentanaReserva",600,400,"style.css","VentanasOpciones");
    }
    
    
    
}
