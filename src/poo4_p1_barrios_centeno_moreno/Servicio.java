/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo4_p1_barrios_centeno_moreno;

/**
 *
 * @author LNV
 */

import java.util.Random;
public class Servicio {
    private int numeroServicio;
    private Servicio servicio;
    private String cedulaCliente;
    private String nombreConductor;
    private String desde;
    private String hasta;
    private String fecha;
    private String hora;
    //private formaPago fp;
    
    
    public int generarID(){
    Random rd=new Random();
    int valal=rd.nextInt(1000000000);
    return valal;
    }
}
