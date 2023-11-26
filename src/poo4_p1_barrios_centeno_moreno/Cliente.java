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

    @Override
    public void consultarServicios(ArrayList<Servicio> serv){
    for(int i=0;i<serv.size();i++){
        System.out.println(serv.get(i));
    }
    }
    
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

 public static String[] encontrarConductorDisponible(ArrayList<String> listaStringDeConductores, ArrayList<String> listaStringDeVehiculos) {
    for (String conductor : listaStringDeConductores) {
        String[] datosConductor = conductor.split(",");
        if (datosConductor[1].equals("O")) { // Verifica si el estado es 'Ocupado'
            String cedulaConductor = datosConductor[0];
            for (String vehiculo : listaStringDeVehiculos) {
                String[] datosVehiculo = vehiculo.split(",");
                if (datosVehiculo[3].equals("A")) { // Verifica si el vehículo está 'Disponible'
                    ArrayList<String> datosUsuario = Sistema.LeeFichero("usuarios.txt");
                    for (String usuario : datosUsuario) {
                        String[] datosUsuarioSplit = usuario.split(",");
                        if (cedulaConductor.equals(datosUsuarioSplit[0])) { // Compara las cédulas
                            String[] datsconductorres=new String[2];
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
 
 public static String[] encontrarConductorDisponibleE(ArrayList<String> listaStringDeConductores, ArrayList<String> listaStringDeVehiculos) {
    for (String conductor : listaStringDeConductores) {
        String[] datosConductor = conductor.split(",");
        if (datosConductor[1].equals("O")) { // Verifica si el estado es 'Ocupado'
            String cedulaConductor = datosConductor[0];
            for (String vehiculo : listaStringDeVehiculos) {
                String[] datosVehiculo = vehiculo.split(",");
                if (datosVehiculo[3].equals("M")) { // Verifica si el vehículo está 'Disponible'
                    ArrayList<String> datosUsuario = Sistema.LeeFichero("usuarios.txt");
                    for (String usuario : datosUsuario) {
                        String[] datosUsuarioSplit = usuario.split(",");
                        if (cedulaConductor.equals(datosUsuarioSplit[0])) { // Compara las cédulas
                            String[] datsconductorres=new String[2];
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