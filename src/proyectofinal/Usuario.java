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
public class Usuario implements Serializable{
    protected String nombre, paterno, materno, correo;
    
    public Usuario(String n, String p, String m, String c){
        nombre=n;
        paterno=p;
        materno=m;
        correo=c;
    }
    
    public void registrar(){
        System.out.println("Usuario registrado");
        System.out.println("Nombre completo: "+nombre+" "+paterno+" "+materno);
        System.out.println("Correo: "+ correo);
    
    }
    public void leer() {
        System.out.println("Ingrese Nombre: ");
    	nombre=Leer.dato();
        System.out.println("Ingrese Paterno: ");
        paterno=Leer.dato();
        System.out.println("Ingrese Materno: ");
        materno=Leer.dato();
        System.out.println("Ingrese Correo: ");
        correo=Leer.dato();
    }
    public void iniciarSesion(){
        System.out.println("Inicio de Sesion de: "+nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
