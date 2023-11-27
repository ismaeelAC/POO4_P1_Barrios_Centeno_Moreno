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

public class Taxi extends Servicio {
    private int numPersonas;
    private int km;
    
    //Constructor

    public Taxi(int numPersonas, int numeroServicio, String nombreConductor, String origen, String destino, String fecha, String hora,double valorapagar, FormaDePago fp) {
        super(numeroServicio, nombreConductor, origen, destino, fecha, hora,valorapagar, fp);
        this.numPersonas = numPersonas;
        this.km=0;
        
    }
    
   /**
    * Metodo el cual se encarga de calcular el valor a pagar por un viaje considerando los minutos y la distancia
    * @return Devuelve el valor a pagar para el Cliente
    */
    
    @Override
    public  double calcularvalorapagar (){
    Random rd=new Random();
    int min=5;
    int max=45;
    int km=rd.nextInt((max-min)+1)+min;
    
    double subtotal=km*0.50;
    this.km=km;
    return subtotal;
    }
    
  
    /**
     * Metodo que calcular el valor a pagar en el caso de Tarjetas de credito
     * @param fp1 Recibe una variable fp1 el cual especifica la forma de pago, si es Tarjeta o Efectivo
     * @param subt Recibe un subtotal del valor ya establecido de pago 
     * @return 
     */
    @Override
    public double calcularvalorpagar(FormaDePago fp1,double subt){
    if (fp1.equals(FormaDePago.TC)){
        double newsubtotal=subt+(subt*0.10);
        return newsubtotal;
    }
  return subt;  
  }
    
   
    //sobreescriibr metodo calcular valor a pagar
    //sobrecaragr metodo valor a paagr
    //metodo guardar datos viaje que me permite guardar todo slos datos en un archivo

    public int getNumPersonas() {
        return numPersonas;
    }
public int getkm(){
return km;
}

/**
 * Metodo toString que muesta los datos e informacion del viaje
 * @return retorna datos e informacion de un viaje registrado
 */
@Override
public String toString(){
return "Tipo: "+"Viaje"+"\n"+"Cantidad de pasajeros: "+getNumPersonas()+"\n"+super.toString();
}


}

