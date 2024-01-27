/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LNV
 */
public class FXMLResumenreservaController implements Initializable {

    @FXML
    private Label vueloifecha;
    @FXML
    private Label origendestino1;
    @FXML
    private Label duracionvi;
    @FXML
    private Label horainicio;
    @FXML
    private Label horallegada;
    @FXML
    private Label preciovueloi;
    @FXML
    private Button btndetallevueloi;
    @FXML
    private Label vueloregresofecha;
    @FXML
    private Label origendestino2;
    @FXML
    private Label duracionvR;
    @FXML
    private Label horainicio2;
    @FXML
    private Label horallegada2;
    @FXML
    private Label preciovueloR;
    @FXML
    private Button btndetallevueloR;
    @FXML
    private Label preciotoalf;
    @FXML
    private Button btncontinuar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mostrarddetallevueloi(ActionEvent event) {
        Stage ste=new Stage();
        VBox root=new VBox();
        HBox hbo=new HBox();
        VBox boxlabels=new VBox();
        Label l1=new Label("Hola");
        Label l2=new Label("mundo");
        Label l3=new Label("JAVA");
        ImageView imgv=null;
        try(FileInputStream input=new FileInputStream(App.pathachiImage)){
        Image im=new Image(input);
        imgv=new ImageView(im);
        }catch(FileNotFoundException e1){
         System.out.println("No se ha encontrado la imagen");   
        }catch(IOException e2){
         System.out.println(e2.getMessage());   
        }
        Button btn2=new Button("Cerrar");
        btn2.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e21){
        Stage stg=(Stage)btn2.getScene().getWindow();
        stg.close();
        }
         });
        l1.setTextFill(Color.BLACK);
        l2.setTextFill(Color.BLACK);
        l3.setTextFill(Color.BLACK);
        boxlabels.setSpacing(20);
        boxlabels.getChildren().addAll(l1,l2,l3);
        hbo.setSpacing(20);
        hbo.getChildren().addAll(boxlabels,imgv);
        root.getChildren().addAll(hbo,btn2);
        Scene sc=new Scene(root,300,500);
        ste.setTitle("Detalles del vuelo");
        ste.setScene(sc);
        ste.show();
       
   }
        

    @FXML
    private void mostrarddetallevueloR(ActionEvent event) {
     Stage ste=new Stage();
        VBox root=new VBox();
        HBox hbo=new HBox();
        VBox boxlabels=new VBox();
        Label l1=new Label("Hola");
        Label l2=new Label("mundo");
        Label l3=new Label("JAVA");
        ImageView imgv=null;
        try(FileInputStream input=new FileInputStream(App.pathachiImage)){
        Image im=new Image(input);
        imgv=new ImageView(im);
        }catch(FileNotFoundException e1){
         System.out.println("No se ha encontrado la imagen");   
        }catch(IOException e2){
         System.out.println(e2.getMessage());   
        }
        Button btn2=new Button("Cerrar");
        btn2.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent e21){
        Stage stg=(Stage)btn2.getScene().getWindow();
        stg.close();
        }
         });
        l1.setTextFill(Color.BLACK);
        l2.setTextFill(Color.BLACK);
        l3.setTextFill(Color.BLACK);
        boxlabels.setSpacing(20);
        boxlabels.getChildren().addAll(l1,l2,l3);
        hbo.setSpacing(20);
        hbo.getChildren().addAll(boxlabels,imgv);
        root.getChildren().addAll(hbo,btn2);
        Scene sc=new Scene(root,300,500);
        ste.setTitle("Detalles del vuelo");
        ste.setScene(sc);
        ste.show();
       
    
    
    
    }
    

    @FXML
    private void continuar(ActionEvent event) {
    
    
    
    }
    
    
    
}
