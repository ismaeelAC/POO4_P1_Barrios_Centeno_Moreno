/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases;

/**
 *
 * @author grilsemo
 */
public interface Pagable {
    
    void generarTransaccion(String idPago,String codigoReserva,double totalReserva,double descuento,char formaPago,double totalPagar);
    
}
