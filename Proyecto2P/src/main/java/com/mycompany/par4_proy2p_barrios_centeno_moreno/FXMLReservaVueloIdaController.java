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
public class FXMLReservaVueloIdaController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    @FXML
    private Label tituloI;
    
    @FXML
    private ComboBox<String> ordenarI;
    
    @FXML
    private VBox vboxI;
    
    @FXML
    private GridPane rootI;
    
    @FXML
    private Label novueloI;
            
    
    static ArrayList<Vuelo> vuelos = new ArrayList<>();
    static ArrayList<Vuelo> vIda = new ArrayList<>();
    static ArrayList<Vuelo> vRegreso = new ArrayList<>();
    static ArrayList<Vuelo> vChoice = new ArrayList<>();
    static ArrayList<String> datosV = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        int cantD = FXMLVentanaReservaController.choiceD.size();
        int cantO = FXMLVentanaReservaController.choiceO.size();
        
        if (!FXMLVentanaReservaController.choiceD.isEmpty() && !FXMLVentanaReservaController.choiceO.isEmpty()){
            datosV.add(FXMLVentanaReservaController.choiceO.get(cantO - 1));
            datosV.add(FXMLVentanaReservaController.choiceD.get(cantD - 1));
            tituloI.setText("Selecciona tu vuelo " + datosV.get(0) + " - " + datosV.get(1));
        }
        
        
        tituloI.setFont(new Font("Britannic bold",18));
        tituloI.setTextFill(Color.WHITE);
        ordenarI.getItems().setAll("Precio","Duracion");
        
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
        
        //Se agregan los vuelos de ida
        for (Vuelo v2 : vuelos){
            if (v2.getOrigen().equals(datosV.get(0)) && v2.getDestino().equals(datosV.get(1))){
                vIda.add(v2);
                validacion = true; 
            }
        }
        
        
        //Se muestran los datos del vuelo en la escena
        if(validacion){
            MostrarOpciones(vIda);
        }else{
            Label l5 =  new Label();
            vboxI.getChildren().add(l5);
            VBox.setMargin(l5, new Insets(0,0,0,0)); 
            l5.setText("No se encontraron vuelos dispnibles");
            l5.setTextFill(Color.BLACK);
        }
        
        
        //Se agregan los vuelos de regreso
        for(Vuelo v2: vuelos){
            if (v2.getOrigen().equals(datosV.get(1))&& v2.getDestino().equals(datosV.get(0))){
                vRegreso.add(v2);
            }
        }
        
        
        vboxI.setSpacing(10);
        vboxI.setPadding(new Insets(20,0,20,0));
        
        
        ScrollPane sp = new ScrollPane();
        sp.setContent(vboxI);
        sp.setFitToWidth(true);
        
        rootI.add(sp, 0, 2);
        vboxI.setStyle("-fx-background-color: white;");
        
    }
    
    
    public void MostrarOpciones(ArrayList<Vuelo> listaV){
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
                System.out.println(vChoice);
                try {
                    App.setRoot("FXMLReservaVueloRegreso",400,600,"style2.css","Reserva tu vuelo de regreso");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            
            });
            
            v1.getChildren().addAll(l1,h1,l2);
            h1.getChildren().addAll(l3,n1,l4);
            vboxI.getChildren().add(v1);      

        }
    }
    
    
    public void ordenarPrecio(ArrayList<Vuelo> listaV){
        Collections.sort(listaV);
        MostrarOpciones(listaV);
    }
    
    public void ordenarDuracion(ArrayList<Vuelo> listaV){
        Collections.sort(listaV,Vuelo::compareToD);
        MostrarOpciones(listaV);
    }
    
    public void Opcion1(ActionEvent e){
        String choice = ordenarI.getValue();
        if (choice.equals("Precio")){
            vboxI.getChildren().clear();
            ordenarPrecio(vIda);
            
        }else if(choice.equals("Duracion")){
            vboxI.getChildren().clear();
            ordenarDuracion(vIda);
        }
        
    }
    
} 
    
   
    
    
