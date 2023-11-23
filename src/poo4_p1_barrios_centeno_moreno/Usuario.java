/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo4_p1_barrios_centeno_moreno;

/**
 *
 * @author grils
 */
public abstract class Usuario {
    private String cedula;
    private String nombre;
    private String apellido;
    private int edad;
    private String user;
    private String contrasenia;
    private String celular;
    

    public Usuario(String cedula,String nombre,String apellido,int edad,String user,String contrasenia,String celular,TipoUsuario tipoUsuario){
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.user=user;
        this.contrasenia=contrasenia;
        this.celular=celular;
        this.tipoUsuario=tipoUsuario;
    }
    
    //getters
    public String getCedula() {
        return cedula;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getApellido(){
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getUser() {
        return user;
    }
    
    public String getContrasenia(){
        return contrasenia;
    }

    public String getCelular() {
        return celular;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
    
    //setters

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
  
    public abstract void consultarServicios();
  
    
}

