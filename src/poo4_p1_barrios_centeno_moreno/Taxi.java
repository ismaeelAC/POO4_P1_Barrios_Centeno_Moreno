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
@Override
public String toString(){
return "Tipo: "+"Viaje"+"\n"+"Cantidad de pasajeros: "+getNumPersonas()+"\n"+super.toString();
}


}

