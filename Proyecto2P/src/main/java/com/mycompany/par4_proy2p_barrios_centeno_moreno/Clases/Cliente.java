/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases;

/**
 *
 * @author LNV
 */
public class Cliente {
    private String ced;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;

    public Cliente(String ced, String nombre, String apellido, String usuario, String contraseña) {
        this.ced = ced;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    

    public String getCed() {
        return ced;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setCed(String ced) {
        this.ced = ced;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    @Override
    public String toString(){
    return "Nombre: "+this.nombre+"\n"+"Apellido: "+this.apellido+"\n"+"Cédula: "+this.ced+"\n";
    
    }
    
    
}
