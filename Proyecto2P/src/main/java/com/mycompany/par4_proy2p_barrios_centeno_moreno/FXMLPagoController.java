/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;


import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Promocion;
import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Vuelo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author grilsemo
 */
public class FXMLPagoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private VBox coResumen;

    @FXML
    private VBox coTipoPago;

    @FXML
    private Label lbSubtotal;

    @FXML
    private RadioButton rbEfectivo;

    @FXML
    private RadioButton rbTarjeta;

    @FXML
    private TextField tfCodigo;
    
    private HashMap<String,String> destinos = new HashMap<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Vuelo vueloIda=null; // necesito el objeto tipo Vuelo de la ruta de ida
        Vuelo vueloRetorno=null; //necesito el objeto tipo Vuelo de la ruta de retorno
        leerDatosDestinos();
        
        lbSubtotal.setText("Resumen de compra: "+String.valueOf(vueloIda.getPrecio()+vueloRetorno.getPrecio()));
        
        rbTarjeta.setOnAction(e->{
            coTipoPago.getChildren().clear();
            coTipoPago.getChildren().add(crearSeccionTarjeta());
            
        });
        
        rbEfectivo.setOnAction(e->{
            coTipoPago.getChildren().clear();
            coTipoPago.getChildren().add(crearSeccionEfectivo());
        });
        
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> {
            boolean promoEncontrada=false;
            for(Promocion p: FXMLVentanaPromocionesController.promociones){
                if(tfCodigo.getText().equals(p.getCodigo()) && vueloIda.getDestino().equals(destinos.get(p.getPais()))){
                    crearResumen(vueloIda,vueloRetorno,p);
                    promoEncontrada = true;
                    break;
                }
            }
            if(!promoEncontrada){
                crearResumen(vueloIda,vueloRetorno,null);
            }
            
        });
        
        tfCodigo.setOnKeyReleased(e->{
            coResumen.getChildren().clear();
            pause.playFromStart();
        });
        
    }
    
    private VBox crearSeccionTarjeta(){
        // Crear VBox
        VBox coTarjeta = new VBox();
        coTarjeta.setId("coTarjeta");
        coTarjeta.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        coTarjeta.setSpacing(20.0);

        // Crear Label "Informacion de la tarjeta:"
        Label labelInformacion = new Label("Informacion de la tarjeta:");
        labelInformacion.setFont(new Font("Calibri Bold", 20.0));

        // Crear HBox
        HBox hBox = new HBox();
        hBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        // Crear GridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10.0);
        gridPane.setPrefHeight(70.0);
        gridPane.setPrefWidth(304.0);
        gridPane.setVgap(20.0);

        // Configurar columnas y filas del GridPane
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column1.setMinWidth(10.0);
        column1.setPrefWidth(100.0);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        column2.setMinWidth(10.0);
        column2.setPrefWidth(100.0);

        RowConstraints row1 = new RowConstraints();
        row1.setMinHeight(10.0);
        row1.setPrefHeight(30.0);
        row1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        RowConstraints row2 = new RowConstraints();
        row2.setMinHeight(10.0);
        row2.setPrefHeight(30.0);
        row2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        RowConstraints row3 = new RowConstraints();
        row3.setMinHeight(10.0);
        row3.setPrefHeight(30.0);
        row3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        gridPane.getColumnConstraints().addAll(column1, column2);
        gridPane.getRowConstraints().addAll(row1, row2, row3);

        // Crear Labels y TextFields dentro del GridPane
        Label labelNumero = new Label("Numero de tarjeta:");
        labelNumero.setFont(new Font("Arial", 15.0));
        GridPane.setHalignment(labelNumero, javafx.geometry.HPos.RIGHT);

        Label labelExpiracion = new Label("Fecha de expiracion:");
        labelExpiracion.setFont(new Font("Arial", 15.0));
        GridPane.setHalignment(labelExpiracion, javafx.geometry.HPos.RIGHT);
        GridPane.setRowIndex(labelExpiracion, 1);

        Label labelCVV = new Label("CVV:");
        labelCVV.setFont(new Font("Arial", 15.0));
        GridPane.setHalignment(labelCVV, javafx.geometry.HPos.RIGHT);
        GridPane.setRowIndex(labelCVV, 2);

        TextField tfNumero = new TextField();
        GridPane.setColumnIndex(tfNumero, 1);

        DatePicker dpExpiracion = new DatePicker();
        GridPane.setColumnIndex(dpExpiracion, 1);
        GridPane.setRowIndex(dpExpiracion, 1);

        TextField tfCVV = new TextField();
        GridPane.setColumnIndex(tfCVV, 1);
        GridPane.setRowIndex(tfCVV, 2);

        // Agregar elementos al GridPane
        gridPane.getChildren().addAll(labelNumero, labelExpiracion, labelCVV, tfNumero, dpExpiracion, tfCVV);

        // Agregar elementos al HBox
        hBox.getChildren().add(gridPane);

        // Agregar elementos al VBox
        coTarjeta.getChildren().addAll(labelInformacion, hBox);

        return coTarjeta;
    }
    
    private Label crearSeccionEfectivo(){
        // Crear un Label con el texto y las propiedades dadas
        Label label = new Label("Estimado cliente, tiene 24 horas para acercarse a realizar el pago. De lo contrario, la reserva se anulará.");
        label.setPrefHeight(43.0);
        label.setPrefWidth(401.0);
        label.setWrapText(true);

        // Configurar la fuente del Label
        Font font = new Font("Calibri Bold", 15.0);
        label.setFont(font);
        
        return label;
    }
    
    private void crearResumen(Vuelo ida, Vuelo retorno,Promocion promo){
        Label lbDescuento = new Label();
        Label lbTotal = new Label();
        if(promo!=null){
            lbDescuento.setText("Descuento: "+promo.getDescuento()+"%");
            lbTotal.setText(String.valueOf((ida.getPrecio()+retorno.getPrecio())*(1-(promo.getDescuento()/100))));
        }
        else {
            lbDescuento.setText("Descuento: 0%");
            lbTotal.setText(String.valueOf(ida.getPrecio()+retorno.getPrecio()));
        }
        coResumen.getChildren().addAll(lbDescuento,lbTotal);
        
        
    }

    private void leerDatosDestinos(){
        try(BufferedReader br = new BufferedReader(new FileReader("promociones.txt"))){
            br.readLine();
            String linea;
            
            while((linea = br.readLine())!=null){
                String[] datos = linea.trim().split(",");
                destinos.put(datos[1],datos[0]);
            }
        }catch(IOException e){}
    }
    
}
