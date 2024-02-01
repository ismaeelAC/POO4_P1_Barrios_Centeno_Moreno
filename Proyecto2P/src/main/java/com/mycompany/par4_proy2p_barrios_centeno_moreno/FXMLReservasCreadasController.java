/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Thread t = new Thread(new Runnable(){
            @Override
            public void run(){
                mostrarReservas();
                do{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
               
                }while((App.cliente.size())>1); 
            }
        });
        t.start();
        
        ScrollPane sp = new ScrollPane();
        sp.setContent(vbox1);
        sp.setFitToWidth(true);
        
        g1.add(sp, 0, 1);
    }    
    
    
    public void mostrarReservas(){
        for (Cliente c : App.cliente){
            HBox h1 = new HBox();
            h1.prefHeight(30);
            h1.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-border-padding: 20px;");
            h1.setAlignment(Pos.CENTER);
            Label la1 = new Label();
            la1.setText(c.getNombre() + " " + c.getApellido());
            la1.setFont(new Font("Britannic bold",18));
            h1.getChildren().add(la1);
            vbox1.getChildren().add(h1);
            
            
        }
    }
}
