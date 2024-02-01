/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Tarifa;
import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Vuelo;
import static com.mycompany.par4_proy2p_barrios_centeno_moreno.FXMLTarifaVueloIdaController.tarifaSeleccionada;
import static com.mycompany.par4_proy2p_barrios_centeno_moreno.FXMLTarifaVueloIdaController.vueloSeleccionado;
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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author LNV
 */
public class FXMLTarifasRegresoController implements Initializable {
    
    
    @FXML
    private VBox idTvueloregreso;
    public static Vuelo vueloSeleccionado=FXMLReservaVueloIdaController.vChoice.get(1);
    
    public static Tarifa tarifaSeleccionada;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        ArrayList<Tarifa> tarifas = Tarifa.leerdatostarifa();
        for(Tarifa t : tarifas){
            idTvueloregreso.getChildren().add(crearSeccionTarifa(t));
        }
        System.out.println("Terminand de crear las tarifas");
        VBox coS = (VBox)idTvueloregreso.lookup("#coS");
        coS.setOnMouseClicked(e->{
            for(Tarifa t: tarifas){
                if("S".equals(t.getTipo())){
                    try {
                        tarifaSeleccionada = t;
                        App.setRoot("FXMLResumenreserva", 600, 800,"style.css", "Resumen de la reserva");
                    } catch (IOException ex) {
                    }
                } 
            }
        
        });
        VBox coM = (VBox)idTvueloregreso.lookup("#coM");
        
        coM.setOnMouseClicked(e->{
            for(Tarifa t: tarifas){
                if("M".equals(t.getTipo())){
                    try {
                        tarifaSeleccionada = t;
                        App.setRoot("FXMLResumenreserva", 600, 800, "style.css", "Resumen de la reserva");
                    } catch (IOException ex) {
                    }
                } 
            }
        
        });
        
        
        VBox coL = (VBox)idTvueloregreso.lookup("#coL");
        coL.setOnMouseClicked(e->{
            for(Tarifa t: tarifas){
                if("L".equals(t.getTipo())){
                    try {
                        tarifaSeleccionada = t;
                        App.setRoot("FXMLResumenreserva", 600, 400, "style.css", "Resumen de la reserva");
                    } catch (IOException ex) {
                    }
                } 
            }
        
        });
    }
    
    public VBox crearSeccionTarifa(Tarifa t){
      //recursos
      String[] nombreImagenes = {"equipajeMano.png","MILES.png","bodega.png","sentarse.png","calendario.png"};
      String precio= String.valueOf(vueloSeleccionado.getPrecio()+(vueloSeleccionado.getPrecio()*t.getPorcentaje())/100);
      //nodos
      Label lbTitulo = new Label(t.getTipo()+":"+t.getNombre());
      Label lbPrecio = new Label(precio);
      lbPrecio.setTextFill(Color.WHITE);
        //Labels para las caracteristicas
      
      ArrayList<Label> caracteristicas= new ArrayList();
      for(String caracteristica : t.getListaofcarac()){
          Label lb = new Label(caracteristica);
          caracteristicas.add(lb);
      }
        //images para las imagenes
      ArrayList<ImageView> imagenes = new ArrayList<>();
      for(int i = 0; i<t.getListaofcarac().size();i++){
          ImageView imagen=null;
          try(FileInputStream input=new FileInputStream(App.pathachiImage+nombreImagenes[i])){
          Image im=new Image(input);
          imagen=new ImageView(im);
          imagen.setFitHeight(25);
          imagen.setFitWidth(35);
          imagenes.add(imagen);  
          }catch(FileNotFoundException e1){
              System.out.println("No se ha encontrado la imagen");
          }
          catch(IOException e){
              System.out.println(e.getMessage());
          }
          
          
      }
        
      //contenedores
      
      HBox hbContenedorCaracteristicas = new HBox(); 
      hbContenedorCaracteristicas.setAlignment(Pos.CENTER_LEFT);
      hbContenedorCaracteristicas.setPadding(new Insets(0, 0, 0, 20));
      GridPane gp = new GridPane();
      gp.setVgap(10);
      gp.setHgap(20);
      
      for(int i = 0;i<t.getListaofcarac().size() ;i++){
          gp.add(imagenes.get(i), 0, i);
          gp.add(caracteristicas.get(i), 1, i);
      }
      hbContenedorCaracteristicas.getChildren().add(gp);
      HBox hbContenedorPrecio = new HBox();
      hbContenedorPrecio.setAlignment(Pos.CENTER);
      hbContenedorPrecio.setPrefWidth(1000);
      hbContenedorPrecio.setPrefHeight(300);
      hbContenedorPrecio.getChildren().add(lbPrecio);
      
      //root
      VBox hbContenedorPrincipal = new VBox();
      hbContenedorPrincipal.setAlignment(Pos.CENTER);
      hbContenedorPrincipal.getChildren().add(lbTitulo);
      hbContenedorPrincipal.getChildren().add(hbContenedorCaracteristicas);
      hbContenedorPrincipal.getChildren().add(hbContenedorPrecio);
      hbContenedorPrincipal.setSpacing(10);
      switch(t.getTipo()){
          case "S":
              hbContenedorPrincipal.setStyle("-fx-background-color: #E3EF9E");
              hbContenedorPrecio.setStyle("-fx-background-color: #2261BB");
              hbContenedorPrincipal.setId("coS");
              break;
          
          case "M":
              hbContenedorPrincipal.setStyle("-fx-background-color: #E3EF9E");
              hbContenedorPrecio.setStyle("-fx-background-color: #2261BB");
              hbContenedorPrincipal.setId("coM");
              break;
              
          case "L":
              hbContenedorPrincipal.setStyle("-fx-background-color: #E3EF9E");
              hbContenedorPrecio.setStyle("-fx-background-color: #2261BB");
              hbContenedorPrincipal.setId("coL");
              break; 
      }
      return hbContenedorPrincipal;  
    
    }
    
}
