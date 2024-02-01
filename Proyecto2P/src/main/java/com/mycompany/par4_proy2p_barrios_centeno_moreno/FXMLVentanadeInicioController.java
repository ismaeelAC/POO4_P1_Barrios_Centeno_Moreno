/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Cliente;
import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Tarifa;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author LNV
 */
public class FXMLVentanadeInicioController implements Initializable {

    @FXML
    private TextField datuser;
    @FXML
    private TextField datpassword;
    @FXML
    private Button login;
    @FXML
    private Label confirmacceso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ingresar(ActionEvent event) {
        App.cliente= new ArrayList<>();
       
        try(BufferedReader bf=new BufferedReader(new FileReader(App.pathachiInput+"clientes.txt"))){
        bf.readLine();
        String linea;
        boolean acceso=false;
        while((linea=bf.readLine())!=null){
        String[] datsachi=linea.split(",");
        if(datsachi[3].equals(datuser.getText()) && (datsachi[4]).equals(datpassword.getText())){
         acceso=true;
         Cliente c1=new Cliente(datsachi[0],datsachi[1],datsachi[2],datsachi[3],datsachi[4]);
         App.cliente.add(c1);
         break;
        }       
     }
        if(acceso){
        App.setRoot("FXMLVentanaReserva",600,400,"style.css","VentanasOpciones");
        }
        else{
        confirmacceso.setText("Por favor, ingrese correctamente sus datos");
       }
   }
    catch(IOException e){
            System.out.println("No se ha encontrado el archivo");
        }
        
    }
}
