
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo4_p1_barrios_centeno_moreno;

/**
 *
 * @author LNV
 */
public class Encomienda extends Servicio {
    private double peso;
    private TipoEncomienda tipoE;
    private int numProductos;
    
    //Constructor

    public Encomienda(double peso, TipoEncomienda tipoE, int numProductos, int numeroServicio, String nombreConductor, String origen, String destino, String fecha, String hora, double valorapagar, FormaDePago fp) {
        super(numeroServicio, nombreConductor, origen, destino, fecha, hora,valorapagar, fp);
        this.peso = peso;
        this.tipoE = tipoE;
        this.numProductos = numProductos;
        
    }
    
    
    
    
    /**
     * Metodo el cual calcula el valor a pagar dependiendo al numero de producto y le agrega 4 dolares por viaje
     * @return Retorna el valor a pagar por el servicio
     */
    @Override
    public double calcularvalorapagar(){
        
        int valorEncomienda = this.numProductos;
        double valorCarrera = 4.0;
        double valfinal=valorEncomienda*valorCarrera;
        return valfinal ;
        
    }
    
    
    //metodo guardar datosencomienda

    public double getPeso() {
        return peso;
    }

    public TipoEncomienda getTipoE() {
        return tipoE;
    }

    public int getNumProductos(){
        return numProductos;
    }
    
    /**
     * Sobrescritura del metodo toString el cual muestra la informacion del servicio encomienda
     * @return Informacion sobre el servicio incluyendo sus datos
     */
    @Override
    public String toString(){
    return "/***********************************************************************/"+"\nTipo: "+"Encomienda\n"+"Tipo encomienda: "+getTipoE()+"\n"+"Cantidad de productos: "+getNumProductos()+"\n"+super.toString();
    }
    
}

