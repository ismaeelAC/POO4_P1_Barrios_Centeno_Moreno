/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases;

/**
 *
 * @author rb122
 */
public class Reserva implements Pagable{
    String codigo;
    String cliente;
    String ciudadO;
    String ciudadD;
    String fSalida;
    String fLlegada;
    int numPasajeros;
    String numvueloIda;
    String numvueloRegreso;
    String tarifaIda;
    String tarifaRegreso;
    

    public Reserva(String codigo,String cliente, String ciudadO, String ciudadD, String fSalida, String fLlegada, int numPasajeros, String numvueloIda, String numvueloRegreso, String tarifaIda, String tarifaRegreso) {
        this.cliente = cliente;
        this.ciudadO = ciudadO;
        this.ciudadD = ciudadD;
        this.fSalida = fSalida;
        this.fLlegada = fLlegada;
        this.numPasajeros = numPasajeros;
        this.numvueloIda= numvueloIda;
        this.numvueloRegreso = numvueloRegreso;
        this.tarifaIda = tarifaIda;
        this.tarifaRegreso = tarifaRegreso;
        this.codigo = codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCiudadO() {
        return ciudadO;
    }

    public void setCiudadO(String ciudadO) {
        this.ciudadO = ciudadO;
    }

    public String getCiudadD() {
        return ciudadD;
    }

    public void setCiudadD(String ciudadD) {
        this.ciudadD = ciudadD;
    }

    public String getfSalida() {
        return fSalida;
    }

    public void setfSalida(String fSalida) {
        this.fSalida = fSalida;
    }

    public String getfLlegada() {
        return fLlegada;
    }

    public void setfLlegada(String fLlegada) {
        this.fLlegada = fLlegada;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public String getVueloIda() {
        return numvueloIda;
    }

    public void setVueloIda(String vueloIda) {
        this.numvueloIda = vueloIda;
    }

    public String getVueloRegreso() {
        return numvueloRegreso;
    }

    public void setVueloRegreso(String vueloRegreso) {
        this.numvueloRegreso = vueloRegreso;
    }

    public String getTarifaIda() {
        return tarifaIda;
    }

    public void setTarifaIda(String tarifaIda) {
        this.tarifaIda = tarifaIda;
    }

    public String getTarifaRegreso() {
        return tarifaRegreso;
    }

    public void setTarifaRegreso(String tarifaRegreso) {
        this.tarifaRegreso = tarifaRegreso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Reserva{" + "cliente=" + cliente + ", ciudadO=" + ciudadO + ", ciudadD=" + ciudadD + ", fSalida=" + fSalida + ", fLlegada=" + fLlegada + ", numPasajeros=" + numPasajeros + ", vueloIda=" + numvueloIda + ", vueloRegreso=" + numvueloRegreso + ", tarifaIda=" + tarifaIda + ", tarifaRegreso=" + tarifaRegreso + ", codigo=" + codigo + '}';
    }
    
    @Override
    public void generarTransaccion(String idPago,String codigoReserva,double totalReserva,double descuento,char formaPago,double totalPagar){
        
    }
}
