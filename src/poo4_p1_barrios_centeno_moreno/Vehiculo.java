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

    public String getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }
    
    
    /**
     * Metodo toString que muestra la informacion de un vehiculo
     * @return Devuelve los datos especificos de dicho vehiculo
     */
    @Override
    public String toString() {
        return "Vehiculo\n" +
                "codigoVehiculo='" + getCodigoVehiculo() + '\'' +
                ", placa='" + getPlaca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", tipo=" + getTipo() +
                '}';
    }
}
