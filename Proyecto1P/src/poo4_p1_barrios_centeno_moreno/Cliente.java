/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo4_p1_barrios_centeno_moreno;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;
import main.Sistema;


/**
 *
 * @author grils
 */
public class Cliente extends Usuario {
    
   private String  tarjetaDeCredito;
   //ojo cambié el orden del construcor
   public Cliente(String cedula,String nombre,String apellido,int edad,String user,String contrasenia,String celular,TipoUsuario tipoUsuario, String tarjetaDeCredito){
     super(cedula,nombre,apellido,edad,user,contrasenia,celular,tipoUsuario); 
     this.tarjetaDeCredito=tarjetaDeCredito;
   
   }

    /**
     * Metodo el cual funciona con una lista de tipo Servicio y la recorre mostrando cada uno de los elementos
     * @param serv Parametro de tipo lista - Servicio, el cual contiene todos los servicios registrados
     */
   
    @Override
    public void consultarServicios(ArrayList<Servicio> serv){
    for(int i=0;i<serv.size();i++){
        System.out.println(serv.get(i));
    }
  }
    
    /**
     * Metodo el cual se encarga de registrar el pago de un servicio especifico y registrarlo en un txt
     * @param servicio Parametro de tipo servicio que sirve para especificar que tipo de servicio se esta pagando
     */
    
  public void pagarServicios(Servicio servicio) {
    if (servicio instanceof Taxi){
        Taxi tx1=(Taxi) servicio;
        if(servicio.getFp().equals(FormaDePago.TC)){
        double valorapagar=tx1.getValorapagar()+(tx1.getValorapagar()*0.15);}
        else{
        double valorapagar=tx1.getValorapagar();
        tx1.setValorapagar(valorapagar);
        }
        
     }
    
  }
    //String lineaArchivo = idPago + servicio.getFecha() + servid + formaDePago + cl.getCedula() + servicio.getValorapagar() + ;

    // Escribir en el archivo
    //Sistema.EscribirArchivo("pagos.txt", lineaArchivo);

  
  /**
   * Metodo para Viajes el cual determina si hay conductores disponibles mediante su estado O o D, y si tiene un vehiculo que sea auto
   * @param listaStringDeConductores Lista que guarda los datos de cada uno de los usarios Conductores
   * @param listaStringDeVehiculos Lista que guarda los vehiculos y de que tipo son
   * @return 
   */
public static String[] encontrarConductorDisponible(ArrayList<String> listaStringDeConductores, ArrayList<String> listaStringDeVehiculos) {
    String[] datsconductorres=new String[2];
    for (String conductor : listaStringDeConductores) {
        String[] datosConductor = conductor.split(",");
        if (datosConductor[1].equals("D")) { // Verifica si el estado es 'Ocupado'
            String cedulaConductor = datosConductor[0];
            for (String vehiculo : listaStringDeVehiculos) {
                String[] datosVehiculo = vehiculo.split(",");
                if (datosVehiculo[4].equals("A")) { // Verifica si el vehículo está 'Disponible'
                    ArrayList<String> datosUsuario = Sistema.LeeFichero("usuarios.txt");
                    for (String usuario : datosUsuario) {
                        String[] datosUsuarioSplit = usuario.split(",");
                        if (cedulaConductor.equals(datosUsuarioSplit[0])) { 
                            datsconductorres[0]=cedulaConductor;
                            datsconductorres[1]=datosUsuarioSplit[1];
                            return datsconductorres;
                        }
                    }
                }
            }
        }
    }
    return null; // Si no se encuentra conductor disponible
 } 


 /**
  * Metodo para Encomiendas el cual identifica si hay un conductor disponible y si este posee un vehiculo que sea moto
  * @param listaStringDeConductores Lista que guarda los datos de los usuarios conductores
  * @param listaStringDeVehiculos lista que guarda los datos de los vehiculos
  * @return 
  */
 public static String[] encontrarConductorDisponibleE(ArrayList<String> listaStringDeConductores, ArrayList<String> listaStringDeVehiculos) {
     String[] datsconductorres=new String[2];
     for (String conductor : listaStringDeConductores) {
        String[] datosConductor = conductor.split(",");
        if (datosConductor[1].equals("D")) { 
            String cedulaConductor = datosConductor[0];
            for (String vehiculo : listaStringDeVehiculos) {
                String[] datosVehiculo = vehiculo.split(",");
                if (datosVehiculo[4].equals("M")) { // Verifica si el vehículo está 'Disponible'
                    ArrayList<String> datosUsuario = Sistema.LeeFichero("usuarios.txt");
                    for (String usuario : datosUsuario) {
                        String[] datosUsuarioSplit = usuario.split(",");
                        if (cedulaConductor.equals(datosUsuarioSplit[0])) { // Compara las cédulas
                            datsconductorres[0]=cedulaConductor;
                            datsconductorres[1]=datosUsuarioSplit[1];
                            return datsconductorres;
                        }
                    }
                }
            }
        }
    }
    return null; // Si no se encuentra conductor disponible
 }
 
 
 
 
}