/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author rb122
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import poo4_p1_barrios_centeno_moreno.Cliente;
import poo4_p1_barrios_centeno_moreno.TipoUsuario;
import poo4_p1_barrios_centeno_moreno.Usuario;
import poo4_p1_barrios_centeno_moreno.Servicio;
import poo4_p1_barrios_centeno_moreno.Vehiculo;
import poo4_p1_barrios_centeno_moreno.Taxi;
import poo4_p1_barrios_centeno_moreno.FormaDePago;
import poo4_p1_barrios_centeno_moreno.Pago;
import poo4_p1_barrios_centeno_moreno.Encomienda;
import poo4_p1_barrios_centeno_moreno.TipoEncomienda;
import poo4_p1_barrios_centeno_moreno.Conductor;
import poo4_p1_barrios_centeno_moreno.TipoVehiculo;
import poo4_p1_barrios_centeno_moreno.Estado;



public class Sistema {
    static ArrayList <Usuario> users= new ArrayList<>();
    static ArrayList <Servicio> servicios= new ArrayList<>();
    static ArrayList <Vehiculo> vehiculos= new ArrayList<>();
     /**
     * LeerFichero permite leer las lineas pertenecientes a un archivo y almacenarlas en un ArrayList de String
     * @param nombrearchivo;
     * @return Un ArrayList que contiene todas las lineas del archivo
     */
  
     public static ArrayList<String> LeeFichero(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                
                lineas.add(linea);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lineas;

     }
     
     /**
      * EscribirArchivo permite escribir en un archivo lo que recibe como parámetro
      * @param nombreArchivo; Archivo en el que queremos escribir
      * @param linea; Es el String que queremos escribir en el archivo
      */
     
public static void EscribirArchivo(String nombreArchivo, String linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo,true);
            bw = new BufferedWriter(fichero);
            bw.write("\n"+linea+"\n");
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    //fichero.close();
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
     public FormaDePago obtenerEnumDesdeString(String valor) {
        if ("TC".equals(valor)) {
            return FormaDePago.TC;
        } else {
            return FormaDePago.E;
        }
    }
    public TipoVehiculo obtenerEnumV(String valor) {
        if ("A".equals(valor)) {
            return TipoVehiculo.A ;
        } else {
            return TipoVehiculo.M;
        }
    } 
     
    public TipoEncomienda obtenerEnumDesdeString2(String valor) {
        if ("MEDICINA".equals(valor)) {
            return TipoEncomienda.MEDICINA;
        } else {
            return TipoEncomienda.DOCUMENTO;
        }
    }
    
