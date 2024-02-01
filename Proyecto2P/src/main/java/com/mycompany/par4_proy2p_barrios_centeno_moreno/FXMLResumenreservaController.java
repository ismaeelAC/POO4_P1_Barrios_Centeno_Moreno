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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LNV
 */
public class FXMLResumenreservaController implements Initializable {

    @FXML
    private Label lbFechaIda;
    @FXML
    private Label lbRutaIda;
    @FXML
    private Label lbHoraIdaSalida;
    @FXML
    private Label lbDuracionIda;
    @FXML
    private Label lbPrecioIda;
    @FXML
    private Label lbHoraIdaLlegada;
    @FXML
    private Button btDetallesIda;
    @FXML
    private Label lbFechaRetorno;
    @FXML
    private Label lbRutaRetorno;
    @FXML
    private Label lbHoraRetornoSalida;
    @FXML
    private Label lbDuracionRetorno;
    @FXML
    private Label lbPrecioRetorno;
    @FXML
    private Label lbHoraRetornoLlegada;
    @FXML
    private Button btDetallesRetorno;
    @FXML
    private Label lbSumaPrecios;
    @FXML
    private Button btContinuar;
    
    public static double precioTotal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    Vuelo vueloIda=FXMLReservaVueloIdaController.vChoice.get(0);
        Vuelo vueloRetorno = FXMLReservaVueloIdaController.vChoice.get(1);
        
        //Datos de vuelo de ida
        String fechaIda = String.valueOf(FXMLVentanaReservaController.f1);
        lbFechaIda.setText("Vuelo de ida: "+fechaIda);
        
        String rutaIda = vueloIda.getOrigen()+" a "+vueloIda.getDestino();
        lbRutaIda.setText(rutaIda);
        
        String horaSalidaIda =String.valueOf( vueloIda.getHoraS());
        lbHoraIdaSalida.setText(horaSalidaIda);
        
        String duracionIda = String.valueOf(vueloIda.getDuracion());
        lbDuracionIda.setText(duracionIda);
        
        String precioIda = String.valueOf(vueloIda.getPrecio()+(vueloIda.getPrecio()*FXMLTarifaVueloIdaController.tarifaSeleccionada.getPorcentaje())/100);
        lbPrecioIda.setText(precioIda);//(vueloSeleccionado.getPrecio()+(vueloSeleccionado.getPrecio()*t.getPorcentaje())/100);
        
        String horaLlegadaIda = String.valueOf(vueloIda.getHoraL());
        lbHoraIdaLlegada.setText(horaLlegadaIda);
        
        
        //Datos de vuelo de retorno
        String fechaRetorno =String.valueOf(FXMLVentanaReservaController.f2);
        lbFechaRetorno.setText("Vuelo de retorno: "+fechaRetorno);
        
        String rutaRetorno = vueloRetorno.getOrigen()+" a "+vueloRetorno.getDestino();
        lbRutaRetorno.setText(rutaRetorno);
        
        String horaSalidaRetorno =String.valueOf( vueloRetorno.getHoraS());
        lbHoraRetornoSalida.setText(horaSalidaRetorno);
        
        String duracionRetorno = String.valueOf(vueloRetorno.getDuracion());
        lbDuracionRetorno.setText(duracionRetorno);
        
        String precioRetorno = String.valueOf(vueloRetorno.getPrecio() + (vueloRetorno.getPrecio() * FXMLTarifasRegresoController.tarifaSeleccionada.getPorcentaje()) / 100);

        lbPrecioRetorno.setText(precioRetorno);//String precioIda = 
        
        String horaLlegadaRetorno = String.valueOf(vueloRetorno.getHoraL());
        lbHoraRetornoLlegada.setText(horaLlegadaRetorno);
        
        //Calcular precio total por los dos vuelos
         precioTotal = FXMLTarifaVueloIdaController.precio+ FXMLTarifasRegresoController.precio;
        lbSumaPrecios.setText("Total de tu reserva: "+String.valueOf(precioTotal)+" USD");
        
        //Listeners para los 3 botones
        btDetallesIda.setOnAction(e->{
            crearDetalleVuelo(vueloIda, FXMLTarifaVueloIdaController.tarifaSeleccionada);
        });
        
        btDetallesRetorno.setOnAction(e->{
            crearDetalleVuelo(vueloRetorno, FXMLTarifasRegresoController.tarifaSeleccionada);
        });
        
        btContinuar.setOnAction(e->{
            try {
                App.setRoot("FXMLVentanaPasajeros",600,400,"style2.css","Datos personales");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
    }    
    
  /**
   * El método crearDetalleVuelo permite construir la escena que mostrará los detalles del fuelo, según el vuelo y la tarifa ingresados en los parámetros.
   * @param vuelo
   * @param t 
   */ 
   public void crearDetalleVuelo(Vuelo vuelo, Tarifa t){
        Stage stage = new Stage();
        
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        hBox.setSpacing(50.0);

        // VBox dentro de HBox
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefHeight(145.0);
        vBox.setPrefWidth(227.0);
        vBox.setSpacing(20.0);

        Label lbNumeroVuelo = new Label("Vuelo: "+vuelo.getNumVuelo());
        lbNumeroVuelo.setTextFill(javafx.scene.paint.Color.WHITE);
        lbNumeroVuelo.setFont(new Font("Calibri Bold", 30.0));

        Label lbTipoAvion = new Label(vuelo.getCodAvion());
        lbTipoAvion.setTextFill(javafx.scene.paint.Color.WHITE);
        lbTipoAvion.setFont(new Font("Calibri Bold", 30.0));

        Label lbTipoTarifa = new Label("Tarifa "+t.getTipo());
        lbTipoTarifa.setTextFill(javafx.scene.paint.Color.WHITE);
        lbTipoTarifa.setFont(new Font("Calibri Bold", 30.0));

        vBox.getChildren().addAll(lbNumeroVuelo, lbTipoAvion, lbTipoTarifa);

        
        ImageView imageView = null;
        try(FileInputStream input=new FileInputStream(App.pathachiImage+"icon_detalle.png")){
        Image im=new Image(input);
        imageView=new ImageView(im);
        imageView.setFitHeight(146.0);
        imageView.setFitWidth(232.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        
        }catch(FileNotFoundException e){
            System.out.println("No se ha encontrado la imagen");
        }catch(IOException e2){
            System.out.println(e2.getMessage());
        }
        /*imageView.setFitHeight(146.0);
        imageView.setFitWidth(232.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        Image image = new Image(App.pathachiImage+"icon_detalle.png");
        imageView.setImage(image);*/

        hBox.getChildren().addAll(vBox, imageView);

        
        Button btCerrar = new Button("Cerrar");
        btCerrar.setMnemonicParsing(false);
        btCerrar.setStyle("-fx-background-color: orange;");
        btCerrar.setFont(new Font("Arial Bold", 20.0));
        btCerrar.setOnAction(e->{stage.close();});
        HBox hb = new HBox(); 
        hb.getChildren().add(btCerrar);
        hb.setPadding(new Insets(0, 0, 0, 30.0));
        hb.setAlignment(Pos.CENTER_RIGHT);
        
        
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER_RIGHT);
        root.setStyle("-fx-background-color: #901A41;");
        root.getChildren().addAll(hBox,hb);
        
        
        stage.setScene(new Scene(root,650,450));
        stage.show();
    } 
    
    
        
}
