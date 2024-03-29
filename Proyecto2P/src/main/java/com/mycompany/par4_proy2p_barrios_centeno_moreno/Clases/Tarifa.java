/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.par4_proy2p_barrios_centeno_moreno.Clases;

import com.mycompany.par4_proy2p_barrios_centeno_moreno.App;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author LNV
 */
public class Tarifa {
    private String nombre;
    private String tipo;
    private ArrayList<String> listaofcarac;
    private int porcentaje;

    public Tarifa(String nombre, String tipo, ArrayList<String> listaofcarac, int porcentaje) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.listaofcarac = listaofcarac;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public ArrayList<String> getListaofcarac() {
        return listaofcarac;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setListaofcarac(ArrayList<String> listaofcarac) {
        this.listaofcarac = listaofcarac;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    /**
     * El método leerdatostarifa permite leer el archivo tarrifas y construir cada uno de los objeto de tipo Tarifa y almacenarlos en un ArrayList correspondiente.
     * @return 
     */
    public static ArrayList<Tarifa> leerdatostarifa(){
    ArrayList<Tarifa> Tarifaobjects=new ArrayList<>();
    try(BufferedReader bf=new BufferedReader(new FileReader(App.pathachiInput+"tarifas.txt"))){
    String primeralinea=bf.readLine();
    String linea;
    while((linea=bf.readLine())!=null){
    String[] datarifa=linea.trim().split(",");
    String[] charac=datarifa[2].split("-");
    ArrayList<String> caract = new ArrayList<>();
    for(String st: charac){
    caract.add(st);
    }
    Tarifa tI=new Tarifa(datarifa[0],datarifa[1],caract,Integer.valueOf(datarifa[3]));
    Tarifaobjects.add(tI);
    }
    }catch(FileNotFoundException e){
        System.out.println("No se ha encontrado el archivo");
    }catch(IOException e2){
        System.out.println(e2.getMessage());
    }
    return Tarifaobjects;
    }
    
    
}
