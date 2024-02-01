/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;


import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Tarifa;
import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Vuelo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author grilsemo
 */
public class FXMLTarifaVueloIdaController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    VBox coVentana;

   public static Vuelo vueloSeleccionado = FXMLReservaVueloIdaController.vChoice.get(0);
    
    public static Tarifa tarifaSeleccionada;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ArrayList<Tarifa> tarifas = Tarifa.leerdatostarifa();
        for(Tarifa t : tarifas){
            coVentana.getChildren().add(crearSeccionTarifa(t));
        }
        System.out.println("Terminand de crear las tarifas");
        VBox coS = (VBox)coVentana.lookup("#coS");
        coS.setOnMouseClicked(e->{
            for(Tarifa t: tarifas){
                if("S".equals(t.getTipo())){
                    try {
                        tarifaSeleccionada = t;
                        App.setRoot("FXMLReservaVueloRegreso", 600, 400, null, "Reserva tu vuelo de regreso");
                    } catch (IOException ex) {
                    }
                } 
            }
        
        });
        VBox coM = (VBox)coVentana.lookup("#coM");
        
        coM.setOnMouseClicked(e->{
            for(Tarifa t: tarifas){
                if("M".equals(t.getTipo())){
                    try {
                        tarifaSeleccionada = t;
                        App.setRoot("FXMLReservaVueloRegreso", 600, 400, null, "Reserva tu vuelo de regreso");
                    } catch (IOException ex) {
                    }
                } 
            }
        
        });
        
        
        VBox coL = (VBox)coVentana.lookup("#coL");
        coL.setOnMouseClicked(e->{
            for(Tarifa t: tarifas){
                if("L".equals(t.getTipo())){
                    try {
                        tarifaSeleccionada = t;
                        App.setRoot("FXMLReservaVueloRegreso", 600, 400, null, "Reserva tu vuelo de regreso");
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
          imagen.setFitHeight(50);
          imagen.setFitWidth(50);
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
      GridPane gp = new GridPane();
      gp.setVgap(10);
      gp.setHgap(20);
      
      for(int i = 0;i<t.getListaofcarac().size() ;i++){
          gp.add(imagenes.get(i), 0, i);
          gp.add(caracteristicas.get(i), 1, i);
      }
      hbContenedorCaracteristicas.getChildren().add(gp);
      HBox hbContenedorPrecio = new HBox();
      
      //root
      VBox hbContenedorPrincipal = new VBox();
      hbContenedorPrincipal.setAlignment(Pos.CENTER);
      hbContenedorPrincipal.getChildren().add(lbTitulo);
      hbContenedorPrincipal.getChildren().add(hbContenedorCaracteristicas);
      hbContenedorPrincipal.getChildren().add(lbPrecio);
      hbContenedorPrincipal.setSpacing(20);
      switch(t.getTipo()){
          case "S":
              hbContenedorPrincipal.setStyle("-fx-background-color: #f99b2a");
              hbContenedorPrincipal.setId("coS");
              break;
          
          case "M":
              hbContenedorPrincipal.setStyle("-fx-background-color: #F15A3A");
              hbContenedorPrincipal.setId("coM");
              break;
              
          case "L":
          
              hbContenedorPrincipal.setStyle("-fx-background-color: #EE3184");
              hbContenedorPrincipal.setId("coL");
              break; 
      }
      return hbContenedorPrincipal;
  }  
    
}
