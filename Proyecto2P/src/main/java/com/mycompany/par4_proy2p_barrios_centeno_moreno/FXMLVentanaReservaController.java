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
        
//        comboO.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                String choice1 = comboO.getValue();
//                choiceO.add(choice1);
//            }
//        });
    }
    
    static String choice2;
    static ArrayList<String> choiceO = new ArrayList<>();
    static ArrayList<String> choiceD = new ArrayList<>();
    static int numP;

    
    
    
    /**
     * Metodo buscar1 para el boton bbuscar que valida la seleccion del usuario y permite abrir la siguiente ventana.
     * @param e1 Objeto de tipo ActionEvent para establecer el evento al usar el button.
     * @throws IOException Excepcion que se lanza para el cambio de escena.
     */
    @FXML
    private void buscar1(ActionEvent e1) throws IOException{
        if (comboO.getValue() != null && comboD.getValue() != null){
          //App.setRoot("FXMLReservaVueloIda",400,600,"style2.css","Reserva tu vuelo");
          App.setRoot("FXMLReservaVueloIda",400,600,"style.css","Datos de los pasajeros");
          
        }else{
            validate.setText("Escoga una opcion");
            validate.setStyle("-fx-text-fill: red;");
        }
    }
    
 
    
    /**
     * Metodo Seleccion1 el cual guarda la variable de la seleccion del usuario en el comboBox y la agrega a la lista choiceO.
     * @param e3 Objeto de tipo ActionEvent para establecer el evento al usar el button.
     */
    @FXML
    public void seleccion1(ActionEvent e3){
        String choice1 = comboO.getValue();
        choiceO.add(choice1);  
    }
    
    
    
    /**
     * Metodo Seleccion1 e2 cual guarda la variable de la seleccion del usuario en el comboBox y la agrega a la lista choiceD.
     * @param e4 Objeto de tipo ActionEvent para establecer el evento al usar el button
     */
    @FXML
    public void seleccion2 (ActionEvent e4){
        choice2 = null;
        String choice2 = comboD.getValue();
        choiceD.add(choice2);
    }
    
    
    
    
    /**
     * Metodo ObtenerNumero para el objeto Spinner, el cual guarda en una variable statica el numero seleccionado por el usuario en dicho Spinner.
     */
    @FXML
    public void obtenerNumero(){
         //num.add(bcantidad.getValue());
         int selected1 = bcantidad.getValue();
         System.out.println(selected1);
         numP = selected1;
    }
    
    
    
    /**
     * Metodo obtenerFechaIda para el objeto DatePicker, el cual guarda en una variable statica la seleccion del usuario de la fecha de ida en dicho DatePicker.
     */
    @FXML
    public void obtenerFechaIda(){
        f1 = dp1.getValue();
    }
    
    
    /**
     * Metodo obtenerFechaRegreso para el objeto DatePicker, el cual guarda en una variable statica la seleccion del usuario de la fecha de regreso en dicho DatePicker.
     */
    @FXML
    public void obtenerFechaRegreso(){
        f2 = dp2.getValue();
    }
    
}
