/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Destinos;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author rb122
 */
public class FXMLVentanaReservaController implements Initializable {
    
    static String choice1;
    
    @FXML
    private ComboBox<String> comboO;
    
    @FXML
    private ComboBox<String> comboD;
    
    @FXML
    private Button bbuscar;
    
    @FXML
    private DatePicker dp1;
    
    @FXML
    private DatePicker dp2;
    
    @FXML
    private Spinner<Integer> bcantidad;
    SpinnerValueFactory<Integer> sp = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,30);
    
    @FXML
    private Label label1;
    
    @FXML
    private Label validate;
    
    static LocalDate f1;
    static LocalDate f2;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bcantidad.setValueFactory(sp);
        comboO.getItems().setAll("Guayaquil","Quito","Cuenca");
        
        ArrayList<Destinos> listaD = new ArrayList<>();
        
        
        
        try(BufferedReader bf = new BufferedReader(new FileReader("destinos.txt"))){
            String line;
            while((line = bf.readLine()) != null){
                String datosD[] = line.split(",");
                String city = datosD[0];
                String country = datosD[1];
                
                Destinos d1 = new Destinos(datosD[0],datosD[1]);
                listaD.add(d1);
            }
        }catch(FileNotFoundException e){
            System.out.println("no se encontro el archivo");
            
        }catch(IOException e1){
            System.out.println("No se puedo leer el archivo");
        }
        
        for (Destinos d1:listaD){
            String city1 = d1.getCiudad();
            comboD.getItems().add(city1);
        }
        
        comboO.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String choice1 = comboO.getValue();
                choiceO.add(choice1);
            }
        });
    }
    
    @FXML
    private void buscar1(ActionEvent e1) throws IOException{
        if (comboO.getValue() != null && comboD.getValue() != null){
          //App.setRoot("FXMLReservaVueloIda",400,600,"style2.css","Reserva tu vuelo");
          App.setRoot("FXMLVentanaPasajeros",600,400,null,"Datos de los pasajeros");
        }
        else{
            validate.setText("Escoga una opcion");
            validate.setStyle("-fx-text-fill: red;");
        }
        
    }
    static String choice2;
    static ArrayList<String> choiceO = new ArrayList<>();
    static ArrayList<String> choiceD = new ArrayList<>();
    static int numP;
    
    
//    public void seleccion1(ActionEvent e3){
//        String choice1 = comboO.getValue();
//        choiceO.add(choice1);
//        
//    }
    
    @FXML
    public void seleccion2 (ActionEvent e4) throws IOException{
        choice2 = null;
        String choice2 = comboD.getValue();
        choiceD.add(choice2);
    }
    
    @FXML
    public void obtenerNumero(){
         //num.add(bcantidad.getValue());
         int selected1 = bcantidad.getValue();
         System.out.println(selected1);
         numP = selected1;
    }
    
    @FXML
    public void obtenerFechaIda(){
        f1 = dp1.getValue();
    }
    
    @FXML
    public void obtenerFechaRegreso(){
        f2 = dp2.getValue();
    }
    
}
