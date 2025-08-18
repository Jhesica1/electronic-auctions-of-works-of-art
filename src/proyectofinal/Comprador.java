/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;
import java.util.*;
import java.io.Serializable;
/**
 *
 * @author Jhesi Colque
 */
public class Comprador extends Usuario implements Serializable {
    private String tipoDePago;
    private Obra[] obrasAdjudicadas = new Obra[100]; 
    private int numObrasAdjudicadas = 0;
    
    public Comprador(String n, String p, String m, String c) {
        super(n, p, m, c);
    }
    
    public Comprador(String n, String p, String m, String c, String t) {
        super(n, p, m, c);
        tipoDePago = t;
    }
   
    // Añadir obra adjudicada
    public void añadirObraAdjudicada(Obra obra) {
        if(numObrasAdjudicadas < 100) {
            obrasAdjudicadas[numObrasAdjudicadas] = obra;
            numObrasAdjudicadas++;
            System.out.println("Obra adjudicada registrada para " + nombre);
        } else {
            System.out.println("Límite de obras adjudicadas alcanzado");
        }
    }
    
    // Mostrar obras adjudicadas
    public void mostrarObrasAdjudicadas() {
        System.out.println("\nObras adjudicadas a " + nombre + ":");
        for(int i = 0; i < numObrasAdjudicadas; i++) {
            if(obrasAdjudicadas[i] != null) {
                obrasAdjudicadas[i].mostrarObra();
            }
        }
    }
    
    public void pujar(double monto){
        System.out.println(nombre+" ha realizado una puja de "+monto);
        System.out.println("Metodo de pago: "+tipoDePago);
        
    }
    public void leer() {
    	super.leer();
        System.out.println("Ingrese metodo de pago: ");
    	tipoDePago=Leer.dato();
    }
    
    public String getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
    }
    
    

}