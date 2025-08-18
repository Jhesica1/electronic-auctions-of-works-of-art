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
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *

/**
 *
 * @author Jhesi Colque
 */
public class Obra implements Serializable {
    private static final long serialVersionUID = 1L;
    private String  autor, estadoCompra,correo, detalle;
    private int precioBase;
    private Adjudicacion adjudicacion;
    private int contadorPujas;  // Nuevo campo
    
    public Obra() {
        adjudicacion = null;
    }
    

    public Obra(String t, String a, int p, String es, String det) {
        this();
        correo = t;
        autor = a;
        precioBase = p;
        estadoCompra = es;
        detalle = det;
        this.contadorPujas = 0;
    }
    
    public void leer() {
        System.out.println("Ingrese título:");
        correo = Leer.dato();
        System.out.println("Ingrese autor:");
        autor = Leer.dato();
        System.out.println("Ingrese precio base:");
        precioBase = Leer.datoInt();
        System.out.println("Ingrese estado de compra:");
        estadoCompra = Leer.dato();
    }
    
    public void mostrarObra() {
        System.out.println(correo + "\t " + autor + "\t " + precioBase + "\t " + estadoCompra);

    }

    // Nuevos métodos para adjudicación
    public void adjudicar(Adjudicacion adj) {
        this.adjudicacion = adj;
        this.estadoCompra = "Adjudicada";
    }
    
    public Adjudicacion getAdjudicacion() {
        return adjudicacion;
    }

    public String getTitulo() {
        return correo;
    }

    public void setTitulo(String titulo) {
        this.correo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstadoCompra() {
        return estadoCompra;
    }

    public void setEstadoCompra(String estadoCompra) {
        this.estadoCompra = estadoCompra;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    } 

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    public int getContadorPujas() { return contadorPujas; }
    public void setContadorPujas(int contador) { this.contadorPujas = contador; }
    
}