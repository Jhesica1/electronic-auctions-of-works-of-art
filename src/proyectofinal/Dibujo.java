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
public class Dibujo extends Obra implements Serializable{
    private static final long serialVersionUID = 1L;
    private String tipoLapiz, tipoPapel;
    
    public Dibujo(){
        
    }
    
    public Dibujo(String t, String a, int p, String es,String det, String tl, String tp){
        super(t,a,p,es,det);
        tipoLapiz = tl;
        tipoPapel = tp;
    }
    
    public Dibujo(String t, String a, int p, String es,String det){
        super(t,a,p,es,det); 
    }
    
    public void mostrarDibujo(){
        super.mostrarObra();
        System.out.println("\t"+tipoLapiz+"\t"+tipoPapel);
    }
    public void leer() {
        super.leer();
        System.out.println("Ingrese tipo de lápiz:");
        tipoLapiz = Leer.dato();
        System.out.println("Ingrese tipo de papel:");
        tipoPapel = Leer.dato();
    }

    public String getTipoLapiz() {
        return tipoLapiz;
    }

    public void setTipoLapiz(String tipoLapiz) {
        this.tipoLapiz = tipoLapiz;
    }

    public String getTipoPapel() {
        return tipoPapel;
    }

    public void setTipoPapel(String tipoPapel) {
        this.tipoPapel = tipoPapel;
    }
}