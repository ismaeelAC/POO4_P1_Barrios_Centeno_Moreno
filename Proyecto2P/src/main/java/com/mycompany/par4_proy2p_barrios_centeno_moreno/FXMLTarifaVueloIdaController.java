/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class FXMLTarifaVueloIdaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    Label lbSprecio;
    
    @FXML
    Label lbMprecio;
    
    @FXML
    Label lbLprecio;
    
    @FXML
    VBox coStarifa;
    
    @FXML
    VBox coMtarifa;
    
    @FXML
    VBox coLtarifa;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Double precioBase = OBJETOVUELO.getPrecio();
//        lbSprecio.setText(String.valueOf(precioBase));
//        lbMprecio.setText(String.valueOf(precioBase*1.15));
//        lbLprecio.setText(String.valueOf(precioBase*1.30));
//        
//        coStarifa.setOnMouseClicked(e ->{
//            Tarifa t = App.tarifas.get(0);
//            OBJETOVUELO.setTarifa(t);
//            App.setRoot("NOMBRE DE LA SIGUIENTE VENTANA");
//        });
//        
//        coMtarifa.setOnMouseClicked(e ->{
//            Tarifa t = App.tarifas.get(1);
//            OBJETOVUELO.setTarifa(t);
//            App.setRoot("NOMBRE DE LA SIGUIENTE VENTANA");
//        });
//        
//        coLtarifa.setOnMouseClicked(e ->{
//            Tarifa t = App.tarifas.get(2);
//            OBJETOVUELO.setTarifa(t);
//            App.setRoot("NOMBRE DE LA SIGUIENTE VENTANA");
//        });
    }    
    
}
