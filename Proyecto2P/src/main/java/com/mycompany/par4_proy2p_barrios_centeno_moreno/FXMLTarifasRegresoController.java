/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Tarifa;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author LNV
 */
public class FXMLTarifasRegresoController implements Initializable {
  @FXML
    private Label nombretarifa;
    @FXML
    private Label S_carac1;
    @FXML
    private Label S_carac2;
    @FXML
    private ImageView S_image1;
    @FXML
    private ImageView S_image2;
    @FXML
    private Label M_carac1;
    @FXML
    private Label M_caarc2;
    @FXML
    private Label M_carac3;
    @FXML
    private Label M_carac4;
    @FXML
    private ImageView M_image1;
    @FXML
    private ImageView M_image2;
    @FXML
    private ImageView M_image3;
    @FXML
    private ImageView M_image4;
    @FXML
    private Label L_caract2;
    @FXML
    private Label L_carac1;
    @FXML
    private Label L_carac3;
    @FXML
    private Label L_carac4;
    @FXML
    private Label L_carac5;
    @FXML
    private ImageView L_image1;
    @FXML
    private ImageView L_image2;
    @FXML
    private ImageView L_image3;
    @FXML
    private ImageView L_image4;
    @FXML
    private ImageView L_image5;
    @FXML
    private Button mostarprecio1;
    @FXML
    private Button mostrarprecio2;
    @FXML
    private Button mostrarprecio3;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ArrayList<Tarifa> objetosTarifa=Tarifa.leerdatostarifa(App.pathachiInput+"tarifas.txt");
       S_carac1.setText( objetosTarifa.get(0).getListaofcarac().get(0));
       S_carac2.setText(objetosTarifa.get(0).getListaofcarac().get(1));
       //mostarprecio1.setText(String.valueOf(Tarifa.calcularpreciotarifa(v, objetosTarifa.get(0))));
       
       
       M_carac1.setText(objetosTarifa.get(1).getListaofcarac().get(0));
       M_caarc2.setText(objetosTarifa.get(1).getListaofcarac().get(1));
       M_carac3.setText(objetosTarifa.get(1).getListaofcarac().get(2));
       M_carac4.setText(objetosTarifa.get(1).getListaofcarac().get(3));
       //mostrarprecio2.setText(String.valueOf(Tarifa.calcularpreciotarifa(v, objetosTarifa.get(1))));
       
       
       L_carac1.setText(objetosTarifa.get(2).getListaofcarac().get(0));
       L_caract2.setText(objetosTarifa.get(2).getListaofcarac().get(1));
       L_carac3.setText(objetosTarifa.get(2).getListaofcarac().get(2));
       L_carac4.setText(objetosTarifa.get(2).getListaofcarac().get(3));
       L_carac5.setText(objetosTarifa.get(2).getListaofcarac().get(4));
       
    }  

    @FXML
    private void cambiarescna1(MouseEvent event) {
        try{
       App.setRoot("FXMLResumenreserva",200,300,null,null);
       }catch(IOException e){
           System.out.println(e.getMessage());
       }
    }

    @FXML
    private void cambiarescena2(MouseEvent event) {
       try{
        App.setRoot("FXMLResumenreserva",200,300,null,null);
       }catch(IOException e){
           System.out.println(e.getMessage());
       }
    }

    @FXML
    private void cambairescena3(MouseEvent event) {
         try{App.setRoot("FXMLResumenreserva",300,200,null,null);
       
       }catch(IOException e){
           System.out.println(e.getMessage());
       }
    }
    
    
}
