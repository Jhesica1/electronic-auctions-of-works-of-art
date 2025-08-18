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
public class Escultura extends Obra implements Serializable{
    private static final long serialVersionUID = 1L;
    private String material;
    private float peso;
    
    public Escultura(){
        
    }
    
    public Escultura(String t, String a, int p, String es, String det, String m, float pe){
        super(t,a,p,es,det);
        material = m;
        peso = pe;
    }
    
    public Escultura(String t, String a, int p, String es,String det){
        super(t,a,p,es,det); 
    }
    
    public void mostrarEscultura(){
        super.mostrarObra();
        System.out.println("\t"+material+"\t"+peso);
    }
    public void leer() {
        super.leer();
        System.out.println("Ingrese material:");
        material = Leer.dato();
        System.out.println("Ingrese peso:");
        peso = Leer.datoFloat();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}