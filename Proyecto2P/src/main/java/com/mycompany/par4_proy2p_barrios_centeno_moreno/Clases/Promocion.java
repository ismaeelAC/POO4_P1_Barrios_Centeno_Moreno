/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases;

/**
 *
 * @author grilsemo
 */
public class Promocion {
    private double coordenadaX;
    private double coordenadaY;
    private String codigo;
    private String pais;
    private double descuento;

    public Promocion(double coordenadaX, double coordenadaY, String codigo, String pais, double descuento) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.codigo = codigo;
        this.pais = pais;
        this.descuento = descuento;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Promocion{" + "coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", codigo=" + codigo + ", pais=" + pais + ", descuento=" + descuento + '}';
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

   
    
}
