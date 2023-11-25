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
    
   public Cliente(String cedula,String nombre,String apellido,int edad,String user,String contrasenia,String celular,TipoUsuario tipoUsuario, String tarjetaDeCredito){
       super(cedula,nombre,apellido,edad,user,contrasenia,celular,tipoUsuario);
       this.tarjetaDeCredito=tarjetaDeCredito;
       
   }

   /***
    * 
    */
   
    @Override
    public void consultarServicios() {
        ArrayList<Servicio> serviciosSolicitados = new ArrayList<>(); //contiene todos los objetos tipo servicio que el usuario a solicitado durante su experiencia con la app        
        //encomiendas.txt y viajes.txt
        
        //Aqui se procedera a llenar serviciosSolicitados
        
        ArrayList<String> encomiendasString = Sistema.LeeFichero("encomiendas.txt");
        ArrayList<String> viajesString = Sistema.LeeFichero("viajes.txt");
        ArrayList<String> serviciosString = Sistema.LeeFichero("servicios.txt");
        ArrayList<String> pagosString = Sistema.LeeFichero("pagos.txt");
        
        
        //recorrer las lineas de los 3 arraylist de arriba
        ArrayList<String[]> encomiendasArreglos= new ArrayList<>();
        ArrayList<String[]> viajesArreglos= new ArrayList<>();
        ArrayList<String[]> serviciosArreglos= new ArrayList<>();
        ArrayList<String[]> pagosArreglos =  new ArrayList<>();
        
        for(String linea: serviciosString){
            serviciosArreglos.add(linea.split(","));
        }
        
        for(String linea: viajesString){
            viajesArreglos.add(linea.split(","));
        }
        
        for(String linea: encomiendasString){
            encomiendasArreglos.add(linea.split(","));
        }
        
        for(String linea: pagosString){
            pagosArreglos.add(linea.split(","));
        }
        
        for(String[] datosServicio : serviciosArreglos){
            if (datosServicio[1].equals(TipoServicio.TAXI.toString())){
                for(String[] datosTaxi : viajesArreglos){
                    for(String[] datosPago : pagosArreglos){
                        if(datosTaxi[0].equals(datosServicio[0]) && datosTaxi[0].equals(datosPago[0])){
                            serviciosSolicitados.add(new Taxi(datosServicio[0],datosServicio[2],datosServicio[3],datosServicio[4],datosServicio[5],
                        datosServicio[6],datosServicio[7], FormaDePago.valueOf(datosPago[3]),datosTaxi[1]));
                        }
                    }
                }
            }
            else{
                for(String[] datosEncomienda : encomiendasArreglos){
                    for(String[] datosPago : pagosArreglos){
                        if(datosEncomienda[0].equals(datosServicio[0]) && datosEncomienda[0].equals(datosPago[0])){
                            serviciosSolicitados.add(new Encomienda(datosServicio[0],datosServicio[2],datosServicio[3],datosServicio[4],datosServicio[5],
                        datosServicio[6],datosServicio[7], FormaDePago.valueOf(datosPago[3]),datosEncomienda[3],TipoEncomienda.valueOf(datosEncomienda[1]),Integer.valueOf(datosEncomiend[2])));
                        }
                    }
                }
            }
                
        }
        
        
        
        
        for (Servicio s: serviciosSolicitados){
            if (s instanceof Taxi){
                System.out.println("**************************");
                System.out.println("Tipo: Viaje");
                System.out.println("Cantidad de pasajeros: " + ((Taxi) s).getNumPersonas());
                System.out.println("Fecha: " + ((Taxi)s).getFecha());
                System.out.println("Hora: " + ((Taxi)s).getHora());
                System.out.println("Desde: " + ((Taxi)s).getOrigen());
                System.out.println("Hasta: " + ((Taxi)s).getDestino());
        }
            else if(s instanceof Encomienda){
                System.out.println("**************************");
                System.out.println("Tipo: Encomienda");
                System.out.println("Cantidad: " + ((Encomienda) s).getNumProductos());
                System.out.println("Tipo encomienda: " + ((Encomienda)s).getTipoE());
                System.out.println("Fecha: " + ((Encomienda)s).getFecha());
                System.out.println("Hora: " + ((Encomienda)s).getHora());
                System.out.println("Desde: " + ((Encomienda)s).getOrigen());
                System.out.println("Hasta: " + ((Encomienda)s).getDestino());
            }
        }
    }
    
    
    public  void pagarServicios(Servicio  servicio,FormaDePago formaDePago){
        double p= servicio.calcularvalorapagar();
        Sistema.EscribirArchivo("pagos.txt",p.getIdpago()+p.getFecha()+servicio.getNumeroServicio()+formaDePago+this.getCedula()+p.getSubtotal()+p.getValorPagar());
    }
    
    public void solicitarServicioTaxi(String desde, String hasta, String fecha, String hora, FormaDePago fp, int numeroDePasajeros){
        
        ArrayList<String> listaStringDeConductores = Sistema.LeeFichero("conductores.txt");
        ArrayList<String> listaStringDeVehiculos = Sistema.LeeFichero("vehiculos.txt");
        ArrayList<String[]> vehiculos = new ArrayList<>();
        String [] datosDelConductorAsignado;
        for (String linea: listaStringDeVehiculos){
            String [] datos = linea.split(",");
            vehiculos.add(datos);
        }
        Random rd = new Random();
        boolean buscandoConductorApto = true;
        
        while(buscandoConductorApto){
            int aleatorio = rd.nextInt(listaStringDeConductores.size());
            String[] conductorAsignado = listaStringDeConductores.get(aleatorio).split(",");
            if(vehiculos.get(aleatorio)[0].equals(conductorAsignado[2]) && vehiculos.get(aleatorio)[4].equals((TipoVehiculo.AUTO.toString()))){
                if(conductorAsignado[1].equals("D")){
                    buscandoConductorApto = false;
                    datosDelConductorAsignado=conductorAsignado; 
                }       
            }
        }
        
        
        int numeroDeServicio = rd.nextInt(90000) + 10000;
        
        
        Taxi viaje = new Taxi(numeroDePasajeros , Conductor.getNombre(), datosDelConductorAsignado[0], desde, hasta, fecha, hora, fp);
        double [] viajeInfo = viaje.calcularValorPagar();
        Sistema.EscribirArchivo("viajes.txt",numeroDeServicio+numeroDePasajeros+viajeInfo[1]+viajeInfo[0]);
    }

    public void solicitarServicioEncomienda(String desde, String hasta, String fecha, String hora, FormaDePago fp, TipoEncomienda te, int cantidadDeProductos, double peso){
        ArrayList<String> listaStringDeConductores = Sistema.LeeFichero("conductores.txt");
        ArrayList<String> listaStringDeVehiculos = Sistema.LeeFichero("vehiculos.txt");
        ArrayList<String[]> vehiculos = new ArrayList<>();
        String [] datosDelConductorAsignado;
        for (String linea: listaStringDeVehiculos){
            String [] datos = linea.split(",");
            vehiculos.add(datos);
        }
        Random rd = new Random();
        boolean buscandoConductorApto = true;
        
        while(buscandoConductorApto){
            int aleatorio = rd.nextInt(listaStringDeConductores.size());
            String[] conductorAsignado = listaStringDeConductores.get(aleatorio).split(",");
            if(vehiculos.get(aleatorio)[0].equals(conductorAsignado[2]) && vehiculos.get(aleatorio)[4].equals((TipoVehiculo.MOTO.toString()))){
                if(conductorAsignado[1].equals("D")){
                    buscandoConductorApto = false;
                    datosDelConductorAsignado=conductorAsignado; 
                }       
            }
        }
        
        
        int numeroDeServicio = rd.nextInt(90000) + 10000;
        
        
        Encomienda encomienda = new Encomienda(numeroDeServicio , this.getCedula(), datosDelConductorAsignado[0], desde, hasta, fecha, hora, fp, te, cantidadDeProductos, peso);
        Sistema.EscribirArchivo("encomiendas.txt",encomienda.getNumeroServicio()+te.toString()+cantidadDeProductos+peso+encomienda.calcularValorPagar(cantidadDeProductos));
    }
    
        
    
}
