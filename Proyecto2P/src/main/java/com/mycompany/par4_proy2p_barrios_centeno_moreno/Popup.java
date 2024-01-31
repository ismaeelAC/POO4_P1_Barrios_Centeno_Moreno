/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno;

import com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases.Promocion;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author grilsemo
 */
public class Popup {
    
    public HBox createPopup(Promocion promo,Stage stage) {
        HBox root = new HBox();
        root.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        root.setPrefHeight(228.0);
        root.setPrefWidth(361.0);
        root.setStyle("-fx-background-color: #901941;");

        VBox vBox = new VBox();
        vBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        vBox.setPrefHeight(220.0);
        vBox.setPrefWidth(280.0);
        vBox.setSpacing(20.0);

        Label lbPais = new Label(promo.getPais());
        lbPais.setTextFill(javafx.scene.paint.Color.WHITE);
        lbPais.setFont(new Font("Calibri Bold", 20.0));

        Label lbCodigo = new Label(promo.getCodigo());
        lbCodigo.setTextFill(javafx.scene.paint.Color.WHITE);
        lbCodigo.setFont(new Font("Calibri", 20.0));

        Label lbDescuento = new Label("Descuento: "+promo.getDescuento()+"%");
        lbDescuento.setTextFill(javafx.scene.paint.Color.WHITE);
        lbDescuento.setFont(new Font("Calibri", 20.0));

        Label lbCerrando = new Label("Cerrando en 5 segundos...");
        lbCerrando.setId("lbCerrando");
        lbCerrando.setTextFill(javafx.scene.paint.Color.WHITE);
        lbCerrando.setFont(new Font("Calibri", 20.0));

        vBox.getChildren().addAll(lbPais, lbCodigo, lbDescuento, lbCerrando);
        vBox.setPadding(new Insets(0, 0, 0, 20.0));

        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setMnemonicParsing(false);
        btnCerrar.setStyle("-fx-background-color: orange;");
        btnCerrar.setOnAction(e->{
            stage.close();
        });
        HBox.setMargin(btnCerrar, new Insets(0, 0, 20.0, 0));

        root.getChildren().addAll(vBox, btnCerrar);

        return root;
    }
}
