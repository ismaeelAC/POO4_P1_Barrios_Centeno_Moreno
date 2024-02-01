/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Cliente;
import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Pago;
import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Reserva;
import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Tarifa;
import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Vuelo;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author grilsemo
 */
public class FXMLConfirmacionCompraController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private Label lbCerrando;

    @FXML
    private Label lbReserva;
    
    @FXML
    private Button btAceptar;
    
    private int contador=4;
    
    public static Stage stage;
    
    public static Reserva rv;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbReserva.setText("Reserva: " + FXMLPagoController.numeroReserva);
        btAceptar.setOnAction(e -> {
            try {
                App.setRoot("FXMLOpcionclientes", 600, 400, null, "Bienvenido");
            } catch (IOException ex) {
            }
            stage.close();
        });

        KeyFrame k = new KeyFrame(Duration.seconds(1), event -> {
            Platform.runLater(() -> {
                lbCerrando.setText("Ventana cerrando en " + contador + " segundos...");
                contador--;
            });
        });

        Timeline lineaTiempo = new Timeline(k);
        lineaTiempo.setCycleCount(6);
        lineaTiempo.setOnFinished(event -> {
            try {
                App.setRoot("FXMLOpcionclientes", 600, 400, null, "Bienvenido");
            } catch (IOException ex) {
            }
            stage.close();
        });

        lineaTiempo.play();

        btAceptar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent Ae) {
                Vuelo vida = FXMLReservaVueloIdaController.vChoice.get(0);
                Vuelo vregreso = FXMLReservaVueloIdaController.vChoice.get(1);
                Tarifa Tida = FXMLTarifaVueloIdaController.tarifaSeleccionada;
                Tarifa Tregreso = FXMLTarifasRegresoController.tarifaSeleccionada;
                Cliente cl=App.cliente.get(0);
                String code=FXMLPagoController.numeroReserva;
                rv=new Reserva(code,cl.getCed(),vida.getOrigen(),vida.getDestino(),String.valueOf(FXMLVentanaReservaController.f1),String.valueOf(FXMLVentanaReservaController.f2),FXMLVentanaReservaController.numP,vida.getCodAvion(),vregreso.getCodAvion(),Tida.getTipo(),Tregreso.getTipo());
                escribirreserva(rv);
                serializareserva(rv);
                Boolean esTar=FXMLPagoController.esTarjeta;
                String fp=null;
                if(esTar){
                fp="T";
                }else{
                fp="E";
                
                }
                char formap = fp.toCharArray()[0];
                rv.generarTransaccion(FXMLPagoController.idPago, code, FXMLResumenreservaController.precioTotal, FXMLPagoController.descuento, formap,FXMLPagoController.totalPagar);
                
                try (BufferedWriter bf = new BufferedWriter(new FileWriter(App.pathachiOutput + "pagos.txt"))) {
                bf.write(FXMLPagoController.idPago+","+code+","+String.valueOf(FXMLResumenreservaController.precioTotal)+","+String.valueOf(FXMLPagoController.descuento)+","+fp+","+String.valueOf(FXMLPagoController.totalPagar));
                } catch (IOException e) {
                 System.out.println(e.getMessage());
                 
                }
            Stage st=(Stage)btAceptar.getScene().getWindow();
             st.close();
            }
        });
    }
    
   
    
    /**
     * escribirreserva(Reserva r) permite escribir el objeto reserva en un archivo llamado "reservas.txt.
     * @param r 
     */
    public static void escribirreserva(Reserva r) {
    try (BufferedWriter bf = new BufferedWriter(new FileWriter(App.pathachiOutput + "reservas.txt"))) {
        bf.write(r.getCodigo() + "," + r.getCliente() + "," + r.getCiudadO() + "," + r.getCiudadD() + ","
                + r.getfSalida() + "," + r.getfLlegada() + "," + r.getNumPasajeros() + "," + r.getVueloIda() + ","
                + r.getVueloRegreso() + "," + r.getTarifaIda() + "," + r.getTarifaRegreso());
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}
    /**
     * serializareserva(Reserva r) permite serializar el objeto reserva ingresado como parámetro.
     * @param r 
     */
    public static void serializareserva(Reserva r){
    try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(r.getCodigo()))){
                out.writeObject(r);
                }catch(IOException ex){
           System.out.println("No se puede Serializar");}
    }
    
    
}