/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author Jhesi Colque
 */
public class Subasta {
    private String fechaI, fechaF, nombre;
    private int nroPuja;
    private boolean subastaActiva;
    private Puja[] p = new Puja[5000];

    public Subasta() {
        nombre = "Subasta de obras de arte";
        fechaI = "18/10/2025; 12:20";
        fechaF = "18/10/2025; 13:30";
        nroPuja = 0;
        subastaActiva = false;
    }

    public Subasta(String ini, String fn) {
        nombre = "Subasta de obras de arte";
        fechaI = ini;
        fechaF = fn;
        nroPuja = 0;
        subastaActiva = false;
    }

    public void iniciarSubasta() {
        System.out.println("Subasta iniciada");
        subastaActiva = true;
    }

    public void finalizarSubasta() {
        System.out.println("Subasta finalizada");
        subastaActiva = false;
    }

    public void añadirPuja(Puja x) {
        if (!subastaActiva) {
            System.out.println("No se puede añadir puja: subasta inactiva");
            return;
        }

        try {
            double monto = Double.parseDouble(x.getMonto());
            if (monto <= 0) {
                System.out.println("Monto inválido, debe ser mayor a 0");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: El monto no es válido");
            return;
        }

        p[nroPuja] = x;
        System.out.println("Puja añadida en la posición " + nroPuja);
        nroPuja++;
    }

    public void mostrarPujas() {
        System.out.println("=== LISTA DE PUJAS ===");
        if (nroPuja == 0) {
            System.out.println("No hay pujas registradas");
            return;
        }

        for (int i = 0; i < nroPuja; i++) {
            if (p[i] != null) {
                System.out.println("\nPuja #" + (i + 1));
                System.out.println(p[i].toString());
            }
        }
    }

    public void verificarMayorPuja() {
        if (nroPuja == 0) {
            System.out.println("No hay pujas registradas");
            return;
        }

        Puja mayor = p[0];
        double max = Double.parseDouble(mayor.getMonto());

        for (int i = 1; i < nroPuja; i++) {
            double actual = Double.parseDouble(p[i].getMonto());
            if (actual > max) {
                mayor = p[i];
                max = actual;
            }
        }

        System.out.println("\n=== MAYOR PUJA ===");
        System.out.println(mayor.toString());
    }

    public void leerDatosSubasta() {
        System.out.println("Ingrese nombre de la subasta:");
        nombre = Leer.dato();
        System.out.println("Ingrese fecha de inicio:");
        fechaI = Leer.dato();
        System.out.println("Ingrese fecha de fin:");
        fechaF = Leer.dato();
    }
}

