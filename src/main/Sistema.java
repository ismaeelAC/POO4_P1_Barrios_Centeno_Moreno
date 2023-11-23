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
public class Sistema {
    /*ArrayList <Usuario>= new ArrayList<>();
    ArrayList <Servicio>= new ArrayList<>();
    ArrayLList <Vehiculo>= new ArrayList<>();*/
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
     
public  void EscribirArchivo(String nombreArchivo, String linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo,true);
            bw = new BufferedWriter(fichero);
            bw.write(linea+"\n");
            

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

/**
 * iniciarSesion permite al usuario ingresar los datos necesarios para ingresar al sistema.
 * @return Un arreglo de String que contiene la cedula y el tipo de usuario que es.
 */
 public String[] iniciarSesion() {
            boolean veri = true; // Inicializado como true para que entre al menos una vez al ciclo do-while
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
                        //char tipous = typeuser.charAt(0);
                        veri = false; // Cambio a false para salir del ciclo
                        String [] datos=new String[2];
                        datos[0]=datuser[0];
                        datos[1]=typeuser;
                        return datos;
                    }
                }
                System.out.println("Los datos registrados no coinciden en el sistema, intente nuevamente\n");
            } while (veri); // Ciclo para reintentar mientras veri sea true
     
    return null; // Valor de retorno por defecto si no hay coincidencias o errores
}
/**
 * verificarusuario ingresa al archivo clientes.txt para asegurarse de que el usuario tenga los datos edad y tarjeta de crédito también rgistradoos, de lo contrario, se los pide y los guarda en el archivo
 * @param ar; ar es el arreglo que obtenemos del método iniciarSesion.
 * @return Un char que es el tipo de usuario que es la persona que ingresó al sistema.
 */
 public char verificarusuario(String[] ar){
 char typus=ar[1].charAt(0);
 if (typus=='C'){
   ArrayList<String> lineus = LeeFichero("clientes.txt");
   boolean usernotfound=true;
   for (int i = 0; i < lineus.size(); i++) {
        String[] datuser = lineus.get(i).split(",");
        String ced = datuser[0];
        if(ar[0].equals(ced)){
            System.out.println("Bienvenido de nuevo");
            usernotfound=false;
            return 'C';
        }
       }//for
   if (usernotfound){
      Scanner sc=new Scanner(System.in);
        System.out.println("Por favor, ingrese lo sigueintes datos para continuar");
        System.out.println("Edad: ");
        int age=sc.nextInt();
        sc.nextLine();
        System.out.println("Tarjeta de credito: ");
        String tjc=sc.nextLine();
        String nuevaEntrada = ar[0] + "," + age + "," + tjc;
                
                // Escribir la nueva entrada completa en el archivo
        EscribirArchivo("clientes.txt", nuevaEntrada);
        return 'C'; 
   }
   }//if proncipal
 else{
 return 'R';
 }
 return ' ';
 }//metodo
 
 public void mostrarmenu(char type){
     switch(type){
         case 'C':
             System.out.println("/******************************MENU*********************************+/");
             System.out.println("/*                                                                   /*");
             System.out.println("/********************************************************************+/");
             System.out.println("1.Solicitar servicio de taxi");
             System.out.println("2.Solicitar entrega encomienda");
             System.out.println("3.Consultar servicios");
             Scanner sc=new Scanner(System.in);
             System.out.println("Elija una opcion: ");
             int opc=sc.nextInt();
             sc.nextLine();
             if (opc==1){
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
                 
                 
             }
             
             else if(opc==2){}
             
             else if(opc==3){}
             
             else{
                 System.out.println("Ingrese una opción valida");
             }
             
             break;
         case 'R':
          break;
     
     
     }
 
 }
 
    //public static void main(String[] args){
     //Pruebas p1=new Pruebas();
     //String[] val=p1.iniciarSesion();
     //char tipousma=p1.verificarusuario(val);

       }//main
     
  

    
    
//sistema
