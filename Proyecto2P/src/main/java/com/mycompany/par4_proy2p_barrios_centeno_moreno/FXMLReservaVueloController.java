/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Vuelo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import javafx.scene.control.ScrollBar;
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
public class FXMLReservaVueloController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    @FXML
    private Label titulo2;
    
    @FXML
    private ComboBox<String> ordenar;
    
    @FXML
    private VBox vbox1;
    
    @FXML
    private GridPane root3;
    
    @FXML
    private Label novuelo;
            
    
    ArrayList<Vuelo> vuelos = new ArrayList<>();
    ArrayList<Vuelo> vueloSelect = new ArrayList<>();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        titulo2.setText("Selecciona tu vuelo " + FXMLVentanaReservaController.choiceO.get(0) + " - " + FXMLVentanaReservaController.choiceD.get(0));
        titulo2.setFont(new Font("Britannic bold",18));
        titulo2.setTextFill(Color.WHITE);
        ordenar.getItems().setAll("Precio","Duracion");
        
        try(BufferedReader br = new BufferedReader(new FileReader("vuelos.txt"))){
            String line1;
            br.readLine();
            while((line1=br.readLine())!= null){
                String datosV [] = line1.split(",");
                String numero = datosV[0];
                String origen1 = datosV[1];
                String destino1 = datosV[2];
                String duracion = datosV[3];
                String salida = datosV[4];
                String llegada = datosV[5];
                String codigo = datosV[6];
                Double precio = Double.valueOf(datosV[7]);
                
                Vuelo v1 = new Vuelo(origen1, destino1, duracion, salida, llegada, numero, codigo, precio);
                vuelos.add(v1);
            }    
        }catch(FileNotFoundException e4){
            System.out.println("No se pudo leer el txt");   
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        Boolean validacion = false;
        
        for (Vuelo v2 : vuelos){
            if (v2.getOrigen().equals(FXMLVentanaReservaController.choiceO.get(0)) && v2.getDestino().equals(FXMLVentanaReservaController.choiceD.get(0))){
                vueloSelect.add(v2);
                validacion = true;  
            } 
        }
        
        if(validacion){
            MostrarOpciones(vueloSelect);
        }else{
            Label l5 =  new Label();
            vbox1.getChildren().add(l5);
            VBox.setMargin(l5, new Insets(0,0,0,0)); 
            l5.setText("No se encontraron vuelos dispnibles");
            l5.setTextFill(Color.BLACK);
        }
         
        
        vbox1.setSpacing(10);
        vbox1.setPadding(new Insets(20,0,20,0));
        
        
        ScrollPane sp = new ScrollPane();
        sp.setContent(vbox1);
        sp.setFitToWidth(true);
        
        root3.add(sp, 0, 2);
        vbox1.setStyle("-fx-background-color: white;");
        
        
    }
    
    
    public void MostrarOpciones(ArrayList<Vuelo> listaV){
        for (int i=0; i<listaV.size(); i++){
            final int index = i;
            VBox v1 = new VBox();
            HBox h1 = new HBox();
            Line n1 = new Line();
            
            Label l1 = new Label();
            l1.setText("Duracion: " + vueloSelect.get(i).getDuracion());
            
            Label l2 = new Label();
            l2.setText(String.valueOf((vueloSelect.get(i).getPrecio())));
            
            Label l3 = new Label();
            l3.setText(vueloSelect.get(i).getHoraS());
            
            Label l4 = new Label();
            l4.setText(vueloSelect.get(i).getHoraL());
            
            l1.setTextFill(Color.BLACK);
            l2.setTextFill(Color.BLACK);
            l3.setTextFill(Color.BLACK);
            l4.setTextFill(Color.BLACK);
            
            n1.setStartX(0);
            n1.setEndX(200);
            n1.setStrokeWidth(2);
            n1.setStroke(Color.GOLD);
            
            h1.setAlignment(Pos.CENTER);
            v1.setAlignment(Pos.CENTER);
            v1.setSpacing(20);
            h1.setSpacing(20);
            
            v1.setStyle("-fx-border-color: gold; -fx-border-width: 1px; -fx-border-padding: 100px;");
            VBox.setMargin(l1, new Insets(30,0,0,0));
            VBox.setMargin(l2, new Insets(0,0,30,0));     

            v1.setOnMouseClicked(event -> {
                System.out.println("Clic en el bloque " + index);
                v1.setStyle("-fx-border-color: gold; -fx-border-width: 5px; -fx-border-padding: 100px;");
            });
            
            v1.getChildren().addAll(l1,h1,l2);
            h1.getChildren().addAll(l3,n1,l4);
            vbox1.getChildren().add(v1);
            
        }
    }
    
    public void ordenarPrecio(){
        Collections.sort(vueloSelect);
        MostrarOpciones(vueloSelect);
    }
    
    public void ordenarDuracion(){
        Collections.sort(vueloSelect,Vuelo::compareToD);
        MostrarOpciones(vueloSelect);
    }
    
    public void Opcion1(ActionEvent e){
        String choice = ordenar.getValue();
        if (choice.equals("Precio")){
            vbox1.getChildren().clear();
            ordenarPrecio();
            
        }else if(choice.equals("Duracion")){
            vbox1.getChildren().clear();
            ordenarDuracion();
        }
        
    }
    
} 
    
   
    
    
