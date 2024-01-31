/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Vuelo;
import static com.mycompany.par4_proy2p_barrios_centeno_moreno.FXMLReservaVueloIdaController.datosV;
import static com.mycompany.par4_proy2p_barrios_centeno_moreno.FXMLReservaVueloIdaController.vChoice;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author rb122
 */
public class FXMLReservaVueloRegresoController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    @FXML
    private Label tituloR;
    
    @FXML
    private ComboBox<String> ordenarR;
    
    @FXML
    private VBox vboxR;
    
    @FXML
    private GridPane rootR;
    
    @FXML
    private Label novueloR;
            
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        int cantD = FXMLVentanaReservaController.choiceD.size();
        int cantO = FXMLVentanaReservaController.choiceD.size();
        
        if (!FXMLVentanaReservaController.choiceD.isEmpty() && !FXMLVentanaReservaController.choiceO.isEmpty()){
            tituloR.setText("Selecciona tu vuelo " + datosV.get(1) + " - " + datosV.get(0));
        }
        
        tituloR.setFont(new Font("Britannic bold",18));
        tituloR.setTextFill(Color.WHITE);
        ordenarR.getItems().setAll("Precio","Duracion");
        
        //Se muestran los datos del vuelo en la escena
        
        if(!FXMLReservaVueloIdaController.vRegreso.isEmpty()){
            mostrarOpciones2(FXMLReservaVueloIdaController.vRegreso);
        }else{
            Label l5 =  new Label();
            vboxR.getChildren().add(l5);
            VBox.setMargin(l5, new Insets(0,0,0,0)); 
            l5.setText("No se encontraron vuelos dispnibles");
            l5.setTextFill(Color.BLACK);
        }
        
            
               
        
        vboxR.setSpacing(10);
        vboxR.setPadding(new Insets(20,0,20,0));
        
        
        ScrollPane sp = new ScrollPane();
        sp.setContent(vboxR);
        sp.setFitToWidth(true);
        
        rootR.add(sp, 0, 2);
        vboxR.setStyle("-fx-background-color: white;");
        
    }
    
    
    
    /**
     * Metodo mostrarOpciones2 que crea de forma dinamica los bloques de los vuelos de regreso disponibles para el usuario.
     * @param listaV ArrayList que tipo Vuelo que contiene todos los vuelos de regreso para el usuario.
     */
    public void mostrarOpciones2(ArrayList<Vuelo> listaV){
        for (int i=0; i<listaV.size(); i++){
            final int index = i;
            VBox v1 = new VBox();
            HBox h1 = new HBox();
            Line n1 = new Line();
            
            //Variables de datos
            
            Label l1 = new Label();
            l1.setText("Duracion: " + listaV.get(i).getDuracion());
            
            Label l2 = new Label();
            l2.setText(String.valueOf((listaV.get(i).getPrecio())));
            
            Label l3 = new Label();
            l3.setText(listaV.get(i).getHoraS());
            
            Label l4 = new Label();
            l4.setText(listaV.get(i).getHoraL());
            
            l1.setTextFill(Color.BLACK);
            l2.setTextFill(Color.BLACK);
            l3.setTextFill(Color.BLACK);
            l4.setTextFill(Color.BLACK);
            
            n1.setStartX(0);
            n1.setEndX(200);
            n1.setStrokeWidth(2);
            n1.setStroke(Color.CYAN);
            
            h1.setAlignment(Pos.CENTER);
            v1.setAlignment(Pos.CENTER);
            v1.setSpacing(20);
            h1.setSpacing(20);
            
            v1.setStyle("-fx-border-color: cyan; -fx-border-width: 1px; -fx-border-padding: 100px;");
            VBox.setMargin(l1, new Insets(30,0,0,0));
            VBox.setMargin(l2, new Insets(0,0,30,0));     

            
            v1.setOnMouseClicked(event -> {
                vChoice.clear(); 
                vChoice.add(listaV.get(index));
                
                //Vuelo seleccionado
                try {
                    App.setRoot("FXMLTarifasRegreso",400,600,null,"Selecciona tu Tarifa de regreso");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            
            
            
            v1.getChildren().addAll(l1,h1,l2);
            h1.getChildren().addAll(l3,n1,l4);
            vboxR.getChildren().add(v1);      

        }
    }
    
    
    
    /**
     * Metodo OrdenarPrecioR el cual ordena el precio de los vuelos de regreso de menor a mayor.
     * @param listaV ArrayList que tipo Vuelo que contiene todos los vuelos de regreso para el usuario.
     */
    public void ordenarPrecioR(ArrayList<Vuelo> listaV){
        Collections.sort(listaV);
        mostrarOpciones2(listaV);
    }
    
    
    
    /**
     * Metodo OrdenarPrecioR el cual ordena la duracion de los vuelos de regreso de menor a mayor.
     * @param listaV ArrayList que tipo Vuelo que contiene todos los vuelos de regreso para el usuario.
     */
    public void ordenarDuracionR(ArrayList<Vuelo> listaV){
        Collections.sort(listaV,Vuelo::compareToD);
        mostrarOpciones2(listaV);
    }
    
    
    
    /**
     * Meotodo Opcion1 para el Combobox de las opciones ordenar, que verifica la seleccion del usuario y elige el metodo ordenar en base a eso.
     * @param e Objeto de tipo ActionEvent para establecer el evento al usar el button.
     */
    public void Opcion2(ActionEvent e){
        String choice = ordenarR.getValue();
        if (choice.equals("Precio")){
            vboxR.getChildren().clear();
            ordenarPrecioR(FXMLReservaVueloIdaController.vRegreso);
            
        }else if(choice.equals("Duracion")){
            vboxR.getChildren().clear();
            ordenarDuracionR(FXMLReservaVueloIdaController.vRegreso);
        }
    }
  
    
    
    
    
} 
    
   
    
    
