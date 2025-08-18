/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/C lasses/Class.java to edit this template
 */
package proyectofinal;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author JANDY
 */
public class ArchExpositor {
    private String nomC;
    
    public ArchExpositor(){
        nomC = "archivoExpositor.dat";
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
    
    public void adicionar(String nom, String pat, String mat, String corr) throws ClassNotFoundException, IOException {
       if (!new File(nomC).exists()) {
            try (ObjectOutputStream arch = new ObjectOutputStream(new FileOutputStream(nomC))) {
                arch.writeObject(new Expositor(nom, pat, mat, corr));
            }
            return;
        }
       String aux = "aux.dat";
        try (ObjectOutputStream archAux = new ObjectOutputStream(new FileOutputStream(aux));
             ObjectInputStream arch = new ObjectInputStream(new FileInputStream(nomC))) {
            try {
                while (true) {
                    Expositor C = (Expositor) arch.readObject();
                    archAux.writeObject(C);
                }
            } catch (EOFException e) {
                // Fin del archivo, es normal
            }
            archAux.writeObject(new Expositor(nom, pat, mat, corr));
        }
        File viejo = new File(nomC);
        File nuevoArchivo = new File(aux);

        if (viejo.delete()) {
            nuevoArchivo.renameTo(viejo);
        } else {
            System.out.println("No se pudo eliminar el archivo viejo");
        }
    }
    
    public boolean buscarExpositor(String nombreBuscado, String paternoBuscado, String maternoBuscado)throws IOException, ClassNotFoundException {   
        FileInputStream archi=new FileInputStream(nomC);
        ObjectInputStream ent=null;
        try{
            ent=new ObjectInputStream(archi);
            while(true){
                    Expositor x=(Expositor)ent.readObject();
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
    
    public Expositor buscarExpositorPorCorreo(String correoBuscado) {
    if (correoBuscado == null) {
        return null;
    }
    try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nomC))) {
        while (true) {
            try {
                Expositor expositor = (Expositor) entrada.readObject();
                String correoActual = expositor.getCorreo();
                // Comparación segura contra null
                if (correoActual != null && correoActual.equalsIgnoreCase(correoBuscado)) {
                    return expositor;
                }
            } catch (EOFException e) {
                break; // Fin del archivo
            }
        }
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    return null; // No se encontró
}
    
    public void eliminarExpositor(String correo) throws IOException, ClassNotFoundException {
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
                Expositor expositor = (Expositor) arch.readObject();
                if (!expositor.getCorreo().equalsIgnoreCase(correo)) {
                    archAux.writeObject(expositor);
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
        throw new IOException("Expositor no encontrado con correo: " + correo);
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
