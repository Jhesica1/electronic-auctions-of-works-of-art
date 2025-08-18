package proyectofinal;
    import java.io.*;
    import java.util.function.Consumer;

public class ArchObras {
    private String nom;

    public ArchObras() {
        nom = "archivoObras.dat";
    }
    

    public void crear(String s) throws ClassNotFoundException, IOException {
        
        FileOutputStream archi = new FileOutputStream(nom);
        ObjectOutputStream sal = null;
        try {
            if (new File(nom).exists()) {
                System.out.println("El archivo ya existe...!! Desea eliminar s/n");
                if (s.equals("s"))
                    sal = new ObjectOutputStream(archi);
            } else {
                sal = new ObjectOutputStream(archi);
            }
        } catch (Exception e) {
            System.out.println("Error de archivo");
        } finally {
            if (sal != null) sal.close();
            archi.close();
        }
    }


    
    public void eliminarObra(String correo) throws IOException, ClassNotFoundException {
    String aux = "aux.dat";
    boolean encontrado = false;

    File archivoOriginal = new File(nom);
    File archivoAux = new File(aux);

    try (
        ObjectOutputStream archAux = new ObjectOutputStream(new FileOutputStream(archivoAux));
        ObjectInputStream arch = new ObjectInputStream(new FileInputStream(archivoOriginal));
    ) {
        while (true) {
            try {
                Obra obra = (Obra) arch.readObject();
                if (!obra.getCorreo().equalsIgnoreCase(correo)) {
                    archAux.writeObject(obra);
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
        throw new IOException("Obra no encontrada con correo: " + correo);
    }

    // Asegúrate de que los streams se cerraron antes de eliminar
    System.gc(); // Forzar recolección de basura (opcional, puede ayudar en Windows)

    if (archivoOriginal.delete()) {
        if (!archivoAux.renameTo(archivoOriginal)) {
            throw new IOException("No se pudo renombrar archivo auxiliar a original.");
        }
    } else {
        throw new IOException("No se pudo eliminar el archivo viejo");
    }
}


   public void modificarObra(String correoOriginal, Obra obraActualizada) throws IOException, ClassNotFoundException {
    String aux = "aux.dat";
    boolean encontrado = false;

    File archivoOriginal = new File(nom);
    File archivoAux = new File(aux);

    try (
        ObjectOutputStream archAux = new ObjectOutputStream(new FileOutputStream(archivoAux));
        ObjectInputStream arch = new ObjectInputStream(new FileInputStream(archivoOriginal));
    ) {
        while (true) {
            try {
                Obra obra = (Obra) arch.readObject();
                if (obra.getCorreo().equalsIgnoreCase(correoOriginal)) {
                    archAux.writeObject(obraActualizada); // Modificamos
                    encontrado = true;
                } else {
                    archAux.writeObject(obra); // Copiamos como está
                }
            } catch (EOFException e) {
                break;
            }
        }
    }

    if (!encontrado) {
        archivoAux.delete();
        throw new IOException("Obra no encontrada con correo: " + correoOriginal);
    }

    // Asegúrate de que los streams se hayan cerrado correctamente
    System.gc(); // Opcional pero puede ayudar en Windows

    if (archivoOriginal.delete()) {
        if (!archivoAux.renameTo(archivoOriginal)) {
            throw new IOException("No se pudo renombrar el archivo auxiliar a original.");
        }
    } else {
        throw new IOException("No se pudo eliminar el archivo viejo");
    }
}

    public void adicionar(String corr, String aut, int pBase, String est, String det) throws ClassNotFoundException, IOException {
       if (!new File(nom).exists()) {
            try (ObjectOutputStream arch = new ObjectOutputStream(new FileOutputStream(nom))) {
                arch.writeObject(new Obra(corr,aut,pBase,est,det));
            }
            return;
        }
       String aux = "aux.dat";
        try (ObjectOutputStream archAux = new ObjectOutputStream(new FileOutputStream(aux));
             ObjectInputStream arch = new ObjectInputStream(new FileInputStream(nom))) {
            try {
                while (true) {
                    Obra C = (Obra) arch.readObject();
                    archAux.writeObject(C);
                }
            } catch (EOFException e) {
                // Fin del archivo, es normal
            }
            archAux.writeObject(new Obra(corr,aut,pBase,est,det));
        }
        File viejo = new File(nom);
        File nuevoArchivo = new File(aux);

        if (viejo.delete()) {
            nuevoArchivo.renameTo(viejo);
        } else {
            System.out.println("No se pudo eliminar el archivo viejo");
        }
    }
    
    

    // BUSCAR POR CORREO
   public void buscarObra(String correo, Consumer<Obra> consumer) throws IOException, ClassNotFoundException {
    if (correo == null || consumer == null) return;  // Validación
    
    correo = correo.trim().toLowerCase();  // Normaliza el correo (ej: "Ejemplo@Gmail.com" → "ejemplo@gmail.com")
    
    try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nom))) {
        while (true) {
            try {
                Obra obra = (Obra) entrada.readObject();  // Lee cada obra del archivo
                
                // Compara el correo de la obra con el buscado (insensible a mayúsculas)
                if (obra.getCorreo() != null && 
                    obra.getCorreo().trim().toLowerCase().equals(correo)) {
                    consumer.accept(obra);  // Si coincide, ejecuta el lambda
                }
            } catch (EOFException e) {
                break;  // Fin del archivo
            }
        }
    }
}


   
    public boolean existeCorreoEnExpositor(String correo) throws IOException, ClassNotFoundException {
    FileInputStream archExpositorFis = new FileInputStream("archivoExpositor.dat");
    ObjectInputStream ois = null;
    boolean encontrado = false;
    try {
        ois = new ObjectInputStream(archExpositorFis);
        while (true) {
            Expositor expositor = (Expositor) ois.readObject();
            if (correo.equalsIgnoreCase(expositor.getCorreo())) {
                encontrado = true;
                break;
            }
        }
    } catch (EOFException e) {
        // fin de archivo, salida normal
    } finally {
        if (ois != null) ois.close();
        archExpositorFis.close();
    }
    return encontrado;
}

    
    //BUSCAR POR TIPO
    public void buscarPorTipo(String tipoBuscado, Consumer<Obra> consumer) throws IOException, ClassNotFoundException {
    if (tipoBuscado == null) return;
    
    tipoBuscado = tipoBuscado.trim().toUpperCase();
    
    try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nom))) {
        while (true) {
            try {
                Obra obra = (Obra) entrada.readObject();
                // Busca el tipo dentro del String de detalles
                if (obra.getDetalle() != null) {
                String[] partes = obra.getDetalle().split("-");
                if (partes.length > 0 && partes[0].toUpperCase().contains(tipoBuscado)) {
                    consumer.accept(obra);
                }
}
            } catch (EOFException e) {
                break;
            }
        }
    }
}

   public String getNom() {
        return this.nom;  // Devuelve el nombre del archivo
    }
    
    
}
