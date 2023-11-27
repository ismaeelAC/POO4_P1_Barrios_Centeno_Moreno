/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo4_p1_barrios_centeno_moreno;

/**
 *
 * @author rb122
 */
import java.util.Random;
public class Pago {
    private String idpago;
    private String fecha;
    private Servicio servicio;
    private FormaDePago formaDePago;
    private Cliente cliente;
    private Double subtotal;
    private Double valorPagar;
    
    
 /**
  * Metodo el cual genera aleatoriamente un codigo de identificacion para el pago de un servicio en especifico
  * @return Un codigo numerico que sirve como identificador para un pago realizado
  */
  public int generarIDN() {
        Random rd=new Random();
        int valal=rd.nextInt(1000000000);
        return valal;
    }  
}
