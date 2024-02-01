/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;


import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.CodigoInvalidoException;
import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.DatosIncompletosException;
import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Pagable;
import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Pago;
import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Promocion;
import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Vuelo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author grilsemo
 */
public class FXMLPagoController implements Initializable,Pagable {

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
    
    @FXML
    private VBox coException;
    
    @FXML
    private Button btPagar;
    
    @FXML
    private Button btCancelar;
    
    public static ArrayList<Promocion> promociones = new ArrayList<>();
    
    private HashMap<String,String> destinos = new HashMap<>();
    
    Vuelo vueloIda = FXMLReservaVueloIdaController.vChoice.get(0); 
    Vuelo vueloRetorno = FXMLReservaVueloIdaController.vChoice.get(1);
    double descuento = 0;
    boolean codigoValido;
    boolean esTarjeta;
    double totalPagar;
    static String numeroReserva;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        leerDatosPromociones();
        
         
        leerDatosDestinos();
        
        lbSubtotal.setText("Resumen de compra: "+String.valueOf(vueloIda.getPrecio()+vueloRetorno.getPrecio()));
        
        rbTarjeta.setOnAction(e->{
            coTipoPago.getChildren().clear();
            coTipoPago.getChildren().add(crearSeccionTarjeta());
            esTarjeta = true;
            
        });
        
        rbEfectivo.setOnAction(e->{
            coTipoPago.getChildren().clear();
            coTipoPago.getChildren().add(crearSeccionEfectivo());
            esTarjeta = false;
        });
        
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> {
            codigoValido = verificarCodigo();
            if(!codigoValido){
                crearResumen(vueloIda,vueloRetorno,null);
            }
            
        });
        
        tfCodigo.setOnKeyReleased(e->{
            coResumen.getChildren().clear();
            pause.playFromStart();
        });
        
        btPagar.setOnAction(e->{
            try {
                System.out.println("El click funciona");
                eventoBotonPagar();
            } catch (DatosIncompletosException ex) {
                Label lbException = new Label(ex.getMessage());
                lbException.setFont(new Font("Calibri",30));
                lbException.setTextFill(Color.RED);
                VBox coTarjeta = (VBox)coTipoPago.lookup("#coTarjeta");
                coTarjeta.getChildren().add(lbException);
            }
            
            });
        
        btCancelar.setOnAction(e->{
            FXMLLoader f = new FXMLLoader(App.class.getResource("FXMLCancelarCompra.fxml"));
            Stage stage = new Stage();
            Scene scene=null;
            try {
                scene = new Scene(f.load());
            } catch (IOException ex) {
            }
            
            stage.setScene(scene);
            stage.show();
            FXMLCancelarCompraController.stage=stage;
        });
        
    }
    
    private boolean verificarCodigo() throws CodigoInvalidoException{
        String codigo = tfCodigo.getText();
        boolean siExiste = false;
        
        for(Promocion p: promociones){
            if(p.getCodigo().equals(codigo) && vueloIda.getDestino().equals(destinos.get(p.getPais())) ){
                crearResumen(vueloIda,vueloRetorno,p);
                siExiste = true;
                descuento = p.getDescuento();
            }else{
                if(coException.getChildren().size()>1){coException.getChildren().remove(1);}
                CodigoInvalidoException exception = new CodigoInvalidoException("El codigo ingresado no es valido. Borre el codigo invalido o Ingrese uno \n valido para continuar.");
                Label lbException = new Label(); 
                lbException.setText(exception.getMessage());
                lbException.setFont(new Font("Calibri",12));
                lbException.setTextFill(Color.RED);
                coException.getChildren().add(lbException);
                throw exception;   
            }
        }
        return siExiste;
        
    }
    
    private void leerDatosPromociones(){
        try(BufferedReader br = new BufferedReader(new FileReader("promociones.txt"))){
            br.readLine();
            String linea;
            
            while((linea = br.readLine())!=null){
                String[] datos = linea.trim().split(",");
                promociones.add(new Promocion(Double.parseDouble(datos[0]),Double.parseDouble(datos[1]),datos[3],datos[2],Double.parseDouble(datos[4])));
            }
        }catch(IOException e){}
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
        tfNumero.setId("tfNumero");
        GridPane.setColumnIndex(tfNumero, 1);

        DatePicker dpExpiracion = new DatePicker();
        dpExpiracion.setId("dpExpiracion");
        GridPane.setColumnIndex(dpExpiracion, 1);
        GridPane.setRowIndex(dpExpiracion, 1);

        TextField tfCVV = new TextField();
        tfCVV.setId("tfCVV");
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
            double totalApagar = (ida.getPrecio()+retorno.getPrecio())*(1-(promo.getDescuento()/100));
            lbDescuento.setText("Descuento: "+promo.getDescuento()+"%");
            lbTotal.setText(String.valueOf(totalApagar));
            totalPagar = totalApagar;
        }
        else {
            double totalApagar = ida.getPrecio()+retorno.getPrecio();
            lbDescuento.setText("Descuento: 0%");
            lbTotal.setText(String.valueOf(totalApagar));
            totalPagar = totalApagar;
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
    
    private String generarCodigoReserva(){
        String codigoReserva="";
        for(int i = 0; i<6; i++){
            int numAleatorio = (int)(Math.random() * (90 - 65 + 1) + 65);
            codigoReserva = codigoReserva + (char)numAleatorio;
        }
        
        return codigoReserva;
    }

    private void eventoBotonPagar() throws DatosIncompletosException {
        if(tfCodigo.getText().equals("") || codigoValido){
                if(esTarjeta){
                    TextField tfNumero = (TextField)coTipoPago.lookup("#tfNumero");
                    TextField tfCVV = (TextField)coTipoPago.lookup("#tfCVV");
                    DatePicker dpExpiracion = (DatePicker)coTipoPago.lookup("#dpExpiracion");
                    
                    boolean estaLleno = (tfNumero.getText()!=null) && (tfCVV.getText()!=null) && (dpExpiracion.getValue()!=null);
                    
                    if(estaLleno){
                        String idPago = String.valueOf((int) (Math.random() * 900000) + 100000);
                        String codigoReserva = generarCodigoReserva();
                        numeroReserva= codigoReserva;
                        double totalReserva = vueloIda.getPrecio()+vueloRetorno.getPrecio();
                        char formaPago;
                        if(esTarjeta){
                            formaPago='C';
                        }else{
                            formaPago='E';
                        }
                         
                        generarTransaccion(idPago,codigoReserva,totalReserva,descuento,formaPago,totalPagar);
                    }else{
                        throw new DatosIncompletosException("Los datos de la tarjeta de credito estan incompletos");
                    }
                    
                }else{
                    
                    String codigoReserva = generarCodigoReserva();
                    numeroReserva= codigoReserva;
                    
                }
                FXMLLoader f = new FXMLLoader(App.class.getResource("FXMLConfirmacionCompra.fxml"));
                Stage stage = new Stage();
                Scene scene=null;
                try {
                    scene = new Scene(f.load());
                } catch (IOException ex) {
                }
                stage.setScene(scene);
                stage.show();
                FXMLConfirmacionCompraController.stage=stage;
            
            }
        
    }
    @Override
    public void generarTransaccion(String idPago,String codigoReserva,double totalReserva,double descuento,char formaPago,double totalPagar) {
        Pago pago = new Pago(idPago,codigoReserva,totalReserva,descuento,formaPago,totalPagar);
        App.pagos.add(pago);
    }
    
}
