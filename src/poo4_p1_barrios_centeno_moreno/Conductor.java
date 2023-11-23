/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo4_p1_barrios_centeno_moreno;

import java.util.ArrayList;

/**
 *
 * @author grils
 */
public class Conductor extends Usuario{
    private String licencia;  
    private Estado estado; //Actualizacion prueba
    private Vehiculo vehiculo;
    
    public Conductor(String cedula,String nombre,String apellido,int edad,String user,String contrasenia,String celular,TipoUsuario tipoUsuario,
    String licencia,Estado estado,Vehiculo vehiculo){
        super(cedula,nombre,apellido,edad,user,contrasenia,celular,tipoUsuario);
        this.licencia=licencia;
        this.estado=estado;
        this.vehiculo=vehiculo;
    }

    public String getLicencia() {
        return licencia;
    }

    public Estado getEstado() {
        return estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public void consultarServicios() {
        ArrayList<Servicio> serviciosAsignados = new ArrayList<>();
        System.out.println("/**********SERVICIO ASIGNADO***********/");
        System.out.println("/*                                    */");
        
        for(Servicio s: serviciosAsignados){
            if(s instanceof Taxi){
                System.out.println("/***********************************/");
                System.out.println("Tipo: Servicio Taxi");
                System.out.println("Cantidad pasajeros: "+s.getNumPersonas());
                System.out.println("Fecha: "+ s.getFecha());
                System.out.println("Hora: "+s.getHora());
                System.out.println("Desde: "+s.getDesde());
                System.out.println("Hasta: "+s.getHasta());
            }
            else{
                System.out.println("Tipo: Servicio de Encomienda");
                System.out.println("Tipo encomienda: "+s.getTipoE());
                System.out.println("Cantidad: "+ s.getNumProductos());
                System.out.println("Fecha: "+ s.getFecha());
                System.out.println("Hora: "+s.getHora());
                System.out.println("Desde: "+s.getDesde());
                System.out.println("Hasta: "+s.getHasta());
            }
        }
    }
    
    
}