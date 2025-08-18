/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author JANDY
 */
public class ArchivoComprador {
    private String nomC;
    
    public ArchivoComprador(){
        nomC = "archivoComprador.dat";
    }
    
    public void crear() throws ClassNotFoundException, IOException {
        Scanner sc=new Scanner(System.in);
        FileOutputStream archi=new FileOutputStream(nomC);
        ObjectOutputStream sal=null;
        try{
            if(new File(nomC).exists()){
                System.out.println("El archivo ya existe...!! Desea eliminar s/n");
                String resp=sc.next();
                if(resp.equals("s"))
                    sal = new ObjectOutputStream(archi);
            }
        else
                sal = new ObjectOutputStream(archi);
        }
        catch(Exception e)
        {
           System.out.println("error de archivo");
        }
        finally{
           sal.close();
           archi.close();
        }
    }
    
    public void adicionar(String nom, String pat, String mat, String cor) throws ClassNotFoundException, IOException {
       if (!new File(nomC).exists()) {
            try (ObjectOutputStream arch = new ObjectOutputStream(new FileOutputStream(nomC))) {
                arch.writeObject(new Comprador(nom, pat, mat, cor));
            }
            return;
        }
       String aux = "aux.dat";
        try (ObjectOutputStream archAux = new ObjectOutputStream(new FileOutputStream(aux));
             ObjectInputStream arch = new ObjectInputStream(new FileInputStream(nomC))) {
            try {
                while (true) {
                    Comprador C = (Comprador) arch.readObject();
                    archAux.writeObject(C);
                }
            } catch (EOFException e) {
                // Fin del archivo, es normal
            }
            archAux.writeObject(new Comprador(nom, pat, mat, cor));
        }
        File viejo = new File(nomC);
        File nuevoArchivo = new File(aux);

        if (viejo.delete()) {
            nuevoArchivo.renameTo(viejo);
        } else {
            System.out.println("No se pudo eliminar el archivo viejo");
        }
    }
    
    public boolean buscarComprador(String nombreBuscado, String paternoBuscado, String maternoBuscado)throws IOException, ClassNotFoundException {   
        FileInputStream archi=new FileInputStream(nomC);
        ObjectInputStream ent=null;
        try{
            ent=new ObjectInputStream(archi);
            while(true){
                    Comprador x=(Comprador)ent.readObject();
                    if (x.getNombre().equalsIgnoreCase(nombreBuscado) && x.getPaterno().equals(paternoBuscado) && x.getMaterno().equalsIgnoreCase(maternoBuscado)) {
                        return true;
                    }
                }
        }    
        catch(Exception e){
                 
        }
        finally{
            ent.close();
            archi.close();
        }
        return false;
    }
    
    public void eliminarComprador(String correo) throws IOException, ClassNotFoundException {
    String aux = "aux.dat";
    boolean encontrado = false;

    File archivoOriginal = new File(nomC);
    File archivoAux = new File(aux);

    try (
        ObjectOutputStream archAux = new ObjectOutputStream(new FileOutputStream(archivoAux));
        ObjectInputStream arch = new ObjectInputStream(new FileInputStream(archivoOriginal));
    ) {
        while (true) {
            try {
                Comprador comprador = (Comprador) arch.readObject();
                if (!comprador.getCorreo().equalsIgnoreCase(correo)) {
                    archAux.writeObject(comprador);
                } else {
                    encontrado = true;
                }
            } catch (EOFException e) {
                break;
            }
        }
    }

    if (!encontrado) {
        archivoAux.delete();
        throw new IOException("Comprador no encontrado con correo: " + correo);
    }

    System.gc(); // Forzar recolección de basura

    if (archivoOriginal.delete()) {
        if (!archivoAux.renameTo(archivoOriginal)) {
            throw new IOException("No se pudo renombrar archivo auxiliar a original.");
        }
    } else {
        throw new IOException("No se pudo eliminar el archivo viejo");
    }
}
}