/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author rb122
 */
public class FXMLVentanaPasajerosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button buttonp;
    
    @FXML
    private GridPane rootV;
    
    @FXML
    private VBox vb0;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for (int i= 1; i<= FXMLVentanaReservaController.numP; i++){
        mostrarDatos(i);

        }
        ScrollPane sp = new ScrollPane();
        sp.setContent(vb0);
        sp.setFitToWidth(true);
        
        rootV.add(sp, 0, 1);
        vb0.setStyle("-fx-background-color: white;");
        
        
        
    }
    
    /**
     * Metodo MostrarDatos el cual de forma dinamica crea los bloques de registro de datos de pasajeros en base al numero de pasajeros que ingreso el usuario.
     * @param i Variable que guarda el numero de pasajeros que ingreso el usuario.
     */
    public void mostrarDatos(int i){
            Label lb =  new Label();
            vb0.getChildren().add(lb);
            lb.setText("Pasajero " + i );
            vb0.setSpacing(20);
            
            VBox vb = new VBox();
            HBox hb1 = new HBox();
            HBox hb2 = new HBox();
            vb.setAlignment(Pos.TOP_CENTER);
            
            hb1.setAlignment(Pos.CENTER);
            hb2.setAlignment(Pos.CENTER); 
            
            hb1.setSpacing(70);
            hb2.setSpacing(85);
            
            vb.setSpacing(15);

            //Por cada HBox
            HBox h1 = new HBox();
            HBox h2 = new HBox();
            HBox h3 = new HBox();
            HBox h4 = new HBox();
            
            TextField t1 =  new TextField();
            TextField t2 =  new TextField();
            TextField t3 =  new TextField();
            TextField t4 =  new TextField();
            
            h1.setAlignment(Pos.CENTER);
            h2.setAlignment(Pos.CENTER);
            h3.setAlignment(Pos.CENTER);
            h4.setAlignment(Pos.CENTER);
            
            //Datos
            Label lb1 = new Label();
            Label lb2 = new Label();
            Label lb3 = new Label();
            Label lb4 = new Label();
            
            
            h1.getChildren().addAll(lb1,t1);

            
            h2.getChildren().addAll(lb2,t2);

            
            h3.getChildren().addAll(lb3,t3);

            
            h4.getChildren().addAll(lb4,t4);

            
            
            
            lb1.prefWidth(80);
            lb2.prefWidth(80);
            lb3.prefWidth(80);
            lb4.prefWidth(80);
            
            lb1.setText("Nombre");
            lb2.setText("Pasaporte");
            lb3.setText("Apellido");
            lb4.setText("Correo");
            
            lb1.setAlignment(Pos.CENTER);
            lb2.setAlignment(Pos.CENTER);
            lb3.setAlignment(Pos.CENTER);
            lb4.setAlignment(Pos.CENTER);
            
            t1.setAlignment(Pos.CENTER);
            t2.setAlignment(Pos.CENTER);
            t3.setAlignment(Pos.CENTER);
            t4.setAlignment(Pos.CENTER);
     
            
            hb1.getChildren().addAll(h1, h2);
            hb2.getChildren().addAll(h3,h4);
            
            h1.setSpacing(15);
            h3.setSpacing(15);
            h2.setSpacing(15);
            h4.setSpacing(15);
            
            vb.getChildren().addAll(hb1, hb2);
            vb.setStyle("-fx-border-color: black; -fx-border-width: 5px; -fx-border-padding: 100px;");
            
            VBox.setMargin(hb1, new Insets(30,0,0,0));
            VBox.setMargin(hb2, new Insets(0,0,30,0));
            
            vb0.getChildren().add(vb);
            
            //VBox.setMargin(vb,new Insets(0,0,0,0));
}
    
    
    /**
     * Metodo continuar para el boton continuar que abre la siguiente ventana.
     * @param e Objeto de tipo ActionEvent para establecer el evento al usar el button.
     * @throws IOException Excepcion se le lanza para controlar la invocacion de una nueva ventana.
     */
    public void continuar(ActionEvent e) throws IOException{
        App.setRoot("FXMLPago", 501, 875, null, "ReservaPago");

    }
}    
    
    