  public TipoVehiculo obtenerEnum(String valor) {
        if ("A".equals(valor)) {
            return TipoVehiculo.A;
        } else {
            return TipoVehiculo.M;
        }
    }
/**
 * iniciarSesion permite al usuario ingresar los datos necesarios para ingresar al sistema.
 * @return Un arreglo de String que contiene la cedula y el tipo de usuario que es.
 */
 public ArrayList<String> iniciarSesion() {
    boolean veri = true;
    ArrayList<String> datosUsuario = new ArrayList<>();

    do {
        ArrayList<String> lineuser = LeeFichero("usuarios.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println("*******************Bienvenido al Sistema**************************");
        System.out.println("USUARIO: ");
        String user = sc.nextLine();
        System.out.println("CONTRASEÑA: ");
        String contra = sc.nextLine();

        for (int i = 0; i < lineuser.size(); i++) {
            String[] datuser = lineuser.get(i).split(",");
            String us = datuser[3];
            String pass = datuser[4];

            if (us.equals(user) && pass.equals(contra)) {
                String typeuser = datuser[6];
                datosUsuario.add(datuser[0]); // Cedula
                datosUsuario.add(typeuser); // Tipo de usuario
                datosUsuario.add(datuser[1]); // Nombre
                datosUsuario.add(datuser[2]); // Apellido
                datosUsuario.add(us); // Usuario
                datosUsuario.add(pass); // Contraseña
                datosUsuario.add(datuser[5]); // Celular
                veri = false;
                return datosUsuario;
            }
        }
        System.out.println("Los datos registrados no coinciden en el sistema, intente nuevamente\n");
    } while (veri);

    return null;
}

/**
 * verificarusuario ingresa al archivo clientes.txt para asegurarse de que el usuario tenga los datos edad y tarjeta de crédito también registradoos, de lo contrario, se los pide y los guarda en el archivo
 * @param ar; ar es el arreglo que obtenemos del método iniciarSesion.
 * @return Un char que es el tipo de usuario que es la persona que ingresó al sistema.
 */
public TipoUsuario verificarusuario(ArrayList<String> ar) {
    char typus = ar.get(1).charAt(0); // Tipo de usuario
    if (typus == 'C') {
        ArrayList<String> lineus = LeeFichero("clientes.txt");
        boolean usernotfound = true;
        for (int i = 0; i < lineus.size(); i++) {
            String[] datuser = lineus.get(i).split(",");
            String ced = datuser[0];
            if (ar.get(0).equals(ced)) {
                System.out.println("Bienvenido de nuevo");
                String cedula = ar.get(0);
                String nombre = ar.get(2);
                String apellido = ar.get(3);
                String usuario = ar.get(4);
                String contrasenia = ar.get(5);
                String celular = ar.get(6);
                String ages = datuser[1];
                Integer edad = Integer.valueOf(ages);
                String tjdc = datuser[2];
                
                Cliente cl = new Cliente(cedula, nombre, apellido, edad, usuario, contrasenia, celular, TipoUsuario.C, tjdc);
                users.add(cl);
                
                // Aquí es donde se verifica si el usuario ya está en el archivo o no
                usernotfound = false;
                break; // Terminamos el bucle ya que se encontró el usuario
            }
        }
        if (usernotfound) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Por favor, ingrese lo siguiente para continuar");
            System.out.println("Edad: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("Tarjeta de crédito: ");
            String tjc = sc.nextLine();
            ar.add(String.valueOf(age)); // Agregar edad al ArrayList
            ar.add(tjc); // Agregar tarjeta de crédito al ArrayList
            sc.close(); // Cerrar el Scanner después de usarlo
                
            // Obtener los datos del ArrayList
            String cedula = ar.get(0);
            String nombre = ar.get(2);
            String apellido = ar.get(3);
            String usuario = ar.get(4);
            String contrasenia = ar.get(5);
            String celular = ar.get(6);
            String edad = ar.get(7);
            int ages = Integer.valueOf(edad); 
            String tjdc = ar.get(8);
            
            // Crear el objeto Cliente con los datos proporcionados
            Cliente cl = new Cliente(cedula, nombre, apellido, age, usuario, contrasenia, celular, TipoUsuario.C, tjdc);
            users.add(cl);
            
            // Escribir en el archivo clientes.txt solo si no se encontró el usuario
            EscribirArchivo("clientes.txt", cedula + "," + age + "," + tjdc);
        }
        
        return TipoUsuario.C;
    } else {
    ArrayList<String> cdrs = LeeFichero("conductores.txt");
    ArrayList<String> movil = LeeFichero("vehículos.txt");

    String cedulaCond = ar.get(0);
    String nombreCond = ar.get(2);
    String apellidoCond = ar.get(3);
    String usuarioCond = ar.get(4);
    String contraseniaCond = ar.get(5);
    String celularCond = ar.get(6);
    String estado="";
    String codigovehiculo="";
    String tipovehi="";
    String placa="";
    String modelo="";
    String marca="";
    for(int i=0; i<cdrs.size();i++){
    String[] datconductor=cdrs.get(i).split(",");
    if (datconductor[0].equals(cedulaCond)){
     estado=datconductor[1];
     codigovehiculo=datconductor[2];
    }
    }
    for(int i=0;i<movil.size();i++){
    String[] datmovil=movil.get(i).split(",");
    if (datmovil[0].equals(codigovehiculo)){
        placa=datmovil[1];
        modelo=datmovil[2];
        marca=datmovil[3];
        tipovehi=datmovil[4];
        
    }
    Estado ev=Estado.valueOf(estado);
    TipoVehiculo tv=obtenerEnum(tipovehi);
    Vehiculo v1=new Vehiculo(codigovehiculo,placa,modelo,marca,tv);
    Conductor c1=new Conductor(cedulaCond,nombreCond,apellidoCond,0,usuarioCond,contraseniaCond,celularCond,TipoUsuario.R,ev,v1);
    vehiculos.add(v1);
    users.add(c1);
}
        
        
        
        return TipoUsuario.R;
    }
}
 /**
  * Metodo el cual muestra toda la lista de opciones que tiene el usuario dependiendo si es conductor o cliente
  * @param type Es el tipo de usuario que ingresa al sistema el cual es tipo enum, C o R.
  */

public void mostrarmenu(TipoUsuario type) {
    switch (type) {
        case C:
            boolean verificador = true;
            do {
                System.out.println("/******************************MENU*********************************+/");
                System.out.println("/*                                                                   /*");
                System.out.println("/********************************************************************+/");
                System.out.println("1. Solicitar servicio de taxi");
                System.out.println("2. Solicitar entrega encomienda");
                System.out.println("3. Consultar servicios");
                System.out.println("4. Salir");
                Scanner sc = new Scanner(System.in);
                System.out.println("Elija una opción: ");
                int opc = sc.nextInt();
                sc.nextLine();
                if (opc == 1) {
                    
                 System.out.println("Desde: ");
                 String inception=sc.nextLine();
                 System.out.println("Hasta: ");
                 String llegada=sc.nextLine();
                 System.out.println("Fecha: ");
                 String date=sc.nextLine();
                 System.out.println("Hora: ");
                 String hour=sc.nextLine();
                 System.out.println("Cantidad de personas que viajarán: ");
                 int cantp=sc.nextInt();
                 sc.nextLine();
                 System.out.println("Forma de pago: ");
                 String fdp=sc.nextLine();
                 FormaDePago fp=obtenerEnumDesdeString(fdp);
                 
                 int id=Servicio.generarID();
                 String ID=String.valueOf(id);
                 ArrayList<String> drivers = LeeFichero("conductores.txt");
                 ArrayList<String> moviles = LeeFichero("vehículos.txt");
                 String[] cd1=Cliente.encontrarConductorDisponible(drivers,moviles);
                 //int numeroServicio, String nombreConductor, String origen, String destino, String fecha, String hora, double valorapagar, FormaDePago fp){
                 Taxi t1=new Taxi(cantp,id,cd1[0],inception,llegada,date,hour,0.0,fp);
                 double vp=t1.calcularvalorapagar();
                 double vp2=t1.calcularvalorpagar(fp, vp);
                 System.out.println("Subotal a pagar:"+vp2);
                 servicios.add(t1);
                 String subto=String.valueOf(vp2);
                 t1.setValorapagar(vp2);
                 String klm=String.valueOf(t1.getkm());
                 Sistema.EscribirArchivo("servicios.txt",ID+","+fdp+","+cd1[0]+","+cd1[1]+","+inception+","+llegada+","+date+","+hour); 
                 Sistema.EscribirArchivo("viajes.txt",id+","+cantp+","+klm+","+subto);
                 Cliente c1=(Cliente)users.get(0);
                 c1.pagarServicios(t1);
                 Pago p=new Pago();
                 int IDP=p.generarIDN();
                 String idp=String.valueOf(IDP);
                 Sistema.EscribirArchivo("pagos.txt",idp+","+date+","+ID+","+fdp+","+c1.getCedula()+","+vp2+","+t1.getValorapagar());
             }

                 else if (opc == 2) {
                    
                 System.out.println("Desde: ");
                 String inception2=sc.nextLine();
                 System.out.println("Hasta: ");
                 String llegada2=sc.nextLine();
                 System.out.println("Fecha: ");
                 String date2=sc.nextLine();
                 System.out.println("Hora: ");
                 String hour2=sc.nextLine();
                 System.out.println("Tipo de encomienda: ");
                 String tipoE=sc.nextLine();
                 System.out.println("Cantidad de productos a enviar: ");
                 int cantp2=sc.nextInt();
                 sc.nextLine();
                 System.out.println("Peso(kg): ");
                 double weigth=sc.nextDouble();
                 sc.nextLine();
                 System.out.println("Forma de pago: ");
                 String fdp2=sc.nextLine();
                 FormaDePago fp1=obtenerEnumDesdeString(fdp2);
                 int id=Servicio.generarID();
                 String ID= String.valueOf(id);
                 
                 TipoEncomienda tpe=obtenerEnumDesdeString2(tipoE);
                 ArrayList<String> drivers = LeeFichero("conductores.txt");
                 ArrayList<String> moviles = LeeFichero("vehículos.txt");
                 String[] cd1=Cliente.encontrarConductorDisponibleE(drivers,moviles);
                 String cproduct=String.valueOf(cantp2);
                 String pesow=String.valueOf(weigth);
          
                 Encomienda e1=new Encomienda(weigth,tpe,cantp2,id,cd1[1],inception2,llegada2,date2,hour2,0.0,fp1);
                 double sbt=e1.calcularvalorapagar();
                 String SBT=String.valueOf(sbt);
                 Sistema.EscribirArchivo("encomiendas.txt",ID+","+tipoE+","+cproduct+","+pesow+","+SBT);
                 Cliente c1=(Cliente)users.get(0);
                 c1.pagarServicios(e1);
                 Pago p=new Pago();
                 int IDP=p.generarIDN();
                 String idp=String.valueOf(IDP);
                 Sistema.EscribirArchivo("pagos.txt",idp+","+date2+","+ID+","+fdp2+","+c1.getCedula()+","+SBT+","+SBT);
                 servicios.add(e1);

                } else if (opc == 3) {
                    
                 Cliente c1=(Cliente)users.get(0);
                 c1.consultarServicios(servicios);

                } else if (opc == 4) {
                    System.out.println("Gracias por preferirnos, ¡Vuelve pronto!");
                    verificador = false;
                } else {
                    System.out.println("Ingrese una opción válida");
                }
            } while (verificador);
            break;

        case R:
    boolean continuar = true;
    do {
        System.out.println("/*************************************MENU CONDUCTOR*************************************/ ");
            System.out.println("/*                                                                                      */ ");
            System.out.println("/*************************************++++++++++++++*************************************/ ");
            System.out.println("1.Consultar Servicio Asignado");
            System.out.println("2.Datos de su vehículo");
            System.out.println("3.Salir");
            Scanner sc=new Scanner(System.in);
            System.out.println("Elija una opcion: ");
            int opci=sc.nextInt();

        
        switch (opci) {
            case 1:
                for(int i=0;i<users.size();i++){
                if(users.get(i) instanceof Conductor){
                users.get(i).consultarServicios(servicios);
                break;
                }
                }
                  break;
                case 2:
                
              Conductor cnd = null;
                for (int i = 0; i < users.size(); i++) {
              if (users.get(i) instanceof Conductor) {
              cnd = (Conductor) users.get(i);
               System.out.println("Datos del vehículo del conductor " + cnd.getNombre() + ":");
               System.out.println(cnd.getVehiculo()); // Imprime solo el vehículo del conductor
                break; // Termina el ciclo después de encontrar al primer conductor y mostrar su vehículo
    }
}

        
    
             break;

            
            case 3:
                System.out.println("Gracias por tus servicios, ¡Vuelve pronto!");
                continuar = false; // Establece continuar a false para salir del bucle
                break;
                
            default:
                System.out.println("Ingresa una opción válida");
        }
    } while (continuar); // Hace que el menú se repita mientras continuar sea true
    break;
}

           
    }



 
 public static void main(String[] args){
    
    Sistema s = new Sistema();
ArrayList<String> ss = s.iniciarSesion();
TipoUsuario tu = s.verificarusuario(ss);
s.mostrarmenu(tu);
   
    }
}
