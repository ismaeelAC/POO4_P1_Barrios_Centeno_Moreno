/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases;

/**
 *
 * @author rb122
 */
public class Vuelo implements Comparable<Vuelo> {
    
    private String origen;
    private String destino;
    private String duracion;
    private String horaS;
    private String horaL;
    private String numVuelo;
    private String codAvion;
    private double precio;

    public Vuelo(String origen, String destino, String duracion, String horaS, String horaL, String numVuelo, String codAvion, double precio) {
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
        this.horaS = horaS;
        this.horaL = horaL;
        this.numVuelo = numVuelo;
        this.codAvion = codAvion;
        this.precio = precio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getHoraS() {
        return horaS;
    }

    public void setHoraS(String horaS) {
        this.horaS = horaS;
    }

    public String getHoraL() {
        return horaL;
    }

    public void setHoraL(String horaL) {
        this.horaL = horaL;
    }

    public String getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(String numVuelo) {
        this.numVuelo = numVuelo;
    }

    public String getCodAvion() {
        return codAvion;
    }

    public void setCodAvion(String codAvion) {
        this.codAvion = codAvion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "origen=" + origen + ", destino=" + destino + ", duracion=" + duracion + ", horaS=" + horaS + ", horaL=" + horaL + ", numVuelo=" + numVuelo + ", codAvion=" + codAvion + ", precio=" + precio + '}';
    }
    
    @Override
    public int compareTo(Vuelo v){
        return Double.compare(this.precio, v.precio);
    }
    
    
    public int compareToD(Vuelo v){
        return this.duracion.compareTo(v.duracion);
    }
    
    
    
}
