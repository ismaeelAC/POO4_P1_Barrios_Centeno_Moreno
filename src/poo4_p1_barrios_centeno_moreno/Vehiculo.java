/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo4_p1_barrios_centeno_moreno;

/**
 *
 * @author rb122
 */
public class Vehiculo {
    private String codigoVehiculo;
    private String placa;
    private String modelo;
    private String marca;
    private TipoVehiculo tipo;

    // Resto del código de la clase

    public Vehiculo(String codigoVehiculo, String placa, String modelo, String marca, TipoVehiculo tipo) {
        this.codigoVehiculo = codigoVehiculo;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.tipo = tipo;
    }
    
    
    
    @Override
    public String toString() {
        return "Vehiculo{" +
                "codigoVehiculo='" + codigoVehiculo + '\'' +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
