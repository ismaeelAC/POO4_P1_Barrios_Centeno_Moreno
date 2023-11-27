
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
    protected int numeroServicio;
    private String nombreConductor;
    private String origen;
    private String destino;
    private String fecha;
    private String hora;
    private double valorapagar;
    private FormaDePago fp; 
    private int ID;
    
    
    //Constructor

    public Servicio(int numeroServicio, String nombreConductor, String origen, String destino, String fecha, String hora,double valorapagar,FormaDePago fp){
        this.numeroServicio = numeroServicio;
        this.nombreConductor = nombreConductor;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.valorapagar = valorapagar;
        this.fp = fp;
    }

    /**
     * El método generarID permite generar una identificación única cada vez que se solicita un servicio, ya sea de tipo taxi o encomienda.
     * @return Retorna un codigo numerico que sirve como identificador
     */
    public static int generarID() {
        Random rd=new Random();
        int valal=rd.nextInt(1000000000);
        return valal;
    }
    
    //Metodos getter
    public int getID(){
    return ID;
    }
    public int getNumeroServicio() {
        return numeroServicio;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public double getValorapagar() {
        return valorapagar;
    }

    public FormaDePago getFp() {
        return fp;
    }
     
    //Metodos setter
    public void setNumeroServicio(int numeroServicio) {
        this.numeroServicio = numeroServicio;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setValorapagar(double valorapagar) {
        this.valorapagar = valorapagar;
    }

    public void setFp(FormaDePago fp) {
        this.fp = fp;
    }
    
    /**
     * calcularvalorapagar es un método que se escribe en la clase Servicio y se sobrecarga para que pueda ser utilizado en la clase hija.
     * 
     * @return Retorna un double que será el valor del subtotal
     */
    public double calcularvalorapagar (){
    return 0.0;
    }
    public  double calcularvalorpagar(FormaDePago fp1, double st){
    return 0.0;
    }
    
    //metodo calcular valor pagar
    //Crear metodo guardar datos servicios que me permite escriibr en un archivo los datos obtenido 
    @Override
    public String toString(){
    return "Fecha: "+getFecha()+"\n"+"Hora: "+getHora()+"\n"+"Desde: "+getOrigen()+"\n"+"Hasta: "+getDestino();
    }
    
}
