/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Tarifa;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
    private Button mostarprecio1;
    @FXML
    private Button mostrarprecio2;
    @FXML
    private Label nombret1;
    @FXML
    private Label Scarc1;
    @FXML
    private Label Scarac2;
    @FXML
    private ImageView Simage1;
    @FXML
    private ImageView Simage2;
    @FXML
    private Label nombret2;
    @FXML
    private ImageView Mimage1;
    @FXML
    private ImageView Mimage2;
    @FXML
    private ImageView Mimage3;
    @FXML
    private ImageView Mimage4;
    @FXML
    private Label Mcarac1;
    @FXML
    private Label Mcarac2;
    @FXML
    private Label Mcarac3;
    @FXML
    private Label Mcarac4;
    @FXML
    private Label nombret3;
    @FXML
    private Label Lcarac1;
    @FXML
    private Label Lcarac2;
    @FXML
    private Label Lcarac3;
    @FXML
    private Label Lcarac4;
    @FXML
    private Label Lcarac5;
    @FXML
    private ImageView Limage1;
    @FXML
    private ImageView Limage2;
    @FXML
    private ImageView Limage3;
    @FXML
    private ImageView Limage4;
    @FXML
    private ImageView Limage5;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ArrayList<Tarifa> objetosTarifa=Tarifa.leerdatostarifa(App.pathachiInput+"tarifas.txt");
       Scarc1.setText( objetosTarifa.get(0).getListaofcarac().get(0));
       Scarac2.setText(objetosTarifa.get(0).getListaofcarac().get(1));
       //mostarprecio1.setText(String.valueOf(Tarifa.calcularpreciotarifa(v, objetosTarifa.get(0))));
       try(FileInputStream input=new FileInputStream(App.pathachiImage+"equipajeMano.png")){
       Image im=new Image(input);
       Simage1.setImage(im);
       }catch(FileNotFoundException e){
           System.out.println("No se ha encontrado la imagen");
       }catch(IOException e2){
           System.out.println(e2.getMessage());
       }
       try(FileInputStream input=new FileInputStream(App.pathachiImage+"MILES.png")){
       Image im=new Image(input);
       Simage2.setImage(im);
       }catch(FileNotFoundException e){
           System.out.println("No se ha encontrado la imagen");
       }catch(IOException e2){
           System.out.println(e2.getMessage());
       }
       
       
       Mcarac1.setText(objetosTarifa.get(1).getListaofcarac().get(0));
       Mcarac2.setText(objetosTarifa.get(1).getListaofcarac().get(1));
       Mcarac3.setText(objetosTarifa.get(1).getListaofcarac().get(2));
       Mcarac4.setText(objetosTarifa.get(1).getListaofcarac().get(3));
       //mostrarprecio2.setText(String.valueOf(Tarifa.calcularpreciotarifa(v, objetosTarifa.get(1))));
       try(FileInputStream input=new FileInputStream(App.pathachiImage+"equipajeMano.png")){
       Image im=new Image(input);
       Mimage1.setImage(im);
       }catch(FileNotFoundException e){
           System.out.println("No se ha encontrado la imagen");
       }catch(IOException e2){
           System.out.println(e2.getMessage());
       }
       
       try(FileInputStream input=new FileInputStream(App.pathachiImage+"MILES.png")){
       Image im=new Image(input);
       Mimage2.setImage(im);
       }catch(FileNotFoundException e){
           System.out.println("No se ha encontrado la imagen");
       }catch(IOException e2){
           System.out.println(e2.getMessage());
       }
       
       try(FileInputStream input=new FileInputStream(App.pathachiImage+"bodega.png")){
       Image im=new Image(input);
       Mimage3.setImage(im);
       }catch(FileNotFoundException e){
           System.out.println("No se ha encontrado la imagen");
       }catch(IOException e2){
           System.out.println(e2.getMessage());
       }
       try(FileInputStream input=new FileInputStream(App.pathachiImage+"sentarse.png")){
       Image im=new Image(input);
       Mimage4.setImage(im);
       }catch(FileNotFoundException e){
           System.out.println("No se ha encontrado la imagen");
       }catch(IOException e2){
           System.out.println(e2.getMessage());
       }
       
 
       Lcarac1.setText(objetosTarifa.get(2).getListaofcarac().get(0));
       Lcarac2.setText(objetosTarifa.get(2).getListaofcarac().get(1));
       Lcarac3.setText(objetosTarifa.get(2).getListaofcarac().get(2));
       Lcarac4.setText(objetosTarifa.get(2).getListaofcarac().get(3));
       Lcarac5.setText(objetosTarifa.get(2).getListaofcarac().get(4));
       
       try(FileInputStream input=new FileInputStream(App.pathachiImage+"equipajeMano.png")){
       Image im=new Image(input);
       Limage1.setImage(im);
       }catch(FileNotFoundException e){
           System.out.println("No se ha encontrado la imagen");
       }catch(IOException e2){
           System.out.println(e2.getMessage());
       }
       
       try(FileInputStream input=new FileInputStream(App.pathachiImage+"MILES.png")){
       Image im=new Image(input);
       Limage2.setImage(im);
       }catch(FileNotFoundException e){
           System.out.println("No se ha encontrado la imagen");
       }catch(IOException e2){
           System.out.println(e2.getMessage());
       }
       
       try(FileInputStream input=new FileInputStream(App.pathachiImage+"bodega.png")){
       Image im=new Image(input);
       Limage3.setImage(im);
       }catch(FileNotFoundException e){
           System.out.println("No se ha encontrado la imagen");
       }catch(IOException e2){
           System.out.println(e2.getMessage());
       }
       try(FileInputStream input=new FileInputStream(App.pathachiImage+"sentarse.png")){
       Image im=new Image(input);
       Limage4.setImage(im);
       }catch(FileNotFoundException e){
           System.out.println("No se ha encontrado la imagen");
       }catch(IOException e2){
           System.out.println(e2.getMessage());
       }
       
       
    }  

    @FXML
    private void cambiar3scena1(ActionEvent event) {
        try{
        App.setRoot("FXMLResumenreserva",200,300,null,null);
       }catch(IOException e){
           System.out.println(e.getMessage());
       }
    }

    @FXML
    private void cambiar3scena2(ActionEvent event) {
        try{App.setRoot("FXMLResumenreserva",300,200,null,null);
       
       }catch(IOException e){
           System.out.println(e.getMessage());
       }
    }

    @FXML
    private void cambiar3scena3(ActionEvent event) {
        try{App.setRoot("FXMLResumenreserva",300,200,null,null);
       
       }catch(IOException e){
           System.out.println(e.getMessage());
       }
    }
    
    
}
