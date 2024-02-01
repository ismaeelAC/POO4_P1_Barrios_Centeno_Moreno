/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases;

/**
 *
 * @author grilsemo
 */
public class Pago {
    private String idPago;
    private String codigoReserva;
    private double totalReserva;
    private double descuento;
    private char formaPago;
    private double totalPagar;

    public Pago(String idPago, String codigoReserva, double totalReserva, double descuento, char formaPago, double totalPagar) {
        this.idPago = idPago;
        this.codigoReserva = codigoReserva;
        this.totalReserva = totalReserva;
        this.descuento = descuento;
        this.formaPago = formaPago;
        this.totalPagar = totalPagar;
    }

    public String getIdPago() {
        return idPago;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public double getTotalReserva() {
        return totalReserva;
    }

    public double getDescuento() {
        return descuento;
    }

    public char getFormaPago() {
        return formaPago;
    }

    public double getTotalPagar() {
        return totalPagar;
    }
    
    
    
    
}
