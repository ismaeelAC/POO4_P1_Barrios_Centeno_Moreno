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
    
    private Estado estado; 
    private Vehiculo vehiculo;
    
    public Conductor(String cedula,String nombre,String apellido,int edad,String user,String contrasenia,String celular,TipoUsuario tipoUsuario,Estado estado,Vehiculo vehiculo){
        super(cedula,nombre,apellido,edad,user,contrasenia,celular,tipoUsuario);
        
        this.estado=estado;
        this.vehiculo=vehiculo;
    }

    public Estado getEstado() {
        return estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }


    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

  @Override 
  public void consultarServicios(ArrayList<Servicio> serv) {
  if (serv.isEmpty()) {
       System.out.println("No tiene asignado ningún servicio");
    } else {
        for(int i=0; i<serv.size();i++){
        if(this.getNombre().equals(serv.get(i).getNombreConductor())){
            System.out.println(serv.get(i));
        }    
            
        }
  }
    }
}
