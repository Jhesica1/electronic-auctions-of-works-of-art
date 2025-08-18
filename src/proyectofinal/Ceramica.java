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
public class Ceramica extends Obra implements Serializable{
    private static final long serialVersionUID = 1L;
    private String tipo, material;
    
    public Ceramica(){
        
    }
    
    public Ceramica(String t, String a, int p, String es,String det, String tip, String mat){
        super(t,a,p,es,det);
        tipo = tip;
        material = mat;
    }
    
    public Ceramica(String t, String a, int p, String es,String det){
        super(t,a,p,es,det); 
    }
    
    public void mostrarCeramica(){
        super.mostrarObra();
        System.out.println("\t"+tipo+"\t"+material);
        
    }
    public void leer() {
        super.leer();
        System.out.println("Ingrese tipo de cerámica:");
        tipo = Leer.dato();
        System.out.println("Ingrese material:");
        material = Leer.dato();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}