/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author Jhesi Colque
 */
public class Expositor extends Usuario {
    private String tipoAutenticacionObra;
    private int nObra;
    private Obra[] n = new Obra[10];
    
    public Expositor(String nombre, String paterno, String materno, String correo) {
        super(nombre, paterno, materno, correo);
    }
  
    public void registrarObra(Obra obra) {
        if (nObra < 10) {
            n[nObra] = obra;
            System.out.println("Obra registrada: " + obra.getTitulo()); // Accedemos a la obra recién asignada
            nObra++; // Incrementamos después de usar el índice
        } else {
            System.out.println("No se puede agregar más obras. Límite alcanzado.");
        }          
    }
    public void leer() {
        super.leer();
        System.out.println("Ingrese tipo de autenticación de obra:");
        tipoAutenticacionObra = Leer.dato();
    }

    public void agregarObra(Obra obra) {
        registrarObra(obra);
    }

    public String getTipoAutenticacionObra() {
        return tipoAutenticacionObra;
    }

    public void setTipoAutenticacionObra(String tipoAutenticacionObra) {
        this.tipoAutenticacionObra = tipoAutenticacionObra;
    }

    public int getnObra() {
        return nObra;
    }

    public void setnObra(int nObra) {
        this.nObra = nObra;
    }

    public Obra getN(int i) {
        return n[i];
    }

    public void setN(Obra n, int i) {
        this.n[i] = n;
    }  
}
