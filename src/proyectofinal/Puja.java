package proyectofinal;

import java.io.Serializable;

public class Puja implements Serializable {
    private String tipoPago;
    private String monto;
    private String nombreComprador;
    private String apellidoComprador;
    private String correoComprador;
    
    public Puja(String tipoPago, String monto, String nombreComprador, 
                String apellidoComprador, String correoComprador) {
        this.tipoPago = tipoPago;
        this.monto = monto;
        this.nombreComprador = nombreComprador;
        this.apellidoComprador = apellidoComprador;
        this.correoComprador = correoComprador;
    }
    
    @Override
    public String toString() {
        return "Comprador: " + nombreComprador + " " + apellidoComprador + 
               "\nCorreo: " + correoComprador + 
               "\nMonto: " + monto + 
               "\nTipo de pago: " + tipoPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getApellidoComprador() {
        return apellidoComprador;
    }

    public void setApellidoComprador(String apellidoComprador) {
        this.apellidoComprador = apellidoComprador;
    }

    public String getCorreoComprador() {
        return correoComprador;
    }

    public void setCorreoComprador(String correoComprador) {
        this.correoComprador = correoComprador;
    }

   
    
    
}