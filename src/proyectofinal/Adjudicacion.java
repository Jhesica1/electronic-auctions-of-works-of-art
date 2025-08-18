/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import java.io.Serializable;

/**
 *
 * @author Jhesi Colque
 */
public class Adjudicacion implements Serializable{
    private static final long serialVersionUID = 1L;
    private String estadoPago,fechaEntrega;
    
    public Adjudicacion(){
        
    }
    
    public Adjudicacion(String ep, String fe){
        estadoPago = ep;
        fechaEntrega = fe;
    }
    
    public void mostrarAdjudicacion(){
        System.out.println("---- ADJUDICACION ----");
        System.out.println("Estado de Pago: "+estadoPago);
        System.out.println("Fecha de Entrega: "+fechaEntrega);
        System.out.println("----------------------");
    }
    public void leer() {
        System.out.println("Ingrese estado de pago:");
        estadoPago = Leer.dato();
        System.out.println("Ingrese fecha de entrega:");
        fechaEntrega = Leer.dato();
    }
    
    public void registrarPago(){
        estadoPago = "Pagado";
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
