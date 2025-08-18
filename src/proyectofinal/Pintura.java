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
public class Pintura extends Obra implements Serializable{
    private static final long serialVersionUID = 1L;
    private String tecnica;
    private int dimension;
    
    
    public Pintura(){
        
    }
    
    public Pintura(String t, String a, int p, String es,String det, String tec, int dim){
        super(t,a,p,es,det);
        tecnica = tec;
        dimension = dim;
    }
    
    public Pintura(String t, String a, int p, String es,String det){
        super(t,a,p,es,det); 
    }
    
    public void mostrarPintura(){
        super.mostrarObra();
        System.out.println("\t"+tecnica+"\t "+dimension);
    }
    public void leer() {
        super.leer();
        System.out.println("Ingrese técnica:");
        tecnica = Leer.dato();
        System.out.println("Ingrese dimensión :");
        dimension = Leer.datoInt();
        
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public float getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    } 
}